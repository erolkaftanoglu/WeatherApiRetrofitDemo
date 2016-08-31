package com.erolkaftanoglu.weatherretrofitdemo;

import com.erolkaftanoglu.weatherretrofitdemo.models.response.WeatherPojoModel;

import retrofit.Call;
import retrofit.http.GET;

/**
 * Created by erol on 31.08.2016.
 */
public interface MyApi {
    public static String url = "http://api.openweathermap.org";

    @GET("/data/2.5/weather?q=Istanbul,tr&appid=f30682a8f9f3bcd0c78000447fbf23d8")
    Call<WeatherPojoModel> getStatusWeather();
}
