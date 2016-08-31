package com.erolkaftanoglu.weatherretrofitdemo;

import android.os.PersistableBundle;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

import com.erolkaftanoglu.weatherretrofitdemo.models.response.WeatherPojoModel;

import retrofit.Callback;
import retrofit.GsonConverterFactory;
import retrofit.Response;
import retrofit.Retrofit;

public class MainActivity extends AppCompatActivity {
    String tag = "hello";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Log.v(tag, "OnCreate is on");
        startRetrofit();
        Log.v(tag, "OnCreate is off");
    }


    void startRetrofit(){
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(MyApi.url)
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        MyApi myApi = retrofit.create(MyApi.class);

        myApi.getStatusWeather().enqueue(new Callback<WeatherPojoModel>() {
            @Override
            public void onResponse(Response<WeatherPojoModel> response, Retrofit retrofit) {
                if (response.isSuccess()){
                    Log.v(tag,"Name: " +  response.body().getName());
                    Log.v(tag,"Lat: " + response.body().getCoord().getLat() +
                            "Long: " + response.body().getCoord().getLon());
                    Log.v(tag, "Temp: " + response.body().getMain().getTemp());

                }else{
                    Log.v(tag, "OnResponse: Fail" + response.errorBody().toString());
                }
            }

            @Override
            public void onFailure(Throwable t) {
                Log.v(tag,"Fail");
            }
        });


    }
}
