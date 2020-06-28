package com.example.blackcoffertask2;

import android.os.Build;
import android.os.Bundle;

import android.view.MenuItem;

import androidx.annotation.NonNull;
import androidx.annotation.RequiresApi;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.TooltipCompat;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;
import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.navigation.NavigationView;

import android.widget.Toolbar;
import com.facebook.FacebookSdk;
import com.facebook.appevents.AppEventsLogger;


public class MainActivity extends AppCompatActivity implements BottomNavigationView.OnNavigationItemSelectedListener, NavigationView.OnNavigationItemSelectedListener {
    DrawerLayout drawerLayout;
    NavigationView navigationView;
    Toolbar toolbar;


    BottomNavigationView bottomNavigationView;
    private Object Toolbar;

    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        bottomNavigationView = findViewById(R.id.bottom_navigation_view);
        bottomNavigationView.setOnNavigationItemSelectedListener(this);
        bottomNavigationView.setSelectedItemId(R.id.navigation_Tags);
        drawerLayout = findViewById(R.id.drawer_layout);
       // navigationView = findViewById(R.id.menu_nav_view);


        //qweertyvyh
        setSupportActionBar((androidx.appcompat.widget.Toolbar) Toolbar);

navigationView.setNavigationItemSelectedListener(this);
       navigationView.bringToFront();
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(this,drawerLayout,R.string.navi_open_drawer,R.string.navi_close_drawer);
        drawerLayout.addDrawerListener(toggle);
        toggle.syncState();
    }

    @Override
    public void onBackPressed() {
        if (drawerLayout.isDrawerOpen(GravityCompat.START))
            drawerLayout.closeDrawer(GravityCompat.START);
        else {
            super.onBackPressed();
        }
    }

    tags TagsFragment = new tags();
    trending TrendingFragment = new trending();
    explore ExploreFragment = new explore();
    saved SavedFragment = new saved();

    public boolean onNavigationItemSelected(@NonNull MenuItem Item) {

        switch (Item.getItemId()) {
            case R.id.navigation_Tags:
                getSupportFragmentManager().beginTransaction().replace(R.id.container, TagsFragment).commit();
                return true;
            case R.id.navigation_Trending:
                getSupportFragmentManager().beginTransaction().replace(R.id.container, TrendingFragment).commit();
                return true;
            case R.id.navigation_Explore:
                getSupportFragmentManager().beginTransaction().replace(R.id.container, ExploreFragment).commit();
                return true;
            case R.id.navigation_Saved:
                getSupportFragmentManager().beginTransaction().replace(R.id.container, SavedFragment).commit();
                return true;

        }
        return false;
    }
}