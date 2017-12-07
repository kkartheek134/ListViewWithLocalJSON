package com.android.gemini.localjsonexample;

/**
 * Created by kkavalireddy on 12/7/2017.
 */

public class MyPlaces {
    private  String name;
    private double Latitude;
    private double Longitude;
    public MyPlaces(String name,double latitude,double longitude) {
        this.name = name;
        this.Latitude = latitude;
        this.Longitude = longitude;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getLatitude() {
        return Latitude;
    }

    public void setLatitude(double latitude) {
        this.Latitude = latitude;
    }

    public double getLongitude() {
        return Longitude;
    }

    public void setLongitude(double longitude) {
        this.Longitude = longitude;
    }
}
