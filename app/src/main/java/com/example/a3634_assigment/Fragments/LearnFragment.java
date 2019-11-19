package com.example.a3634_assigment.Fragments;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.a3634_assigment.Adapters.PlanetAdapter;
import com.example.a3634_assigment.Database.PlanetBank;
import com.example.a3634_assigment.R;

public class LearnFragment extends Fragment {
    private RecyclerView recyclerView;

    public LearnFragment() {

    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_learn, container, false);
        recyclerView = view.findViewById(R.id.planet_rv);
        LinearLayoutManager layoutManager = new LinearLayoutManager(view.getContext());
        recyclerView.setLayoutManager(layoutManager);

        PlanetAdapter planetAdapter = new PlanetAdapter();

        planetAdapter.setData(PlanetBank.getAllPlanets());
        recyclerView.setAdapter(planetAdapter);

        return view;
    }
}
