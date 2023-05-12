package com.tuan1611pupu.vishort.Activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentTransaction;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;

import com.iammert.library.readablebottombar.ReadableBottomBar;
import com.tuan1611pupu.vishort.Fragment.HomeFragment;
import com.tuan1611pupu.vishort.Fragment.NotificationFragment;
import com.tuan1611pupu.vishort.Fragment.ProfileFragment;
import com.tuan1611pupu.vishort.Fragment.SearchUserFragment;
import com.tuan1611pupu.vishort.R;
import com.tuan1611pupu.vishort.databinding.ActivityMainBinding;

public class MainActivity extends AppCompatActivity {
    private ActivityMainBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        setSupportActionBar(binding.toolbar);
        MainActivity.this.setTitle("My Profile");

        FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
        binding.toolbar.setVisibility(View.GONE);
        transaction.replace(R.id.container,new HomeFragment());
        transaction.commit();

        binding.readableBottomBar.setOnItemSelectListener(i -> {
            FragmentTransaction transaction1 = getSupportFragmentManager().beginTransaction();

            switch (i){
                case 0:
                    binding.toolbar.setVisibility(View.GONE);
                    transaction1.replace(R.id.container,new HomeFragment());
                    break;
                case 1:
                    binding.toolbar.setVisibility(View.GONE);
                    transaction1.replace(R.id.container,new SearchUserFragment());
                    break;
                case 2:
                    binding.toolbar.setVisibility(View.GONE);
                    Intent intent = new Intent(getApplicationContext(),RecorderActivity.class);
                    startActivity(intent);
                    break;
                case 3:
                    binding.toolbar.setVisibility(View.GONE);
                    transaction1.replace(R.id.container,new NotificationFragment());
                    break;
                case 4:
                    binding.toolbar.setVisibility(View.VISIBLE);
                    transaction1.replace(R.id.container,new ProfileFragment());
                    break;
            }
            transaction1.commit();
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_item,menu);
        return true;
    }

}