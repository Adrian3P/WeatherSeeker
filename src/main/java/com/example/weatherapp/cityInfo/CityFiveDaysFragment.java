package com.example.weatherapp.cityInfo;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import androidx.fragment.app.Fragment;

import com.example.weatherapp.R;

public class CityFiveDaysFragment extends Fragment
{
    private TextView city1;
    private Button show_more;
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState)
    {
        View routeView = inflater.inflate(R.layout.city_details5, container, false);
        city1 = routeView.findViewById(R.id.city1);
        show_more = routeView.findViewById(R.id.show_more);
        show_more.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View view)
            {
                //Navigation.createNavigateOnClickListener(R.id.,null);
            }
        });
        return routeView;
    }

}
