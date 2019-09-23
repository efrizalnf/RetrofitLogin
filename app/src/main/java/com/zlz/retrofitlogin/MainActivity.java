package com.zlz.retrofitlogin;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;

public class MainActivity extends AppCompatActivity {
    private TextView mResponseTv;
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
                sendPost();
//                }
            }
        });
    }

//    public void sendPost() {
////        mAPI.saveData("moderator@jababeka.com", "12345", "10.89823", "909993", "123", "234", "2", "32", "2", "1"){
//        Call<StatusLogin<Login>> loginCall = mAPI.saveData("moderator@jababeka.com", "12345", "10.89823", "909993", "123", "234", "2", "32", "2", "1");
//        {
//            {
//                loginCall.enqueue(new retrofit<StatusLogin<Login>>() {
//
//                    @Override
//                    public void onResponse(Call<Login> call, Response<Login> response) {
//                        if (response.isSuccessful()) {
//                            showResponse(response.body().toString());
//                            Log.i("post submit api", response.body().toString());
//                        }
//                    }
//
//                    @Override
//                    public void onFailure(Call<Login> call, Throwable t) {
//
//                    }
//
//                });
//            }
//
//            public void showResponse(String response){
//            if (mResponseTv.getVisibility() == View.GONE) {
//                mResponseTv.setVisibility(View.VISIBLE);
//            }
//            mResponseTv.setText(response);
//
//        }
//        }
//    }


    public void sendPost() {
        mAPI.saveData("moderator2@jababeka.com", "12345", "10.89823", "909993", "123", "234", "2", "32", "2", "1").enqueue(new Callback<StatusLogin<Login>>() {
            @Override
            public void onResponse(Call<StatusLogin<Login>> call, Response<StatusLogin<Login>> response) {
                if (response.isSuccessful()) {
                showResponse(response.body().getData().getEmail().toString());
                showResponse(response.body().getData().getFoto().toString());
                showResponse(response.body().getData().getToken().toString());
                showResponse(response.body().getData().getAkses().toString());
                showResponse(response.body().getData().getIsInternal().toString());
                Log.i("pos :", response.body().getData().getIsInternal().toString());
//                Log.i("pos :", response.body().getData().getFoto().toString());
//                Log.i("pos :",response.body().getData().getToken().toString());
//                Log.i("pos :", response.body().getData().getAkses().toString());
//                Log.i("pos :", response.body().getData().getIsInternal().toString());
                }

            }

            @Override
            public void onFailure(Call<StatusLogin<Login>> call, Throwable t) {
                t.printStackTrace();
            }
        });
    }

    public void showResponse(String response) {
        if (mResponseTv.getVisibility() == View.GONE) {
            mResponseTv.setVisibility(View.VISIBLE);
        }
        mResponseTv.setText(response);
    }

//    public void sendPost() {
//        mAPI.saveData("moderator2@jababeka.com", "12345", "10.89823", "909993", "123", "234", "2", "32", "2", "1").enqueue(new Callback<StatusLogin<L>>() {
//            @Override
//            public void onResponse(Call<StatusLogin<L>> call, Response<StatusLogin<L>> response) {
//                if (response.isSuccessful()){
//                    showResponse(response.body().toString());
//                }
//            }
//
//            @Override
//            public void onFailure(Call<StatusLogin<L>> call, Throwable t) {
//
//            }
//
//        });
//    }
//
//    public void showResponse(String response) {
//        if (mResponseTv.getVisibility() == View.GONE) {
//            mResponseTv.setVisibility(View.VISIBLE);
//        }
//        mResponseTv.setText(response);
//    }


}