package com.tuan1611pupu.vishort.Model;

public class FollowUser {
    private String name;
    private String userName;
    private String image;
    boolean isFollowed;

    public FollowUser(String name, String userName, String image, boolean isFollowed) {
        this.name = name;
        this.userName = userName;
        this.image = image;
        this.isFollowed = isFollowed;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public boolean isFollowed() {
        return isFollowed;
    }

    public void setFollowed(boolean followed) {
        isFollowed = followed;
    }
}
