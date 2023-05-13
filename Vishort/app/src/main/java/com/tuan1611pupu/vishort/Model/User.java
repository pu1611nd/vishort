package com.tuan1611pupu.vishort.Model;

public class User {
    String bio;
    String username;
    String email;
    String image;
    String provider;
    String id;

    public User(String bio, String username, String email, String image, String provider,  String id) {

        this.bio = bio;
        this.username = username;
        this.email = email;
        this.image = image;
        this.provider = provider;
        this.id = id;
    }

    public User() {
    }




    public String getBio() {
        return bio;
    }

    public void setBio(String bio) {
        this.bio = bio;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public String getProvider() {
        return provider;
    }

    public void setProvider(String provider) {
        this.provider = provider;
    }


    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }
}
