package com.example.weatherapp.connection;

import android.util.Log;

import androidx.lifecycle.MutableLiveData;

import com.example.weatherapp.data.CityResponse.CityResponse;


import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class Repository {
    private static Repository instance;
    private Dao dao;
    private MutableLiveData<List<CityResponse>> citiesInfo;
    private MutableLiveData<CityResponse> cityInfo;

    private Repository() {
        dao = Dao.getInstance();
        cityInfo = new MutableLiveData<>();
        citiesInfo = new MutableLiveData<List<CityResponse>>();
        List<CityResponse> init = new ArrayList<>();
        citiesInfo.setValue(init);
    }

    public static Repository getInstance() {
        if (instance == null)
            instance = new Repository();
        return instance;
    }

    public String getUnit() {
        return dao.getUnit().getValue();
    }

    public void setUnit(String unit) {
        dao.setUnit(unit);
    }

    public void requestCitiesInfo() {
        List<String> favCities = new ArrayList<>(dao.getFavCities().getValue());
        WeatherAPI weatherAPI = ServiceGenerator.getApi();
        //for (int i = 0; i < favCities.size(); i++) {
        Map<String, String> options = new HashMap<String, String>();
        options.put("q", "Horsens");//favCities.get(i));
        options.put("appid", "f7e49e6aa1663deaabd9561cafcba667");
        Call<CityResponse> call = weatherAPI.getCityInfo();
        call.enqueue(new Callback<CityResponse>() {
            @Override
            public void onResponse(Call<CityResponse> call, Response<CityResponse> response) {
                if (response.code() == 200) {
                    //citiesInfo.getValue().add(response.body());
                    //citiesInfo.setValue(citiesInfo.getValue());
                    Log.d("Retrofit", "Received city: " + response.body());//.getName() + " , " + (response.body().getMain().getTemp() - 273.15) + "℃");
                    //Log.d("Retrofit", "Received cities: " + citiesInfo.getValue().get(0).getName());
                }
            }

            @Override
            public void onFailure(Call<CityResponse> call, Throwable t) {
                Log.i("Retrofit", "Could not retrieve city.");
            }
        });
        //}
    }

    public void requestCityInfo(String city) {
        WeatherAPI weatherAPI = ServiceGenerator.getApi();
        Map<String, String> options = new HashMap<String, String>();
        options.put("q", city);
        options.put("appid", "f7e49e6aa1663deaabd9561cafcba667");
        Call<CityResponse> call = weatherAPI.getCityInfo();
        call.enqueue(new Callback<CityResponse>() {
            @Override
            public void onResponse(Call<CityResponse> call, Response<CityResponse> response) {
                if (response.code() == 200) {
                    //cityInfo.setValue(response.body());
                    Log.d("Retrofit", "Received city: " + response.body());//.getName() + " , " + (response.body().getMain().getTemp() - 273.15) + "℃");
                }
            }

            @Override
            public void onFailure(Call<CityResponse> call, Throwable t) {
                Log.i("Retrofit", "Could not retrieve city.");
            }
        });
    }

    public MutableLiveData<CityResponse> getCityInfo() {
        return cityInfo;
    }

    public List<CityResponse> getCitiesInfo() {
        requestCitiesInfo();
        return citiesInfo.getValue();
    }

    public void addFavoriteCity(String city) {
        dao.addFavCity(city);
        requestCitiesInfo();
    }
}