package com.example.baitap06;

import java.util.List;
import retrofit2.Call;
import retrofit2.http.GET;

public interface APIService {
    @GET("categories.php")  // Kiểm tra đúng endpoint API!
    Call<List<Category>> getCategoriesAll();
}
