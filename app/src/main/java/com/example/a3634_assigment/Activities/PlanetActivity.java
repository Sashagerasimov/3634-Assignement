package com.example.a3634_assigment.Activities;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import com.example.a3634_assigment.Fragments.ExploreFragment;
import com.example.a3634_assigment.Fragments.ReadFragment;
import com.example.a3634_assigment.Fragments.TestMeFragment;
import com.example.a3634_assigment.R;
import com.google.android.material.bottomnavigation.BottomNavigationView;

public class PlanetActivity extends AppCompatActivity {

    public BottomNavigationView bottomNavigationView;
    public static String name;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_planet);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);


        //SETTING UP PLANETS
        Intent intent = getIntent();
        String englishName = intent.getStringExtra("Name");
        getSupportActionBar().setTitle(englishName);
        name = englishName;

        Fragment defaultFragment = new ReadFragment();
        swapFragment(defaultFragment);

        bottomNavigationView = findViewById(R.id.navigation_bar);
        bottomNavigationView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {

                if (menuItem.getItemId() == R.id.bottom_navigation_read) {
                    Fragment fragment = new ReadFragment();
                    swapFragment(fragment);
                    return true;
                } else if (menuItem.getItemId() == R.id.bottom_navigation_explore) {
                    Fragment fragment = new ExploreFragment();
                    swapFragment(fragment);
                    return true;
                } else if (menuItem.getItemId() == R.id.bottom_navigation_test_me) {
                    Fragment fragment = new TestMeFragment();
                    swapFragment(fragment);
                    return true;
                }
                return false;
            }
        });
    }

    private void swapFragment(Fragment selectedFragment) {
        FragmentManager fragmentManager = getSupportFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        fragmentTransaction.replace(R.id.fragments, selectedFragment);
        fragmentTransaction.commit();
    }
}
