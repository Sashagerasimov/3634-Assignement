package com.example.a3634_assigment.Activities;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.a3634_assigment.Databases.SessionInfo;
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
        toolbar.setBackground(getResources().getDrawable(R.drawable.gradient));

        drawer = findViewById(R.id.drawer_layout);
        NavigationView navigationView = findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);

        //accessibility best practice
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

        //headerUser.setText(SessionInfo.currentUser.getUsername());
        headerUser.setText(String.valueOf(SessionInfo.currentUser.getUsername()));
        headerAvatar.setImageResource(Images.avatars[SessionInfo.currentUser.getAvatar()]);

    }
    //sets up tabs for side menu and handle switching the frame layout
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
            case R.id.nav_logout:
                finish();
                Intent myIntentTwo = new Intent(DashboardActivity.this, MainActivity.class);
                DashboardActivity.this.startActivity(myIntentTwo);
                break;
        }

        drawer.closeDrawer(GravityCompat.START);
        return true;
    }

    //required to double press to exit
    boolean doubleBackToExitPressedOnce = false;

    //back button closes the app side menu if it extended
    @Override
    public void onBackPressed() {
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        }

        if (doubleBackToExitPressedOnce) {
            super.onBackPressed();
            return;
        }

        this.doubleBackToExitPressedOnce = true;
        Toast.makeText(this, "Click BACK again to exit", Toast.LENGTH_SHORT).show();

        new Handler().postDelayed(new Runnable() {

            @Override
            public void run() {
                doubleBackToExitPressedOnce=false;
            }
        }, 2000);
    }
}