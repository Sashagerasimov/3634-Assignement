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
    public RadioButton rb1;
    public RadioButton rb2;
    public RadioButton rb3;
    public RadioButton rb4;
    public Button next;
    public Button mark;
    public TextView question;
    private TextView textViewScore;

    private Button startQuiz;

    String planet;
    ArrayList<String> questionList;
    ArrayList<Options> options;
    private int questionCounter;
    private int questionCountTotal;
    private int score;


    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_test_me, container, false);
        /*
        rb1 = view.findViewById(R.id.option1);
        rb2 = view.findViewById(R.id.option2);
        rb3 = view.findViewById(R.id.option3);
        rb4 = view.findViewById(R.id.option4);
        question = view.findViewById(R.id.question);

         */
        startQuiz = view.findViewById(R.id.startQuiz);


        //view.setOnClickListener(new View.OnClickListener() {
        //            @Override
        //            public void onClick(View view) {
        //                Context context = view.getContext();
        //
        //                Intent intent = new Intent(context, CatDetail.class);
        //                intent.putExtra("id", catsAtPosition.getId());
        //                context.startActivity(intent);


        startQuiz.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Context context = v.getContext();
                Intent intent = new Intent(context, QuizActivity.class);
                intent.putExtra("planet", PlanetActivity.name);
                context.startActivity(intent);
            }
        });



        //question.setText(PlanetActivity.name);

        return view;
    }
}
