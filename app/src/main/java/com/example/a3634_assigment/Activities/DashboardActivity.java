package com.example.a3634_assigment.Activities;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.a3634_assigment.Database.SessionInfo;
import com.example.a3634_assigment.Fragments.AchievementsFragment;
import com.example.a3634_assigment.Fragments.LearnFragment;
import com.example.a3634_assigment.Fragments.NotesFragment;
import com.example.a3634_assigment.Models.Images;
import com.example.a3634_assigment.R;
import com.google.android.material.navigation.NavigationView;

public class DashboardActivity extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener {
    //declare widgets
    private DrawerLayout drawer;
    public TextView headerUser;
    public ImageView headerAvatar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //sets up side burger menu
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        drawer = findViewById(R.id.drawer_layout);
        NavigationView navigationView = findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);

        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(this, drawer, toolbar,
                R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.addDrawerListener(toggle);
        toggle.syncState();

        if (savedInstanceState == null) {
            getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container,
                    new LearnFragment()).commit();
            navigationView.setCheckedItem(R.id.nav_learn);
        }

        //set username and avatar picture in header
        View headerView = navigationView.getHeaderView(0);
        headerUser = (TextView) headerView.findViewById(R.id.navUserName);
        headerAvatar = (ImageView) headerView.findViewById(R.id.currentAvatar);
        headerUser.setText(SessionInfo.currentUser.getUsername());
        headerAvatar.setImageResource(Images.avatars[SessionInfo.currentUser.getAvatar()]);

    }
    //sets up tabs for side menu
    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()) {
            case R.id.nav_learn:
                getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container,
                        new LearnFragment()).commit();
                break;
            case R.id.nav_achievements:
                getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container,
                        new AchievementsFragment()).commit();
                break;
            case R.id.nav_notes:
                getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container,
                        new NotesFragment()).commit();
                break;
            case R.id.nav_watch:
                Intent myIntentOne = new Intent(DashboardActivity.this, WatchActivity.class);
                DashboardActivity.this.startActivity(myIntentOne);
                break;
            case R.id.nav_settings:
                Intent myIntentTwo = new Intent(DashboardActivity.this, SettingsActivity.class);
                DashboardActivity.this.startActivity(myIntentTwo);
                break;


        }

        drawer.closeDrawer(GravityCompat.START);
        return true;
    }

    //closes side menu on back button
    @Override
    public void onBackPressed() {
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }
}