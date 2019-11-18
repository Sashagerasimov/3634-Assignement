package com.example.a3634_assigment.Activities;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.a3634_assigment.Database.SessionInfo;
import com.example.a3634_assigment.Fragments.AchievementsFragment;
import com.example.a3634_assigment.Fragments.LearnFragment;
import com.example.a3634_assigment.Fragments.NotesFragment;
import com.example.a3634_assigment.Models.User;
import com.example.a3634_assigment.R;
import com.google.android.material.navigation.NavigationView;
import com.google.android.material.textfield.TextInputLayout;

public class MainActivity extends AppCompatActivity {
    //LOGIN CLASS

    private DrawerLayout drawer;
    public Button rego;
    public TextInputLayout username;
    public TextInputLayout password;
    public Button login;
    public TextView message;

    // implements NavigationView.OnNavigationItemSelectedListener
    //https://codinginflow.com/tutorials/android/textinputlayout
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        SessionInfo.createDB(this);

        rego = findViewById(R.id.button);
        username = findViewById(R.id.un);
        password = findViewById(R.id.pw);
        login = findViewById(R.id.login);
        message = findViewById(R.id.message);
        //message.s
        rego.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Context context = v.getContext();
                Intent intent = new Intent(context, RegisterActivity.class);
                context.startActivity(intent);
            }
        });

        /*login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                User loginUser = SessionInfo.mUserDatabase.userDao().returnOneUserByUserName(username.getEditText().toString());

                if (loginUser.getPassword().equals(password.getEditText().toString())) {
                    Context context = v.getContext();
                    Intent intent = new Intent(context, DashboardActivity.class);
                    context.startActivity(intent);
                    SessionInfo.currentUser = loginUser;
                }
            }
        });

         */
    }

    private boolean validateUsername() {
        String usernameInput = username.getEditText().getText().toString().trim();

        if (usernameInput.isEmpty()) {
            username.setError("Field can't be empty");
            return false;

        } else {
            username.setError(null);
            return true;
        }
    }

    private boolean validatePassword() {
        String pwInput = password.getEditText().getText().toString().trim();

        if (pwInput.isEmpty()) {
            password.setError("Field can't be empty");
            return false;

        } else {
            password.setError(null);
            return true;
        }
    }

    public void confirmInput(View v) {
        if (!validateUsername() | !validatePassword()) {
            User loginUser = SessionInfo.mUserDatabase.userDao().returnOneUserByUserName(username.getEditText().toString());

            if (loginUser.getPassword().equals(password.getEditText().toString())) {
                Context context = v.getContext();
                Intent intent = new Intent(context, DashboardActivity.class);
                context.startActivity(intent);
                SessionInfo.currentUser = loginUser;
            }
        }
            else{
                Toast.makeText(this, "Credentials Incorrect. Please try again", Toast.LENGTH_SHORT).show();


            }



            return;
        }

    }




        /*
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
    }

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
            case R.id.nav_settings:
                Intent myIntent = new Intent(MainActivity.this, SettingsActivity.class);
                MainActivity.this.startActivity(myIntent);
                break;


        }

        drawer.closeDrawer(GravityCompat.START);
        return true;
    }


    @Override
    public void onBackPressed() {
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }

         */


