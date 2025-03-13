package com.example.baitap06;

import com.google.gson.annotations.SerializedName;

public class Category {
    @SerializedName("id")
    private int id;

    @SerializedName("name")
    private String name;

    @SerializedName("image")
    private String image;

    public int getId() { return id; }
    public String getName() { return name; }
    public String getImage() { return image; }
}
