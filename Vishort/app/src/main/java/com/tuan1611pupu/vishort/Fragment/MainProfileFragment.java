package com.tuan1611pupu.vishort.Fragment;

import android.content.Intent;
import android.os.Bundle;
import android.se.omapi.Session;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.databinding.DataBindingUtil;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.GridLayoutManager;

import com.tuan1611pupu.vishort.Activity.EditActivity;
import com.tuan1611pupu.vishort.Activity.LogInActivity;
import com.tuan1611pupu.vishort.Activity.SettingActivity;
import com.tuan1611pupu.vishort.Adapter.UserPostVideoAdapter;
import com.tuan1611pupu.vishort.R;
import com.tuan1611pupu.vishort.databinding.FragmentMainProfileBinding;

import org.checkerframework.checker.nullness.qual.NonNull;
import org.checkerframework.checker.nullness.qual.Nullable;

public class MainProfileFragment extends Fragment {
    FragmentMainProfileBinding binding;
    UserPostVideoAdapter userPostVideoAdapter;



    @NonNull
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_main_profile, container, false);
        initView();
        return  binding.getRoot();
    }
    private void initView(){
        userPostVideoAdapter = new UserPostVideoAdapter();

        GridLayoutManager gridLayoutManager = new GridLayoutManager(this.getActivity(), 2);
        binding.rvPostVideo.setLayoutManager(gridLayoutManager);
        binding.rvPostVideo.setAdapter(userPostVideoAdapter);
        userPostVideoAdapter.setOnItemUserVideoClick(()->{
            Intent i = new Intent(getActivity(), HomeFragment.class);
            startActivity(i);
        });
//        binding.setting.setOnClickListener(v->{
//            Intent i = new Intent(getActivity(), SettingActivity.class);
//            startActivity(i);
//        });
        binding.edit.setOnClickListener(v -> {
            Intent i = new Intent(getActivity(), EditActivity.class);
            startActivity(i);
        });
        binding.signout.setOnClickListener(v->{
            Intent i = new Intent(getActivity(), LogInActivity.class);
            startActivity(i);
        });
    }
}
