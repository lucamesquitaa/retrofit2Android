package com.lucamesquitaa.testretrofit2;

import androidx.annotation.NonNull;

import com.google.gson.annotations.SerializedName;

public class Posts {
    @SerializedName("userId")
    private int userId;
    @SerializedName("id")
    private int id;
    @SerializedName("title")
    private String title;
    @SerializedName("body")
    private String body;

    public int getUserId() {
        return userId;
    }

    @NonNull
    @Override
    public String toString() {
        return " UserId: " + getUserId() + " \n Id: " + getId() +
                "  \n Title: " + getTitle() +"\n body: " + getBody() ;
    }

    public Posts(int userId, int id, String title, String body) {
        this.userId = userId;
        this.id = id;
        this.title = title;
        this.body = body;
    }

    public int getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public String getBody() {
        return body;
    }


}
