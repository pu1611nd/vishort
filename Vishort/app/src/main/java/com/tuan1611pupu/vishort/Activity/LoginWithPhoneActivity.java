package com.tuan1611pupu.vishort.Activity;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.view.View;
import android.widget.Toast;

import com.google.firebase.FirebaseException;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.PhoneAuthCredential;
import com.google.firebase.auth.PhoneAuthProvider;
import com.google.firebase.firestore.DocumentSnapshot;
import com.google.firebase.firestore.FirebaseFirestore;
import com.tuan1611pupu.vishort.R;
import com.tuan1611pupu.vishort.Utilities.Constants;
import com.tuan1611pupu.vishort.Utilities.PreferenceManager;
import com.tuan1611pupu.vishort.databinding.ActivityLoginWithPhoneBinding;

import java.util.concurrent.TimeUnit;

public class LoginWithPhoneActivity extends AppCompatActivity {
    private ActivityLoginWithPhoneBinding binding;

    private String verificationId1;
    private PreferenceManager preferenceManager;

    private FirebaseAuth firebaseAuth;
    private FirebaseFirestore database;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityLoginWithPhoneBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        firebaseAuth = FirebaseAuth.getInstance();
        database = FirebaseFirestore.getInstance();
        preferenceManager = new PreferenceManager(getApplicationContext());

        binding.buttonverify.setOnClickListener(v->{
            Intent intent = new Intent(getApplicationContext(),MainActivity.class);
            startActivity(intent);
        });

        sendOTP();

    }


    private void sendOTP(){
        binding.buttonGetOTP.setOnClickListener(v -> {
            if(binding.inputMobile.getText().toString().trim().isEmpty()){
                Toast.makeText(getApplicationContext(), "Enter phone number", Toast.LENGTH_SHORT).show();
                return;
            }else {
                binding.progressBar.setVisibility(View.VISIBLE);
                binding.buttonGetOTP.setVisibility(View.INVISIBLE);
                PhoneAuthProvider.getInstance().verifyPhoneNumber(
                        "+84"+binding.inputMobile.getText().toString(),
                        60,
                        TimeUnit.SECONDS,
                        LoginWithPhoneActivity.this,
                        new PhoneAuthProvider.OnVerificationStateChangedCallbacks(){
                            @Override
                            public void onVerificationCompleted(@NonNull PhoneAuthCredential phoneAuthCredential) {
                                binding.progressBar.setVisibility(View.GONE);
                                binding.buttonGetOTP.setVisibility(View.VISIBLE);
                            }

                            @Override
                            public void onVerificationFailed(@NonNull FirebaseException e) {
                                binding.progressBar.setVisibility(View.GONE);
                                binding.buttonGetOTP.setVisibility(View.VISIBLE);
                                Toast.makeText(getApplicationContext(), e.getMessage(), Toast.LENGTH_SHORT).show();
                                Log.d("aaaa",e.getMessage());
                            }

                            @Override
                            public void onCodeSent(@NonNull String verificationId, @NonNull PhoneAuthProvider.ForceResendingToken forceResendingToken) {
                                binding.progressBar.setVisibility(View.GONE);
                                binding.buttonGetOTP.setVisibility(View.VISIBLE);
                                GetOTP(binding.inputMobile.getText().toString(),verificationId);
                            }
                        }

                );

            }
        });
    }

    private void signIn() {
        FirebaseFirestore database = FirebaseFirestore.getInstance();
        database.collection(Constants.KEY_COLLECTION_USERS)
                .whereEqualTo(Constants.KEY_EMAIL,binding.inputMobile.getText().toString())
                .get()
                .addOnCompleteListener(task -> {
                    if(task.isSuccessful() && task.getResult() != null && task.getResult().getDocuments().size() > 0){
                        DocumentSnapshot documentSnapshot = task.getResult().getDocuments().get(0);
                        preferenceManager.putBoolean(Constants.KEY_IS_SIGNED_IN,true);
                        preferenceManager.putString(Constants.KEY_USER_ID,documentSnapshot.getId());
                        preferenceManager.putString(Constants.KEY_USER_NAME,documentSnapshot.getString(Constants.KEY_USER_NAME));
                        preferenceManager.putString(Constants.KEY_EMAIL,documentSnapshot.getString(Constants.KEY_EMAIL));
                        preferenceManager.putString(Constants.KEY_IMAGE,documentSnapshot.getString(Constants.KEY_IMAGE));
                        Intent intent = new Intent(getApplicationContext(), MainActivity.class);
                        intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK);
                        startActivity(intent);
                    }else{
                        // chuyen sang man hinh dang ky
                        Intent intent = new Intent(getApplicationContext(), RegisterActivity.class);
                        intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK);
                        startActivity(intent);
                    }
                });
    }


    private void GetOTP(String mobile,String verificationId){

        verificationId1 = verificationId;

        setupOTPInput();

        binding.buttonverify.setOnClickListener(v ->{
            if(binding.inputCode1.getText().toString().trim().isEmpty() ||
                    binding.inputCode2.getText().toString().trim().isEmpty() ||
                    binding.inputCode3.getText().toString().trim().isEmpty() ||
                    binding.inputCode4.getText().toString().trim().isEmpty() ||
                    binding.inputCode5.getText().toString().trim().isEmpty() ||
                    binding.inputCode6.getText().toString().trim().isEmpty() ){
                Toast.makeText(getApplicationContext(), "nhap du code", Toast.LENGTH_SHORT).show();
                return;
            }
            String code = binding.inputCode1.getText().toString() +
                    binding.inputCode2.getText().toString() +
                    binding.inputCode3.getText().toString() +
                    binding.inputCode4.getText().toString() +
                    binding.inputCode5.getText().toString() +
                    binding.inputCode6.getText().toString() ;
            if(verificationId1 != null) {
                binding.progressBar2.setVisibility(View.VISIBLE);
                binding.buttonverify.setVisibility(View.INVISIBLE);
                PhoneAuthCredential phoneAuthCredential = PhoneAuthProvider.getCredential(
                        verificationId1,
                        code
                );
                firebaseAuth.signInWithCredential(phoneAuthCredential)
                        .addOnCompleteListener(task -> {
                            binding.progressBar2.setVisibility(View.GONE);
                            binding.buttonverify.setVisibility(View.VISIBLE);
                            if(task.isSuccessful()){
                                //SingIn(inputMobile.getText().toString());
                                // kiem tra xem co dang ky chua neu chua thi hien man hinh dang ky
                                signIn();
                            }else{
                                Toast.makeText(getApplicationContext(), "code khong dung", Toast.LENGTH_SHORT).show();
                            }
                        });

            }

        });
        binding.textResendOTP.setOnClickListener(v ->{
            PhoneAuthProvider.getInstance().verifyPhoneNumber(
                    "+84"+mobile,
                    60,
                    TimeUnit.SECONDS,
                    LoginWithPhoneActivity.this,
                    new PhoneAuthProvider.OnVerificationStateChangedCallbacks(){
                        @Override
                        public void onVerificationCompleted(@NonNull PhoneAuthCredential phoneAuthCredential) {

                        }

                        @Override
                        public void onVerificationFailed(@NonNull FirebaseException e) {

                            Toast.makeText(getApplicationContext(), e.getMessage(), Toast.LENGTH_SHORT).show();
                        }

                        @Override
                        public void onCodeSent(@NonNull String newVerificationId, @NonNull PhoneAuthProvider.ForceResendingToken forceResendingToken) {
                            verificationId1 = newVerificationId;
                            Toast.makeText(getApplicationContext(), "OTP sent", Toast.LENGTH_SHORT).show();
                        }
                    }

            );
        });


    }





    //////////
    private void setupOTPInput(){
        binding.inputCode1.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                if(!s.toString().trim().isEmpty()){
                    binding.inputCode2.requestFocus();
                }
            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });
        binding.inputCode2.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                if(!s.toString().trim().isEmpty()){
                    binding.inputCode3.requestFocus();
                }
            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });
        binding.inputCode3.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                if(!s.toString().trim().isEmpty()){
                    binding.inputCode4.requestFocus();
                }
            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });
        binding.inputCode4.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                if(!s.toString().trim().isEmpty()){
                    binding.inputCode5.requestFocus();
                }
            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });
        binding.inputCode5.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                if(!s.toString().trim().isEmpty()){
                    binding.inputCode6.requestFocus();
                }
            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });
    }

}