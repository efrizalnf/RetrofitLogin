package com.zlz.retrofitlogin;

import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by zlz on 19,September,2019
 */
public class RetrofitClient {

    private static Retrofit retrofit = null;
    public static Retrofit getClient(String baseUrl) {
        if (retrofit == null) {
            retrofit = new Retrofit.Builder()
                    .baseUrl("https://jsmart.id/api/")
//                    .client(getOkHttpClient())
                    .addConverterFactory(GsonConverterFactory.create())
                    .client(UnsafeOkHttpClient.getUnsafeOkHttpClient())
                    .build();
        }
        return retrofit;
    }
    private static OkHttpClient getOkHttpClient(){
        HttpLoggingInterceptor logging = new HttpLoggingInterceptor();
        logging.setLevel(HttpLoggingInterceptor.Level.NONE);
        OkHttpClient okClient = new OkHttpClient.Builder()
                .addInterceptor(logging)
                .build();
        return okClient;
    }
}
