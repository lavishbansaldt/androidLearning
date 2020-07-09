package com.example.androidlearning;

import com.google.gson.annotations.SerializedName;

public class RetrofitDemoPost {
    private int userId;

    @SerializedName("id")
    private Integer postId;

    @SerializedName("title")
    private String postTitle;

    @SerializedName("body")
    private String postBody;

    public RetrofitDemoPost(int userId, String postTitle, String postBody){
        this.userId = userId;
        this.postTitle = postTitle;
        this.postBody = postBody;
    }

    public int getUserId() {
        return userId;
    }

    public int getPostId() {
        return postId;
    }

    public String getPostTitle() {
        return postTitle;
    }

    public String getPostBody() {
        return postBody;
    }
}
