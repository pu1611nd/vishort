package com.tuan1611pupu.vishort.Activity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;

import com.tuan1611pupu.vishort.R;
import com.tuan1611pupu.vishort.databinding.ActivityLoginWithPhoneBinding;

public class LoginWithPhoneActivity extends AppCompatActivity {
    private ActivityLoginWithPhoneBinding binding;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityLoginWithPhoneBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        binding.buttonverify.setOnClickListener(v->{
            Intent intent = new Intent(getApplicationContext(),MainActivity.class);
            startActivity(intent);
        });
    }
}