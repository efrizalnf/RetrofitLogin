package com.zlz.retrofitlogin;

/**
 * Created by zlz on 19,September,2019
 */
public class ApiUtils {
    private ApiUtils() {
    }

    public static final String BASE_URL = "https://jsmart.id/api/";

    public static Api getApiService() {
        return RetrofitClient.getClient(BASE_URL).create(Api.class);
    }

}
