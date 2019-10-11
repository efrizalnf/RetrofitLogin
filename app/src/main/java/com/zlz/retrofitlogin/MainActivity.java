package com.zlz.retrofitlogin;

import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.google.gson.Gson;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;

public class MainActivity extends AppCompatActivity {

    private static final String TAG = "MainActivity";

    private TextView mResponseTv;
    private Button submitBtn;
    private Api mAPI;
    private Retrofit retrofit;
    private Login login;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final EditText titleEt = findViewById(R.id.et_title);
        final EditText bodyEt = findViewById(R.id.et_body);
        final EditText latitude = findViewById(R.id.et_lat);
        final EditText longitude = findViewById(R.id.et_long);
        final EditText regId = findViewById(R.id.et_reg);
        final EditText version = findViewById(R.id.et_ver);
        final EditText android = findViewById(R.id.et_android);
        final EditText modeldevice = findViewById(R.id.et_model);
        final EditText appori = findViewById(R.id.et_appori);
        final EditText appver = findViewById(R.id.et_appmodel);
        Button submitBtn = findViewById(R.id.btn_submit);
        mResponseTv = findViewById(R.id.tv_response);

        mAPI = ApiUtils.getApiService();
        mAPI = RetrofitClient.getClient(" ").create(Api.class);

        submitBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String email = titleEt.getText().toString().trim();
                String pass = bodyEt.getText().toString().trim();
                String lat = latitude.getText().toString().trim();
                String longi = longitude.getText().toString().trim();
                String reg = regId.getText().toString().trim();
                String ver = version.getText().toString().trim();
                String andro = android.getText().toString().trim();
                String model = modeldevice.getText().toString().trim();
                String appor = appori.getText().toString().trim();
                String appve = appver.getText().toString().trim();
//                if (!TextUtils.isEmpty(email) && !TextUtils.isEmpty(pass) && !TextUtils.isEmpty(lat) && !TextUtils.isEmpty(longi) && !TextUtils.isEmpty(reg) && !TextUtils.isEmpty(ver) && !TextUtils.isEmpty(andro) && !TextUtils.isEmpty(model) && !TextUtils.isEmpty(appor) && !TextUtils.isEmpty(appve)) {
//                sendPost(email,pass,lat,longi,reg, ver, andro, model,appor, appve);
//                }
            }
        });

        mAPI = RetrofitClient.getClient(" ").create(Api.class);
        sendPost();
    }

    public void sendPost() {
        mAPI.saveData("zalzondabuzz@gmail.com", "Qwerty2!", " ", " ", " ", " ", " ", " ", " ", " ").enqueue(new Callback<StatusLogin>() {
            @Override
            public void onResponse(Call<StatusLogin> call, Response<StatusLogin> response){
                Gson gson = new Gson();
                Log.d(TAG, "onResponse: " + gson.toJson(response.body()));
                Log.i(TAG, "post" + response.body().toString());

                showResponse(gson.toJson(response.body()));
            }

            @Override
            public void onFailure(Call<StatusLogin> call, Throwable t) {

            }
        });
    }

    public void showResponse(String response) {
        if (mResponseTv.getVisibility() == View.GONE) {
            mResponseTv.setVisibility(View.VISIBLE);
        }
        mResponseTv.setText(response);
    }

}