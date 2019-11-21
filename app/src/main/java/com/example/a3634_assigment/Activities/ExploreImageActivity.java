package com.example.a3634_assigment.Activities;

import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.util.Log;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.ColorInt;
import androidx.appcompat.app.AppCompatActivity;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.bumptech.glide.Glide;
import com.example.a3634_assigment.R;
import com.github.chrisbanes.photoview.PhotoView;
import com.google.gson.Gson;

public class ExploreImageActivity extends AppCompatActivity {

    //private ImageView imagePhoto;
    private PhotoView imagePhoto;
    private TextView imageTitle;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getSupportActionBar().hide();
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
            getWindow().setStatusBarColor(getResources().getColor(R.color.black, this.getTheme()));
        } else if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            getWindow().setStatusBarColor(getResources().getColor(R.color.black));
        }
        setContentView(R.layout.activity_explore_image);

        imagePhoto = findViewById(R.id.planet_image);
        imageTitle = findViewById(R.id.image_title);

        Intent intent = getIntent();
        String url = intent.getStringExtra("url");
        String title = intent.getStringExtra("title");

        imageTitle.setText(title);
        Glide.with(ExploreImageActivity.this).load(url).into(imagePhoto);
    }
}
