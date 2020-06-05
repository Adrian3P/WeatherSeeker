package com.example.weatherapp.ui;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;

import androidx.fragment.app.Fragment;
import androidx.navigation.Navigation;

import com.example.weatherapp.R;

public class SearchFragment extends Fragment
{
    private EditText text;
    private Button search;
    private SearchViewModel model;
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState)
    {
        View routeView = inflater.inflate(R.layout.search_fragment, container, false);
        text=routeView.findViewById(R.id.search_text);
        search=routeView.findViewById(R.id.buttonsearch);
        model=new SearchViewModel();
        search.setOnClickListener(new View.OnClickListener()
        {

            @Override
            public void onClick(View view)
            {
                model.getCityInfo(text.getText().toString());
                Navigation.createNavigateOnClickListener(R.id.search_city_action,null); //arg
            }
        });
        return routeView;
    }
}
