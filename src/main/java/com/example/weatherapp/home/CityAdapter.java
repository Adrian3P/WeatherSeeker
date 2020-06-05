package com.example.weatherapp.home;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.weatherapp.R;
import com.example.weatherapp.data.CityResponse.CityResponse;

import java.util.List;

public class CityAdapter extends RecyclerView.Adapter<CityAdapter.ViewHolder> {
        private List<CityResponse> cities;
        public  CityAdapter(List<CityResponse> citiess)
        {
            cities=citiess;
        }
    @NonNull
    @Override
    public CityAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        View view = inflater.inflate(R.layout.item_city, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull CityAdapter.ViewHolder holder, int position) {
    holder.cityName.setText(cities.get(position).getName());
    holder.temp.setText(Math.round(cities.get(position).getMain().getTemp()-272.15)+"℃");
    }

    @Override
    public int getItemCount() {
        return cities.size();
    }

    class ViewHolder extends RecyclerView.ViewHolder {

        TextView cityName;
        TextView temp;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            cityName=itemView.findViewById(R.id.cityText);
            temp=itemView.findViewById(R.id.tempText);
        }
    }
}
