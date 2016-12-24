package com.erolkaftanoglu.weatherretrofitdemo;

import com.erolkaftanoglu.weatherretrofitdemo.models.needresponse.WeatherModelPojo;
import com.erolkaftanoglu.weatherretrofitdemo.models.response.WeatherPojoModel;

import retrofit.Call;
import retrofit.http.GET;
import retrofit.http.Query;

/**
 * Created by erol on 31.08.2016.
 */
public interface MyApi {
    public static String url = "http://api.openweathermap.org";
    public static String endpoint = "";

    @GET("/data/2.5/weather?q=Istanbul,tr&appid=f30682a8f9f3bcd0c78000447fbf23d8")
    Call<WeatherPojoModel> getStatusWeather();

    @GET("/data/2.5/weather")
    Call<WeatherModelPojo> getWeather(@Query("q")String q, @Query("appid") String token);
}
