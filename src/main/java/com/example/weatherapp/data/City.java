package com.example.weatherapp.data;

public class City {
    private String name;
    private String temp;
    public City(String name, String temp)
    {
        this.name=name;
        this.temp=temp;
    }

    public String getName() {
        return name;
    }

    public String getTemp() {
        return temp;
    }
}
