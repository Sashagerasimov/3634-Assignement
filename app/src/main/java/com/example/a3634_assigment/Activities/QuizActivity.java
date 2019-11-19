package com.example.a3634_assigment.Activities;

import androidx.appcompat.app.AppCompatActivity;

import android.content.res.ColorStateList;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

import com.example.a3634_assigment.Models.Options;
import com.example.a3634_assigment.Models.QuizBank;
import com.example.a3634_assigment.R;

import java.util.ArrayList;

public class QuizActivity extends AppCompatActivity {

    /*Code Resource:
    Author: Coding in Flow - youtube user
    Year: 2017
    Link: https://www.youtube.com/watch?v=5ISNPFmuOU8
    */

    //initialising widgets
    public RadioButton rb1;
    public RadioButton rb2;
    public RadioButton rb3;
    public RadioButton rb4;
    public RadioGroup radioGroup;
    public Button next;
    public Button mark;
    private boolean answered;
    public TextView question;
    private TextView status;
    public TextView currentScore;
    public ColorStateList textColorDefaultRb;


    String planet;
    ArrayList<String> questionList;
    ArrayList<Options> options;
    private int questionCounter = 0;
    private int questionCountTotal;
    private int score = 0;
    int currentQuestion = 0;
    int currentAnswer;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_quiz);

        rb1 = findViewById(R.id.option1);
        rb2 = findViewById(R.id.option2);
        rb3 = findViewById(R.id.option3);
        rb4 = findViewById(R.id.option4);
        radioGroup = findViewById(R.id.radioGroup);
        question = findViewById(R.id.question);
        mark = findViewById(R.id.nextQuestion);
        textColorDefaultRb = rb1.getTextColors();
        status = findViewById(R.id.correct);
        currentScore = findViewById(R.id.userScore);

        currentScore.setVisibility(View.INVISIBLE);
        status.setVisibility(View.INVISIBLE);

        //question.setText(PlanetActivity.name);

        questionList = QuizBank.getQuestions(PlanetActivity.name);
        questionCountTotal = questionList.size();
        options = QuizBank.getOptions(PlanetActivity.name);
        refreshQuestion();


        mark.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                if (!answered){ //if the question was not answered
                    if(rb1.isChecked() || rb2.isChecked() || rb3.isChecked() || rb4.isChecked()){
                        markQuestion(); //if any of the radio buttons are selected, check the answer
                    } else {
                        Toast.makeText(QuizActivity.this, "Please Select an Answer", Toast.LENGTH_SHORT).show();
                    }
                } else {
                    refreshQuestion();
                }
            }
        });

    }
    private void refreshQuestion() {
        rb1.setTextColor(textColorDefaultRb);
        rb2.setTextColor(textColorDefaultRb);
        rb3.setTextColor(textColorDefaultRb);
        rb4.setTextColor(textColorDefaultRb);
        radioGroup.clearCheck();

        if (questionCounter < questionCountTotal){
            question.setText(questionList.get(questionCounter));
            rb1.setText(options.get(questionCounter).getOption1());
            rb2.setText(options.get(questionCounter).getOption2());
            rb3.setText(options.get(questionCounter).getOption3());
            rb4.setText(options.get(questionCounter).getOption4());

            questionCounter++;
            answered = false;
        }
        else {
            finish();
        }
    }

    private void markQuestion(){
        answered = true;

        int selectedId = radioGroup.getCheckedRadioButtonId();
        RadioButton radioButtonSelected = findViewById(selectedId);
        currentScore.setText(String.valueOf(selectedId));
        //RadioButton radioButtonSelected = findViewById(radioGroup.getCheckedRadioButtonId());
        int answerNo = radioGroup.indexOfChild(radioButtonSelected) + 1;
        //If the answer selected is correct
        //up until the last question
        if (questionCounter <  questionCountTotal - 1) {
            if (answerNo == options.get(questionCounter).getAnswerNumber()) {
                score += 10; //increase score by 10
                currentScore.setVisibility(View.VISIBLE);
                currentScore.setText(String.valueOf(score));
                refreshQuestion();
                //display the increased score
            } else {

                showAnswer();
            }
        }
        else if (questionCounter == questionCountTotal-1) {
            if (answerNo == options.get(questionCounter-1).getAnswerNumber()) {
                score += 10; //increase score
                currentScore.setVisibility(View.VISIBLE);
                currentScore.setText(String.valueOf(score));
                refreshQuestion(); //display the increased score
            } else {

                showAnswer();
            }
        }
    }
    private void showAnswer(){
        rb1.setTextColor(Color.RED);
        rb2.setTextColor(Color.RED);
        rb3.setTextColor(Color.RED);
        rb4.setTextColor(Color.RED);

        status.setVisibility(View.VISIBLE);
        switch(options.get(questionCounter).getAnswerNumber()){
            case 1:
                rb1.setTextColor(Color.GREEN);
                status.setText("Answer 1 is Correct!");
                break;
            case 2:
                rb2.setTextColor(Color.GREEN);
                status.setText("Answer 2 is Correct!");
                break;
            case 3:
                rb3.setTextColor(Color.GREEN);
                status.setText("Answer 3 is Correct!");
                break;
            case 4:
                rb4.setTextColor(Color.GREEN);
                status.setText("Answer 4 is Correct!");
                break;
        }
        if(questionCounter < questionCountTotal){
            mark.setText("Next Question");
            refreshQuestion();
        }
        else{
            mark.setText("Finish Quiz");
            finish();
        }
    }



}




