package com.example.baitap06;

import com.google.gson.annotations.SerializedName;

public class Category {
    @SerializedName("id")
    private String id;

    @SerializedName("name")
    private String name;

    // Change this field name to match the API response
    @SerializedName("images")
    private String imageUrl;

    @SerializedName("description")
    private String description;

    // Getters
    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public String getDescription() {
        return description;
    }
}
