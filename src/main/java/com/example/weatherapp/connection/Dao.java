package com.example.weatherapp.connection;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;

import com.example.weatherapp.data.City;

import java.util.ArrayList;
import java.util.List;

public class Dao
{
    private static Dao instance;
    private MutableLiveData<String> unit;
    private MutableLiveData<List<String>> favCities;
    private List<String> cities;
    private Dao()
    {
        unit=new MutableLiveData<>();
        favCities = new MutableLiveData<>();
        cities= new ArrayList<>();
        cities.add("Horsens");
        cities.add("Aarhus");
        cities.add("Paris");
        cities.add("London");
        favCities.setValue(cities);
    }
    public static Dao getInstance()
    {
        if(instance==null)
            instance = new Dao();
        return instance;
    }

    public MutableLiveData<String> getUnit()
    {
        return unit;
    }

    public void setUnit(String unit)
    {
        this.unit.setValue(unit);
    }

    public LiveData<List<String>> getFavCities()
    {
        return favCities;
    }

    public void setFavCities(List<String> favCities)
    {
        this.favCities.setValue(favCities);
    }
    public void addFavCity(String city)
    {
        cities.add(city);
        favCities.setValue(cities);
    }
    public void deleteFavCity(String city)
    {
        cities.remove(city);
    }
}

