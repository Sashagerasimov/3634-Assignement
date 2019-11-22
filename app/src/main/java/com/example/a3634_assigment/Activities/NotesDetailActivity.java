package com.example.a3634_assigment.Activities;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import com.example.a3634_assigment.Fragments.NotesFragment;
import com.example.a3634_assigment.Models.Notes;
import com.example.a3634_assigment.R;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.bumptech.glide.Glide;
import com.google.gson.Gson;

import java.util.ArrayList;
import java.util.Arrays;

public class NotesDetailActivity extends AppCompatActivity {

    private TextView title;
    private TextView content;
//
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ActionBar actionbar = getSupportActionBar();
        actionbar.setBackgroundDrawable(getResources().getDrawable(R.drawable.gradient));
        setContentView(R.layout.activity_notes_detail);

        Intent intent = getIntent();
        int notesID = intent.getIntExtra("id", -1);

        final Notes thisNote = getNotesById(notesID);


        //final Menu currentFood = Database.getFoodById(foodPosition);

        title = findViewById(R.id.dTitle);
        content = findViewById(R.id.dContent);


        title.setText(thisNote.getTitle());
        content.setText(thisNote.getContent());

    }

    public static Notes getNotesById(int notesID) {
        return NotesFragment.notesList.get(notesID);
    }
}
