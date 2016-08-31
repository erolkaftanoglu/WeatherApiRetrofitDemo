package com.erolkaftanoglu.weatherretrofitdemo;

import android.os.PersistableBundle;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.erolkaftanoglu.weatherretrofitdemo.models.myresponse.WeatherModelPojo;
import com.erolkaftanoglu.weatherretrofitdemo.models.response.WeatherPojoModel;

import retrofit.Callback;
import retrofit.GsonConverterFactory;
import retrofit.Response;
import retrofit.Retrofit;

public class MainActivity extends AppCompatActivity {
    String tag = "hello";
    EditText editText;
    TextView textView;
    Button button;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        editText = (EditText) findViewById(R.id.city);
        textView = (TextView) findViewById(R.id.cityName);
        button = (Button) findViewById(R.id.cityButton);
        Log.v(tag, "OnCreate is on");
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String cityName = editText.getText().toString();
                getWeather(startRetrofit(),cityName);
            }
        });
        Log.v(tag, "OnCreate is off");
    }


    MyApi startRetrofit(){
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(MyApi.url)
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        MyApi myApi = retrofit.create(MyApi.class);

        return myApi;
    }
    void getStatus(MyApi myApi){
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
    void getWeather(MyApi myApi, String city){
        myApi.getWeather(city, "f30682a8f9f3bcd0c78000447fbf23d8").enqueue(new Callback<WeatherModelPojo>() {
            @Override
            public void onResponse(Response<WeatherModelPojo> response, Retrofit retrofit) {
                if (response.isSuccess()){
                    Log.v(tag,"Name: " +  response.body().getName());
                    Log.v(tag,"Lat: " + response.body().getCoord().getLat() +
                            "Long: " + response.body().getCoord().getLon());
                    textView.setText(
                            "şehir ismi:  " + response.body().getName() +" Koordinatları: lat:"
                            + response.body().getCoord().getLat()
                            +" lon: " +response.body().getCoord().getLon()
                    );

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
