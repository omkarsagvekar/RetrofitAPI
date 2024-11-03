package com.os.retrofitexample;

import com.google.gson.annotations.SerializedName;

public class ModelClass {
    private int userId;
    private int id;
    private String title;
    @SerializedName("body") //If json field name is different than model class field name.
    private String subtitle;

    public int getUserId() {
        return userId;
    }

    public int getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public String getSubtitle() {
        return subtitle;
    }
}
