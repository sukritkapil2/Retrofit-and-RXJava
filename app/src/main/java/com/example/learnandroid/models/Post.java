package com.example.learnandroid.models;

import com.google.gson.annotations.SerializedName;

public class Post {

    @SerializedName("name")
    private String name;

    @SerializedName("createdAt")
    private String createdAt;

    @SerializedName("avatar")
    private String avatar;

    public Post(String name, String createdAt, String avatar) {
        this.name = name;
        this.createdAt = createdAt;
        this.avatar = avatar;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(String createdAt) {
        this.createdAt = createdAt;
    }

    public String getAvatar() {
        return avatar;
    }

    public void setAvatar(String avatar) {
        this.avatar = avatar;
    }
}
