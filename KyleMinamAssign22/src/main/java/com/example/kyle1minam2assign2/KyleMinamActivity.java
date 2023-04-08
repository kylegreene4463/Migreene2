package com.example.kyle1minam2assign2;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.MenuItem;

import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.navigation.NavigationBarView;

public class KyleMinamActivity extends AppCompatActivity {

    BottomNavigationView bottomNavigationView;
    N01534463N01451260Weather weather = new N01534463N01451260Weather();
    Migreene22Download download = new Migreene22Download();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        bottomNavigationView = findViewById(R.id.bottom_navigation);

        getSupportFragmentManager().beginTransaction().replace(R.id.container,weather).commit();
        bottomNavigationView.setOnItemSelectedListener(new NavigationBarView.OnItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(MenuItem item) {
                switch (item.getItemId()){
                    case R.id.weather:
                        getSupportFragmentManager().beginTransaction().replace(R.id.container,weather).commit();
                        return true;
                    case R.id.download:
                        getSupportFragmentManager().beginTransaction().replace(R.id.container,download).commit();
                        return true;
                }


                return false;
            }
        });
    }
}
