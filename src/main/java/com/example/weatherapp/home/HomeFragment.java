package com.example.weatherapp.home;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.weatherapp.R;
import com.example.weatherapp.data.CityResponse.CityResponse;

import java.util.ArrayList;
import java.util.List;

public class HomeFragment extends Fragment
{
    CityAdapter adapter;
    List<CityResponse> cities = new ArrayList<>();
    HomeViewModel viewModel = new HomeViewModel();

    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState)
    {
        View routeView = inflater.inflate(R.layout.home_fragment, container, false);
        RecyclerView cityList = routeView.findViewById(R.id.recyclerView);
        cityList.hasFixedSize();
        cityList.setLayoutManager(new LinearLayoutManager(getActivity()));
        cities.clear();
        cities.addAll(viewModel.getCitiesInfo());
        adapter = new CityAdapter(cities);
        cityList.setAdapter(adapter);
        return routeView;
    }
}