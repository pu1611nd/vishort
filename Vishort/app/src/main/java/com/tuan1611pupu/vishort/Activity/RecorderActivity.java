package com.tuan1611pupu.vishort.Activity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;

import com.tuan1611pupu.vishort.R;
import com.tuan1611pupu.vishort.databinding.ActivityRecorderBinding;

public class RecorderActivity extends AppCompatActivity {
    private ActivityRecorderBinding binding;

    private boolean isStarted = false;
    private int seconds = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityRecorderBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        // close
        binding.close.setOnClickListener(v->{
            Intent intent = new Intent(getApplicationContext(),MainActivity.class);
            startActivity(intent);
            finish();
        });
        binding.filter.setOnClickListener(v->{
            Intent intent = new Intent(getApplicationContext(),FilterActivity.class);
            startActivity(intent);
        });

        binding.record.setOnClickListener(v ->{
            if (!isStarted) {
                isStarted = true;
                startTimer();
            } else {
                isStarted = false;
                stopTimer();

            }
        });


    }

    // Hàm bắt đầu timer
    private void startTimer() {
        runOnUiThread(new Runnable() {
            @Override
            public void run() {
                new android.os.Handler().postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        if (isStarted) {
                            seconds++;
                            startTimer();
                        }
                    }
                }, 1000);
            }
        });
    }

    // Hàm dừng timer
    private void stopTimer() {
        seconds = 0;
    }
}