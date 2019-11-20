package com.example.a3634_assigment.Fragments;

import android.app.Dialog;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.a3634_assigment.Adapters.PlanetAdapter;
import com.example.a3634_assigment.Database.PlanetBank;
import com.example.a3634_assigment.Database.SessionInfo;
import com.example.a3634_assigment.R;

public class LearnFragment extends Fragment {
    private RecyclerView recyclerView;
    private TextView levelUnlock;

    public LearnFragment() {

    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_learn, container, false);

        //set up recyclerview and adapter
        recyclerView = view.findViewById(R.id.planet_rv);
        LinearLayoutManager layoutManager = new LinearLayoutManager(view.getContext());
        recyclerView.setLayoutManager(layoutManager);
        levelUnlock = view.findViewById(R.id.currentLevelTextView);
        PlanetAdapter planetAdapter = new PlanetAdapter();

        //unlocks levels according to user score
        if(SessionInfo.currentUser.getScore()>=100) {
            planetAdapter.setData(PlanetBank.getLevel1());
            recyclerView.setAdapter(planetAdapter);
            levelUnlock.setText("Earn "+ (200 - SessionInfo.currentUser.getScore()) + " more points to unlock Level Venus!");


        }
        if(SessionInfo.currentUser.getScore()>=200) {
            planetAdapter.setData(PlanetBank.getLevel2());
            recyclerView.setAdapter(planetAdapter);
            levelUnlock.setText("Earn "+ (300 - SessionInfo.currentUser.getScore()) + " more points to unlock Level Earth!");

        }
        if(SessionInfo.currentUser.getScore()>=300) {
            planetAdapter.setData(PlanetBank.getLevel3());
            recyclerView.setAdapter(planetAdapter);
            levelUnlock.setText("Earn "+ (400 - SessionInfo.currentUser.getScore()) + " more points to unlock Level Mars!");
        }
        if(SessionInfo.currentUser.getScore()>=400) {
            planetAdapter.setData(PlanetBank.getLevel4());
            recyclerView.setAdapter(planetAdapter);
            levelUnlock.setText("Earn "+ (500 - SessionInfo.currentUser.getScore()) + " more points to unlock Level Jupiter!");

        }
        if(SessionInfo.currentUser.getScore()>=500) {
            planetAdapter.setData(PlanetBank.getLevel5());
            recyclerView.setAdapter(planetAdapter);
            levelUnlock.setText("Earn "+ (600 - SessionInfo.currentUser.getScore()) + " more points to unlock Level Saturn!");

        }
        if(SessionInfo.currentUser.getScore()>=600) {
            planetAdapter.setData(PlanetBank.getLevel6());
            recyclerView.setAdapter(planetAdapter);
            levelUnlock.setText("Earn "+ (700 - SessionInfo.currentUser.getScore()) + " more points to unlock Level Uranus!");

        }
        if(SessionInfo.currentUser.getScore()>=700) {
            planetAdapter.setData(PlanetBank.getLevel7());
            recyclerView.setAdapter(planetAdapter);
            levelUnlock.setText("Earn "+ (800 - SessionInfo.currentUser.getScore()) + " more points to unlock Level Neptune!");

        }
        if(SessionInfo.currentUser.getScore()>=800) {
            planetAdapter.setData(PlanetBank.getLevel8());
            recyclerView.setAdapter(planetAdapter);
            levelUnlock.setText("Earn "+ (900 - SessionInfo.currentUser.getScore()) + " more points to unlock Level Pluto!");

        }
        if(SessionInfo.currentUser.getScore()>=900) {
            planetAdapter.setData(PlanetBank.getLevel9());
            recyclerView.setAdapter(planetAdapter);
            levelUnlock.setText("Congratulations! You have finished Solaris!");
        }
        return view;

    }


}
