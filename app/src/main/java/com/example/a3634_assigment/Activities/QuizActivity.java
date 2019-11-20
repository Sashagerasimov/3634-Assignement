package com.example.a3634_assigment.Activities;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.res.ColorStateList;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

import com.example.a3634_assigment.Database.SessionInfo;
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
    private TextView correctScore;
    public TextView currentScore;
    public ColorStateList textColorDefaultRb;

    //declaring items needed
    ArrayList<Options> options;
    private int questionCounter = 0;
    private int questionCountTotal = 0;
    private int score = 0;
    private int correctCount;
    private Options currentQuestion;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_quiz);

        //linking widgets to xml layout
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
        correctScore = findViewById(R.id.correctNumber);

        //set labels as invisible
        currentScore.setVisibility(View.INVISIBLE);
        status.setVisibility(View.INVISIBLE);
        correctScore.setVisibility(View.INVISIBLE);


        //retrieve questions, options and answers from planet bank
        options = QuizBank.getOptions(PlanetActivity.name);

        //counts amount of options objects
        questionCountTotal = options.size();

        //shows next question
        refreshQuestion();

        //do following when clicked
        mark.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (!answered) { //if the question was not answered
                    if (rb1.isChecked() || rb2.isChecked() || rb3.isChecked() || rb4.isChecked()) {
                        markQuestion(); //if any of the radio buttons are selected, check the answer
                    } else {
                        Toast.makeText(QuizActivity.this, "Please Select an Answer", Toast.LENGTH_SHORT).show();
                    }
                } else {
                    refreshQuestion();//show next question
                }
            }
        });

    }

    //show next question
    private void refreshQuestion() {
        //sets radio button text colour to default
        rb1.setTextColor(textColorDefaultRb);
        rb2.setTextColor(textColorDefaultRb);
        rb3.setTextColor(textColorDefaultRb);
        rb4.setTextColor(textColorDefaultRb);
        radioGroup.clearCheck(); //clears check

        //if questions still remaining
        if (questionCounter < questionCountTotal) {
            currentQuestion = options.get(questionCounter);
            //set question textview and option radio buttons
            question.setText(currentQuestion.getQuestion());
            rb1.setText(currentQuestion.getOption1());
            rb2.setText(currentQuestion.getOption2());
            rb3.setText(currentQuestion.getOption3());
            rb4.setText(currentQuestion.getOption4());

            //add 1 to question counter
            questionCounter++;
            answered = false;
            mark.setText("Confirm");
        } else {
            //close quiz activity
            finish();
        }
    }

    private void markQuestion() {
        answered = true;

        //get id of selected radiobutton
        int selectedId = radioGroup.getCheckedRadioButtonId();

        //find radiobutton selected
        RadioButton radioButtonSelected = findViewById(selectedId);

        //get index of radiobutton and add 1, assign it to the option number chosen
        int answerNo = radioGroup.indexOfChild(radioButtonSelected) + 1;

        //If the answer selected is correct
        if (answerNo == currentQuestion.getAnswerNumber()) {
            score += 10; //increase score by 10
            SessionInfo.currentUser.setScore(SessionInfo.currentUser.getScore() + score); //immediately updates score of current user
            SessionInfo.mUserDatabase.userDao().updateScore(score, SessionInfo.currentUser.getUsername()); //updates score of current user
            correctCount++; //increases number of correct questions by 1
            currentScore.setVisibility(View.VISIBLE);
            currentScore.setText(String.valueOf(score));

            //pop ups for level unlocked
            if (SessionInfo.currentUser.getScore() == 200) {
                Toast.makeText(getApplicationContext(), "Level Venus Unlocked!", Toast.LENGTH_SHORT).show();
            } else if (SessionInfo.currentUser.getScore() == 300) {
                Toast.makeText(getApplicationContext(), "Level Earth Unlocked!", Toast.LENGTH_SHORT).show();
            } else if (SessionInfo.currentUser.getScore() == 400) {
                Toast.makeText(getApplicationContext(), "Level Mars Unlocked!", Toast.LENGTH_SHORT).show();
            } else if (SessionInfo.currentUser.getScore() == 500) {
                Toast.makeText(getApplicationContext(), "Level Jupiter Unlocked!", Toast.LENGTH_SHORT).show();
            } else if (SessionInfo.currentUser.getScore() == 600) {
                Toast.makeText(getApplicationContext(), "Level Saturn Unlocked!", Toast.LENGTH_SHORT).show();
            } else if (SessionInfo.currentUser.getScore() == 700) {
                Toast.makeText(getApplicationContext(), "Level Uranus Unlocked!", Toast.LENGTH_SHORT).show();
            } else if (SessionInfo.currentUser.getScore() == 800) {
                Toast.makeText(getApplicationContext(), "Level Neptune Unlocked!", Toast.LENGTH_SHORT).show();
            } else if (SessionInfo.currentUser.getScore() == 900) {
                Toast.makeText(getApplicationContext(), "Level Pluto Unlocked!", Toast.LENGTH_SHORT).show();
            }


        }
        //show solution
        showAnswer();
    }

    private void showAnswer() {
        //sets radio button text as red
        rb1.setTextColor(Color.RED);
        rb2.setTextColor(Color.RED);
        rb3.setTextColor(Color.RED);
        rb4.setTextColor(Color.RED);

        //makes label for correct answer as visible
        status.setVisibility(View.VISIBLE);

        //displays correct answer
        switch (currentQuestion.getAnswerNumber()) {
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
        if (questionCounter < questionCountTotal) {
            mark.setText("Next Question");
            //refreshQuestion();
        } else {
            mark.setText("Finish Quiz");
            finishQuiz();
        }


    }

    //finish quiz
    private void finishQuiz() {
        //displays correct score
        correctScore.setVisibility(View.VISIBLE);
        correctScore.setText("Your Score: " + correctCount + " / 8 ");

        //
        mark.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), DashboardActivity.class);
                startActivity(intent);
            }


        });
    }
}




