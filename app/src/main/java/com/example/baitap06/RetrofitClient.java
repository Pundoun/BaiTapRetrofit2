package com.example.baitap06;

public class RetrofitClient extends BaseClient {
    private static final String BASE_URL = "http://app.iotstar.vn:8081/appfoods/";
    private static APIService apiService;

    public static APIService getInstance() {
        if (apiService == null) {
            apiService = createService(APIService.class, BASE_URL);
        }
        return apiService;
    }
}
