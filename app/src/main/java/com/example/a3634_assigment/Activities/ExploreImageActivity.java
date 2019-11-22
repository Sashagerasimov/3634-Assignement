package com.example.a3634_assigment.Activities;

import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.bumptech.glide.Glide;
import com.example.a3634_assigment.R;
import com.github.chrisbanes.photoview.PhotoView;

public class ExploreImageActivity extends AppCompatActivity {

    private PhotoView imagePhoto;
    private TextView imageTitle;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        //hides toolbar and sets notification bar to black
        getSupportActionBar().hide();
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
            getWindow().setStatusBarColor(getResources().getColor(R.color.black, this.getTheme()));
        } else if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            getWindow().setStatusBarColor(getResources().getColor(R.color.black));
        }

        setContentView(R.layout.activity_explore_image);

        imagePhoto = findViewById(R.id.planet_image);
        imageTitle = findViewById(R.id.image_title);

        //grab url and title intent from explore fragment with images
        Intent intent = getIntent();
        String url = intent.getStringExtra("url");
        String title = intent.getStringExtra("title");

        //set the title and image in activity
        imageTitle.setText(title);
        Glide.with(ExploreImageActivity.this).load(url).into(imagePhoto);
    }
}
