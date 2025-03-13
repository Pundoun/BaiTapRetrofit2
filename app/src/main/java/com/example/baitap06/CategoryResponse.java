package com.example.baitap06;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public class CategoryResponse {
    @SerializedName("status")
    private String status;

    @SerializedName("message")
    private String message;

    @SerializedName("data")
    private List<Category> categories;

    // Getters
    public String getStatus() {

        return status;
    }

    public String getMessage() {

        return message;
    }

    public List<Category> getCategories() {

        return categories;
    }
}

