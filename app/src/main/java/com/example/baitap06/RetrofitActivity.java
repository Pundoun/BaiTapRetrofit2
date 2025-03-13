package com.example.baitap06;

import android.os.Bundle;
import android.util.Log;
import android.widget.Toast;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import java.util.ArrayList;
import java.util.List;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class RetrofitActivity extends AppCompatActivity {
    private RecyclerView rcCate;
    private CategoryAdapter categoryAdapter;
    private APIService apiService;
    private List<Category> categoryList;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Ánh xạ RecyclerView
        rcCate = findViewById(R.id.rc_category);

        // Khởi tạo danh sách trống
        categoryList = new ArrayList<>();

        // Tạo Adapter một lần
        categoryAdapter = new CategoryAdapter(this, categoryList);
        rcCate.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false));
        rcCate.setAdapter(categoryAdapter);

        // Gọi API để lấy dữ liệu
        GetCategory();
    }


    private void GetCategory() {
        apiService = RetrofitClient.getInstance().create(APIService.class);

        apiService.getCategories().enqueue(new Callback<List<Category>>() {
            @Override
            public void onResponse(Call<List<Category>> call, Response<List<Category>> response) {
                if (response.isSuccessful() && response.body() != null) {
                    runOnUiThread(() -> {
                        categoryList.clear();  // Xóa dữ liệu cũ
                        categoryList.addAll(response.body());  // Thêm dữ liệu mới
                        categoryAdapter.notifyDataSetChanged();  // Cập nhật RecyclerView
                    });
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
