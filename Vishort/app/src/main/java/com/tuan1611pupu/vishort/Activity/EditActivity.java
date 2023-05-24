package com.tuan1611pupu.vishort.Activity;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import com.tuan1611pupu.vishort.R;
import com.tuan1611pupu.vishort.databinding.ActivityEditBinding;

public class EditActivity extends AppCompatActivity {
    ActivityEditBinding binding;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityEditBinding.inflate(getLayoutInflater());
        initView();
        setContentView(binding.getRoot());
    }

    private void initView() {
        binding.close.setOnClickListener(v -> finish());
        binding.done.setOnClickListener(v -> finish());
    }
}