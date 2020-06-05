package com.example.weatherapp.cityInfo;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.fragment.app.Fragment;

import com.example.weatherapp.R;

public class CityDetailsFragment extends Fragment {

    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View routeView = inflater.inflate(R.layout.one_city_details, container, false);


        return routeView;
    }
}
