package com.example.androidlearning;

import com.google.gson.annotations.SerializedName;

public class RetrofitDemoComment {

    private int postId;

    @SerializedName("id")
    private int userId;

    @SerializedName("name")
    private String userName;

    @SerializedName("email")
    private String emailAddress;

    @SerializedName("body")
    private String emailBody;

    public int getUserId() {
        return userId;
    }

    public int getPostId() {
        return postId;
    }

    public String getUserName() {
        return userName;
    }

    public String getEmailAddress() {
        return emailAddress;
    }

    public String getEmailBody() {
        return emailBody;
    }
}
