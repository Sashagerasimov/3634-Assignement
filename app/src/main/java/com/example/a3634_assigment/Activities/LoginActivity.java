package com.example.a3634_assigment.Activities;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.example.a3634_assigment.Database.SessionInfo;
import com.example.a3634_assigment.R;

public class LoginActivity extends AppCompatActivity {


    public TextView username;
    public TextView password;
    public Button rego;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        SessionInfo.createDB(this.getApplicationContext());
        //rego = findViewById(R.id.register);


        rego.setOnClickListener(new View.OnClickListener(){
            public void onClick(View view) {
                Context context = view.getContext();
                Intent intent = new Intent(context, RegisterActivity.class);
                context.startActivity(intent);
            }
        });

    }



    public void onRegisterButtonPress(View view) {
        // Takes user to the registration page
        Intent intent = new Intent(this, RegisterActivity.class);
        startActivity(intent);

    }
}
