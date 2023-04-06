package com.lixiang.retrofit_demo;

import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.lixiang.retrofit_demo.api.LicensePlateApi;
import com.lixiang.retrofit_demo.api.WeatherServiceApi;
import com.lixiang.retrofit_demo.bean.LicensePlate;
import com.lixiang.retrofit_demo.bean.Weather;
import com.lixiang.retrofit_demo.utils.RetrofitUtils;

import okhttp3.Request;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {

    private Button btnWeather;
    private EditText address;

    private EditText carNo;
    private Button btnCarno;

    private static final String CAR_KEY = "xxx";
    private static final String WEATHER_KEY = "xxx";

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
        btnCarno.setOnClickListener(v -> {
            queryCarCity();
        });
    }

    private void queryCarCity() {
        String carNum = carNo.getText().toString();
        if (!TextUtils.isEmpty(carNum)) {
            LicensePlateApi licensePlateApi = RetrofitUtils.getService(LicensePlateApi.class);
            licensePlateApi.getInformation(carNum, CAR_KEY).enqueue(new Callback<LicensePlate>() {
                @Override
                public void onResponse(Call<LicensePlate> call, Response<LicensePlate> response) {
                    LicensePlate body = response.body();
                    if (body.getError_code() == 0){
                        LicensePlate.Result message = response.body().getResult();
                        Log.e("detail message is ", message.toString());
                    } else {
                        Toast.makeText(MainActivity.this, "车牌输入有误！", Toast.LENGTH_LONG).show();
                    }
                }

                @Override
                public void onFailure(Call<LicensePlate> call, Throwable t) {
                    Request request = call.request();
                    System.out.println(request.toString());
                    Toast.makeText(MainActivity.this, "网络延迟！", Toast.LENGTH_LONG).show();
                    t.printStackTrace();
                }
            });
        } else {
            Toast.makeText(MainActivity.this, "车牌不能为空！", Toast.LENGTH_LONG).show();
        }
    }

    private void initView() {
        btnWeather = this.findViewById(R.id.btn_weather);
        address = this.findViewById(R.id.address);
        btnCarno = this.findViewById(R.id.btn_carno);
        carNo = findViewById(R.id.carno);
    }


    private void queryWeather() {
        String tempAddress = address.getText().toString();
        Log.e("address", tempAddress);

        if (!tempAddress.equals("")) {
            WeatherServiceApi weatherService = RetrofitUtils.getService(WeatherServiceApi.class);
            weatherService.getInformation(tempAddress, WEATHER_KEY).enqueue(new Callback<Weather>() {
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