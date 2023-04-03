package com.lixiang.retrofit_demo;

import android.os.Bundle;
import android.util.Log;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.lixiang.retrofit_demo.api.WeatherServiceApi;
import com.lixiang.retrofit_demo.bean.Weather;
import com.lixiang.retrofit_demo.utils.RetrofitUtils;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {

    private Button btnWeather;
    private EditText address;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initView();
        initListener();
    }

    private void initListener() {
        btnWeather.setOnClickListener(view -> {
            queryWeather();
        });
    }

    private void initView() {
        btnWeather = this.findViewById(R.id.btn_weather);
        address = this.findViewById(R.id.address);
    }


    private void queryWeather() {
        String tempAddress = address.getText().toString();
        Log.e("address", tempAddress);

        if (!tempAddress.equals("")) {
            WeatherServiceApi weatherService = RetrofitUtils.getService(WeatherServiceApi.class);
            weatherService.getInformation(tempAddress, API_KEY).enqueue(new Callback<Weather>() {
                @Override
                public void onResponse(Call<Weather> call, Response<Weather> response) {
                    Weather weather = response.body();
                    Log.e("weather is ", weather.toString());
                    if (response.body().getError_code() == 0) {
                        String message = response.body().getResult().toString();
                        Log.e("detail message is ", message);
                    } else {
                        Toast.makeText(MainActivity.this, "城市输入有误！", Toast.LENGTH_LONG).show();
                    }
                }

                @Override
                public void onFailure(Call<Weather> call, Throwable t) {
                    Toast.makeText(MainActivity.this, "网络延迟！", Toast.LENGTH_LONG).show();
                    t.printStackTrace();
                }
            });
        } else {
            Toast.makeText(MainActivity.this, "城市不能为空！", Toast.LENGTH_LONG).show();
        }
    }

}