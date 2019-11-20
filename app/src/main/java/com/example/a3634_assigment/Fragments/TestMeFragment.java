package com.example.a3634_assigment.Fragments;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.example.a3634_assigment.Activities.PlanetActivity;
import com.example.a3634_assigment.Activities.QuizActivity;
import com.example.a3634_assigment.Models.Options;
import com.example.a3634_assigment.R;

import java.util.ArrayList;

public class TestMeFragment extends Fragment {

    //initialising widgets
    private Button startQuiz;




    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_test_me, container, false);

        startQuiz = view.findViewById(R.id.startQuiz);
        //on click, start quiz
        startQuiz.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Context context = v.getContext();
                Intent intent = new Intent(context, QuizActivity.class);
                intent.putExtra("planet", PlanetActivity.name);
                context.startActivity(intent);
            }
        });


        return view;
    }
}
