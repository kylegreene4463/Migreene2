package com.example.kyle1minam2assign2;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.MenuItem;

import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.navigation.NavigationBarView;
import com.google.android.material.navigation.NavigationView;

public class KyleMinamActivity extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener {
    private Toolbar toolbar;
    private DrawerLayout drawerLayout;

    private NavigationView navigationView;

    ActionBarDrawerToggle actionBarDrawerToggle;
    N01534463N01451260Weather weather = new N01534463N01451260Weather();
    Migreene22Download download = new Migreene22Download();
    KyleMinamHome kyleMinamHome = new KyleMinamHome();

    DBScreen dbScreen = new DBScreen();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // 6 - Configure all views

        this.configureToolBar();

        this.configureDrawerLayout();

        this.configureNavigationView();
        //Loads Home Fragment First
        getSupportFragmentManager().beginTransaction().replace(R.id.activity_main_frame_layout, new KyleMinamHome()).commit();



    }
    @Override
    public void onBackPressed() {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle(R.string.exit);
        builder.setMessage(R.string.exitconfirm);
        builder.setCancelable(false);
        builder.setIcon(R.drawable.warning_icon);
        builder.setPositiveButton(R.string.yes, new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                KyleMinamActivity.super.onBackPressed(); // Move this line
                finish();
            }
        });
        builder.setNegativeButton(R.string.no, new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                dialog.cancel();
            }
        });
        AlertDialog alert = builder.create();
        alert.show();
    }
    private void configureToolBar(){
        this.toolbar = (Toolbar) findViewById(R.id.activity_main_toolbar);
        setSupportActionBar(toolbar);
    }

    // 2 - Configure Drawer Layout
    private void configureDrawerLayout(){
        this.drawerLayout = (DrawerLayout) findViewById(R.id.activity_main_drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(this, drawerLayout, toolbar, R.string.navOpen, R.string.navClose);
        drawerLayout.addDrawerListener(toggle);
        toggle.syncState();
    }

    // 3 - Configure NavigationView
    private void configureNavigationView(){
        this.navigationView = (NavigationView) findViewById(R.id.activity_main_nav_view);
        navigationView.setNavigationItemSelectedListener(this);
    }
    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {
        int id = item.getItemId();

        if (id == R.id.home) {
            getSupportFragmentManager().beginTransaction().replace(R.id.activity_main_frame_layout, new KyleMinamHome()).commit();
        } else if (id == R.id.download) {
            getSupportFragmentManager().beginTransaction().replace(R.id.activity_main_frame_layout, new Migreene22Download()).commit();
        } else if (id == R.id.weather) {
            getSupportFragmentManager().beginTransaction().replace(R.id.activity_main_frame_layout, new N01534463N01451260Weather()).commit();
        } else if (id == R.id.db) {
            getSupportFragmentManager().beginTransaction().replace(R.id.activity_main_frame_layout,new DBScreen()).commit();
        }

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.activity_main_drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }
}

