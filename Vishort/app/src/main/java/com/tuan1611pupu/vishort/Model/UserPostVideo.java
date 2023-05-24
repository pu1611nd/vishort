package com.tuan1611pupu.vishort.Model;

public class UserPostVideo {
    private String bio;
    private String videoUrl;
    public UserPostVideo(String bio, String videoUrl) {
        this.bio = bio;
        this.videoUrl = videoUrl;
    }

    public String getBio() {
        return bio;
    }

    public String getVideoUrl() {
        return videoUrl;
    }

    public void setBio(String bio) {
        this.bio = bio;
    }

    public void setVideoUrl(String videoUrl) {
        this.videoUrl = videoUrl;
    }



}
