package com.tuan1611pupu.vishort.Adapter;

import android.app.Activity;
import android.net.Uri;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.MediaController;
import android.widget.VideoView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.tuan1611pupu.vishort.Model.UserPostVideo;
import com.tuan1611pupu.vishort.R;
import com.tuan1611pupu.vishort.databinding.ItemPostVideoBinding;

import java.util.ArrayList;
import java.util.List;


public class UserPostVideoAdapter extends RecyclerView.Adapter<UserPostVideoAdapter.UserPostVideoViewHolder>{

    private List<UserPostVideo> userPostVideos = new ArrayList<>();

    OnItemUserVideoClick onItemUserVideoClick;
    public OnItemUserVideoClick getOnItemUserVideoClick(){
        return onItemUserVideoClick;
    }
    public void setOnItemUserVideoClick(OnItemUserVideoClick onItemUserVideoClick){
        this.onItemUserVideoClick = onItemUserVideoClick;
    }

    public void setData(List<UserPostVideo> list){
        this.userPostVideos = list;
        notifyDataSetChanged();
    }
    public interface OnItemUserVideoClick {
        void onClick();
    }
    @NonNull
    @Override
    public UserPostVideoViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new UserPostVideoViewHolder(LayoutInflater.from(parent.getContext()).inflate(R.layout.item_post_video, parent, false));
    }

    @Override
    public void onBindViewHolder(@NonNull UserPostVideoViewHolder holder, int position) {
        holder.setData(position);

    }

    @Override
    public int getItemCount() {
        if(userPostVideos != null) return userPostVideos.size();
        return 0;
    }

    public class UserPostVideoViewHolder extends RecyclerView.ViewHolder{
        ItemPostVideoBinding binding;
        private VideoView videoView;

        public UserPostVideoViewHolder(@NonNull View itemView) {
            super(itemView);
            binding = ItemPostVideoBinding.bind(itemView);
        }

        public void setData(int position){
            UserPostVideo post = userPostVideos.get(position);
            videoView = itemView.findViewById(R.id.videoView);
            MediaController mediaController = new MediaController(itemView.getContext());
            mediaController.setMediaPlayer(videoView);
            videoView.setMediaController(mediaController);
            videoView.setVideoURI(Uri.parse(post.getVideoUrl()));
            videoView.start();

            if(post.getBio().equals("")){
                binding.bio.setVisibility(View.GONE);
            } else {
                binding.bio.setVisibility(View.VISIBLE);
                binding.bio.setText(post.getBio());
            }
            itemView.setOnClickListener(v-> onItemUserVideoClick.onClick());

        }
    }
}
