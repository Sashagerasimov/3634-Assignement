package com.example.a3634_assigment.Fragments;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.example.a3634_assigment.Activities.PlanetActivity;
import com.example.a3634_assigment.R;

public class ReadFragment extends Fragment {
    private TextView description;

    public ReadFragment() {

    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_read, container, false);

        description = view.findViewById(R.id.description);
        description.setText(PlanetActivity.name);

        return view;
    }
}
