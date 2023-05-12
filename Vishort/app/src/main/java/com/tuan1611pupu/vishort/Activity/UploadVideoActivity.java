package com.tuan1611pupu.vishort.Activity;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import com.tuan1611pupu.vishort.databinding.ActivityUploadVideoBinding;

public class UploadVideoActivity extends AppCompatActivity {

    private ActivityUploadVideoBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityUploadVideoBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

    }
}