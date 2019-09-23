package com.zlz.retrofitlogin;

import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.POST;

/**
 * Created by zlz on 18,September,2019
 */
public interface Api {
    @FormUrlEncoded
    @POST("/auth/login")
    Call<StatusLogin> saveData(@Field("email") String email,
                                  @Field("password") String password,
                                  @Field("lat") String latitude,
                                  @Field("lon") String longitude,
                                  @Field("reg_id") String reg_id,
                                  @Field("version") String version,
                                  @Field("android_id") String android_id,
                                  @Field("model_device") String model_device,
                                  @Field("app_origin") String app_origin,
                                  @Field("app_version") String app_version
    );
}
