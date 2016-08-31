package com.erolkaftanoglu.weatherretrofitdemo.models.myresponse;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by erol on 31.08.2016.
 */
public class WeatherModelPojo {
    public class Coord{
        @SerializedName("lat")
        @Expose
        Double lat;
        @SerializedName("lon")
        @Expose
        Double lon;

        public Double getLat() {
            return lat;
        }

        public void setLat(Double lat) {
            this.lat = lat;
        }

        public Double getLon() {
            return lon;
        }

        public void setLon(Double lon) {
            this.lon = lon;
        }
    }
    public class Weather{
        @SerializedName("main")
        @Expose
        String main;

        public String getMain() {
            return main;
        }

        public void setMain(String main) {
            this.main = main;
        }
    }

    class Main{
        @SerializedName("humidity")
        @Expose
        Integer humidity;
        @SerializedName("temp")
        @Expose
        Double temp;

        public Integer getHumidity() {
            return humidity;
        }

        public void setHumidity(Integer humidity) {
            this.humidity = humidity;
        }
    }
    class Wind{
        @SerializedName("speed")
        @Expose
        String speed;

        public String getSpeed() {
            return speed;
        }

        public void setSpeed(String speed) {
            this.speed = speed;
        }
    }

    @SerializedName("coord")
    @Expose
    Coord coord;

    @SerializedName("weather")
    @Expose
    List<Weather>weathers = new ArrayList<>();


    @SerializedName("name")
    @Expose
    String name;

    public List<Weather> getWeathers() {
        return weathers;
    }

    public void setWeathers(List<Weather> weathers) {
        this.weathers = weathers;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Coord getCoord() {
        return coord;
    }

    public void setCoord(Coord coord) {
        this.coord = coord;
    }
}
