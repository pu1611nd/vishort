package com.tuan1611pupu.vishort.Adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.core.content.ContextCompat;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.tuan1611pupu.vishort.Model.FollowUser;
import com.tuan1611pupu.vishort.R;
import com.tuan1611pupu.vishort.databinding.ItemFollowingListBinding;


import java.util.ArrayList;
import java.util.List;

public class FollowerUserAdapter extends RecyclerView.Adapter<FollowerUserAdapter.FollowerUserViewHolder> {
    Context context;
    List<FollowUser> followUserList = new ArrayList<>();

    public FollowerUserAdapter(Context context, List<FollowUser> followUserList) {
        this.context = context;
        this.followUserList = followUserList;
    }

    @NonNull
    @Override

    public FollowerUserAdapter.FollowerUserViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        context = parent.getContext();
        return new FollowerUserViewHolder(LayoutInflater.from(parent.getContext()).inflate(R.layout.item_following_list, parent, false));
    }

    @Override
    public void onBindViewHolder(@NonNull FollowerUserAdapter.FollowerUserViewHolder holder, int position) {
        holder.setData(position);
    }

    @Override
    public int getItemCount() {
        return followUserList.size();
    }

    public class FollowerUserViewHolder extends RecyclerView.ViewHolder{
        ItemFollowingListBinding binding;
        public FollowerUserViewHolder(@NonNull View itemView) {
            super(itemView);
            binding = ItemFollowingListBinding.bind(itemView);
        }

        public void setData(int position) {
            FollowUser user = followUserList.get(position);
            Glide.with(binding.getRoot()).load(user.getImage()).into(binding.thumbnail);
            binding.name.setText(user.getName());
            binding.userName.setText(user.getUserName());
            if(user.isFollowed()){
                binding.btnFollow.setBackground(ContextCompat.getDrawable(context, R.drawable.shape_lightblue));
                binding.btnFollow.setText(R.string.follow);
            } else {
                binding.btnFollow.setBackground(ContextCompat.getDrawable(context, R.drawable.shape_following));
                binding.btnFollow.setText(R.string.followings);
            }

        }
    }
}
