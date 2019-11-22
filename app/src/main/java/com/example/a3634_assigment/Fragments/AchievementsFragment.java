package com.example.a3634_assigment.Fragments;

import android.app.Dialog;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.cardview.widget.CardView;
import androidx.fragment.app.Fragment;

import com.example.a3634_assigment.Activities.DialogActivity;
import com.example.a3634_assigment.Databases.SessionInfo;
import com.example.a3634_assigment.Models.Images;
import com.example.a3634_assigment.R;

public class AchievementsFragment extends Fragment {

    //instantiates widgets
    private TextView usernameTextView;
    private TextView scoreTextView;
    private ImageView avatarImage;
    private CardView badge1;
    private CardView badge2;
    private CardView badge3;
    private CardView badge4;
    private CardView badge5;
    private CardView badge6;
    private CardView badge7;
    private CardView badge8;
    private CardView badge9;
    private Dialog badgeDialog;
    private TextView badgeName;
    private Button close;
    public final static String PLANET = "com.example.a3634_assigment.planet";


    @Nullable
    @Override

    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view =  inflater.inflate(R.layout.fragment_achievements, container, false);

        //finds views
        usernameTextView = view.findViewById(R.id.username);
        scoreTextView = view.findViewById(R.id.userScore);
        avatarImage = view.findViewById(R.id.userAvatar);
        badge1 = view.findViewById(R.id.badgeOne);
        badge2 = view.findViewById(R.id.badgeTwo);
        badge3 = view.findViewById(R.id.badgeThree);
        badge4 = view.findViewById(R.id.badgeFour);
        badge5 = view.findViewById(R.id.badgeFive);
        badge6 = view.findViewById(R.id.badgeSix);
        badge7 = view.findViewById(R.id.badgeSeven);
        badge8 = view.findViewById(R.id.badgeEight);
        badge9 = view.findViewById(R.id.badgeNine);



        //sets respective widgets for user card
        usernameTextView.setText(SessionInfo.currentUser.getUsername());
        scoreTextView.setText(String.valueOf(SessionInfo.currentUser.getScore()));
        avatarImage.setImageResource(Images.avatars[SessionInfo.currentUser.getAvatar()]);


        //set all badges as initially invisible
        badge1.setVisibility(View.INVISIBLE);
        badge2.setVisibility(View.INVISIBLE);
        badge3.setVisibility(View.INVISIBLE);
        badge4.setVisibility(View.INVISIBLE);
        badge5.setVisibility(View.INVISIBLE);
        badge6.setVisibility(View.INVISIBLE);
        badge7.setVisibility(View.INVISIBLE);
        badge8.setVisibility(View.INVISIBLE);
        badge9.setVisibility(View.INVISIBLE);


        if (SessionInfo.currentUser.getScore()<=100){
            badge1.setVisibility(View.VISIBLE);
        }
        else if (100 < SessionInfo.currentUser.getScore() && SessionInfo.currentUser.getScore() <= 200){
            badge2.setVisibility(View.VISIBLE);
            badge1.setVisibility(View.VISIBLE);
        }
        else if (200 < SessionInfo.currentUser.getScore() && SessionInfo.currentUser.getScore() <= 300){
            badge3.setVisibility(View.VISIBLE);
            badge2.setVisibility(View.VISIBLE);
            badge1.setVisibility(View.VISIBLE);
        }
        else if (300 < SessionInfo.currentUser.getScore() && SessionInfo.currentUser.getScore() <= 400){
            badge4.setVisibility(View.VISIBLE);
            badge3.setVisibility(View.VISIBLE);
            badge2.setVisibility(View.VISIBLE);
            badge1.setVisibility(View.VISIBLE);
        }
        else if (400 < SessionInfo.currentUser.getScore() && SessionInfo.currentUser.getScore() <= 500){
            badge5.setVisibility(View.VISIBLE);
            badge4.setVisibility(View.VISIBLE);
            badge3.setVisibility(View.VISIBLE);
            badge2.setVisibility(View.VISIBLE);
            badge1.setVisibility(View.VISIBLE);
        }
        else if (500 < SessionInfo.currentUser.getScore() && SessionInfo.currentUser.getScore() <= 600){
            badge6.setVisibility(View.VISIBLE);
            badge5.setVisibility(View.VISIBLE);
            badge4.setVisibility(View.VISIBLE);
            badge3.setVisibility(View.VISIBLE);
            badge2.setVisibility(View.VISIBLE);
            badge1.setVisibility(View.VISIBLE);
        }
        else if (600 < SessionInfo.currentUser.getScore() && SessionInfo.currentUser.getScore() <= 700){
            badge7.setVisibility(View.VISIBLE);
            badge6.setVisibility(View.VISIBLE);
            badge5.setVisibility(View.VISIBLE);
            badge4.setVisibility(View.VISIBLE);
            badge3.setVisibility(View.VISIBLE);
            badge2.setVisibility(View.VISIBLE);
            badge1.setVisibility(View.VISIBLE);
        }
        else if (700 < SessionInfo.currentUser.getScore() && SessionInfo.currentUser.getScore() <= 800){
            badge8.setVisibility(View.VISIBLE);
            badge7.setVisibility(View.VISIBLE);
            badge6.setVisibility(View.VISIBLE);
            badge5.setVisibility(View.VISIBLE);
            badge4.setVisibility(View.VISIBLE);
            badge3.setVisibility(View.VISIBLE);
            badge2.setVisibility(View.VISIBLE);
            badge1.setVisibility(View.VISIBLE);

        }

        else if (800 < SessionInfo.currentUser.getScore()){
            badge9.setVisibility(View.VISIBLE);
            badge8.setVisibility(View.VISIBLE);
            badge7.setVisibility(View.VISIBLE);
            badge6.setVisibility(View.VISIBLE);
            badge5.setVisibility(View.VISIBLE);
            badge4.setVisibility(View.VISIBLE);
            badge3.setVisibility(View.VISIBLE);
            badge2.setVisibility(View.VISIBLE);
            badge1.setVisibility(View.VISIBLE);
        }



        badge1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


                Bundle args = new Bundle();
                args.putString("key", "Mercury Magician");
                args.putInt("keySticker", 0);
                DialogActivity dialog = new DialogActivity();
                dialog.setTargetFragment(AchievementsFragment.this, 1);
                dialog.show(getFragmentManager(), "MyCustomDialog");


                dialog.setArguments(args);
            }
        });

        badge2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


                Bundle args = new Bundle();
                args.putString("key", "Venus Veteran");
                args.putInt("keySticker", 1);
                DialogActivity dialog = new DialogActivity();
                dialog.setTargetFragment(AchievementsFragment.this, 1);
                dialog.show(getFragmentManager(), "MyCustomDialog");


                dialog.setArguments(args);
            }
        });
        badge3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


                Bundle args = new Bundle();
                args.putString("key", "Earth Expert");
                args.putInt("keySticker", 2);
                DialogActivity dialog = new DialogActivity();
                dialog.setTargetFragment(AchievementsFragment.this, 1);
                dialog.show(getFragmentManager(), "MyCustomDialog");


                dialog.setArguments(args);
            }
        });

        badge4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


                Bundle args = new Bundle();
                args.putString("key", "Mars Maniac");
                args.putInt("keySticker", 3);
                DialogActivity dialog = new DialogActivity();
                dialog.setTargetFragment(AchievementsFragment.this, 1);
                dialog.show(getFragmentManager(), "MyCustomDialog");


                dialog.setArguments(args);
            }
        });
        badge5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


                Bundle args = new Bundle();
                args.putString("key", "Jupiter Janitor");
                args.putInt("keySticker", 4);
                DialogActivity dialog = new DialogActivity();
                dialog.setTargetFragment(AchievementsFragment.this, 1);
                dialog.show(getFragmentManager(), "MyCustomDialog");


                dialog.setArguments(args);
            }
        });
        badge6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


                Bundle args = new Bundle();
                args.putString("key", "Saturn Superstar");
                args.putInt("keySticker", 5);
                DialogActivity dialog = new DialogActivity();
                dialog.setTargetFragment(AchievementsFragment.this, 1);
                dialog.show(getFragmentManager(), "MyCustomDialog");


                dialog.setArguments(args);
            }
        });
        badge7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


                Bundle args = new Bundle();
                args.putString("key", "Uranus Underdog");
                args.putInt("keySticker", 6);
                DialogActivity dialog = new DialogActivity();
                dialog.setTargetFragment(AchievementsFragment.this, 1);
                dialog.show(getFragmentManager(), "MyCustomDialog");


                dialog.setArguments(args);
            }
        });
        badge8.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


                Bundle args = new Bundle();
                args.putString("key", "Neptune Novice");
                args.putInt("keySticker", 7);
                DialogActivity dialog = new DialogActivity();
                dialog.setTargetFragment(AchievementsFragment.this, 1);
                dialog.show(getFragmentManager(), "MyCustomDialog");


                dialog.setArguments(args);
            }
        });
        badge9.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


                Bundle args = new Bundle();
                args.putString("key", "Pluto Perfectionist");
                args.putInt("keySticker", 8);
                DialogActivity dialog = new DialogActivity();
                dialog.setTargetFragment(AchievementsFragment.this, 1);
                dialog.show(getFragmentManager(), "MyCustomDialog");


                dialog.setArguments(args);
            }
        });


        return view;

    }
}
