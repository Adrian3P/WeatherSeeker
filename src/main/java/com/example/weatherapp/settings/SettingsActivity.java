package com.example.weatherapp.settings;

import android.os.Bundle;
import android.view.Menu;
import android.widget.Switch;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.navigation.ui.AppBarConfiguration;

import com.example.weatherapp.R;

public class SettingsActivity extends AppCompatActivity {
    private AppBarConfiguration barConfiguration;
    private TextView unittype;
    private Switch celtofah;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.settings_activity);
        Toolbar toolbar = findViewById(R.id.settings_toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        unittype = findViewById(R.id.unittype);
        celtofah = findViewById(R.id.celsiustofarenheit);
    }

    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.main_menu, menu);
        return true;
    }
}