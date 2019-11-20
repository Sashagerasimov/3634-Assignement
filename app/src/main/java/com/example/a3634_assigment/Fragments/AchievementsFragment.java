package com.example.a3634_assigment.Fragments;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.example.a3634_assigment.Database.SessionInfo;
import com.example.a3634_assigment.Models.Images;
import com.example.a3634_assigment.R;

public class AchievementsFragment extends Fragment {

    //instantiates widgets
    private TextView usernameTextView;
    private TextView scoreTextView;
    private ImageView avatarImage;


    @Nullable
    @Override

    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view =  inflater.inflate(R.layout.fragment_achievements, container, false);

        //finds views
        usernameTextView = view.findViewById(R.id.username);
        scoreTextView = view.findViewById(R.id.userScore);
        avatarImage = view.findViewById(R.id.userAvatar);

        //sets respective widgets
        usernameTextView.setText(SessionInfo.currentUser.getUsername());
        scoreTextView.setText(String.valueOf(SessionInfo.currentUser.getScore()));
        avatarImage.setImageResource(Images.avatars[SessionInfo.currentUser.getAvatar()]);

    return view;
    }
}
