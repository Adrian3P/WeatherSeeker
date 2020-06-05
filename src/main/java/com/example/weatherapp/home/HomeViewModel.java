package com.example.weatherapp.home;


import androidx.lifecycle.ViewModel;

import com.example.weatherapp.connection.Repository;
import com.example.weatherapp.data.CityResponse.CityResponse;

import java.util.List;

public class HomeViewModel extends ViewModel
{
    private Repository repository;


    public HomeViewModel()
    {
        repository = Repository.getInstance();
    }
    public String getUnit()
    {
        return repository.getUnit();
    }
    public void setUnit(String unit)
    {
        repository.setUnit(unit);
    }
    public List<CityResponse> getCitiesInfo()
    {
        return repository.getCitiesInfo();
    }

}
