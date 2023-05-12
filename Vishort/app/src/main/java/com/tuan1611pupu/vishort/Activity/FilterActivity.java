package com.tuan1611pupu.vishort.Activity;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import com.tuan1611pupu.vishort.R;
import com.tuan1611pupu.vishort.databinding.ActivityFilterBinding;

public class FilterActivity extends AppCompatActivity {

    private ActivityFilterBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityFilterBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        binding.back.setOnClickListener(v->{
            finish();
        });

    }
}