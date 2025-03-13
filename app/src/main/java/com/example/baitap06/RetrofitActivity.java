package com.example.baitap06;

import android.os.Bundle;
import android.util.Log;
import android.widget.Toast;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import java.util.List;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class RetrofitActivity extends AppCompatActivity {
    RecyclerView rcCate;
    CategoryAdapter categoryAdapter;
    APIService apiService;
    List<Category> categoryList;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        AnhXa();
        GetCategory(); // Gọi API lấy dữ liệu
    }

    private void AnhXa() {
        rcCate = findViewById(R.id.rc_category);
    }

    private void GetCategory() {
        // Tạo instance của APIService
        apiService = RetrofitClient.getInstance();

        // Gọi API
        apiService.getCategoriesAll().enqueue(new Callback<List<Category>>() {
            @Override
            public void onResponse(Call<List<Category>> call, Response<List<Category>> response) {
                if (response.isSuccessful() && response.body() != null) {
                    categoryList = response.body();
                    categoryAdapter = new CategoryAdapter(RetrofitActivity.this, categoryList);

                    rcCate.setLayoutManager(new LinearLayoutManager(RetrofitActivity.this));
                    rcCate.setAdapter(categoryAdapter);

                    categoryAdapter.notifyDataSetChanged();
                } else {
                    Toast.makeText(RetrofitActivity.this, "Lỗi lấy dữ liệu!", Toast.LENGTH_SHORT).show();
                }
            }

            @Override
            public void onFailure(Call<List<Category>> call, Throwable t) {
                Log.e("RetrofitActivity", "Lỗi kết nối: " + t.getMessage());
                Toast.makeText(RetrofitActivity.this, "Lỗi kết nối mạng!", Toast.LENGTH_SHORT).show();
            }
        });
    }
}
