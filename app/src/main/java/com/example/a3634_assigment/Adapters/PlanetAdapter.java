package com.example.a3634_assigment.Adapters;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.a3634_assigment.Activities.PlanetActivity;
import com.example.a3634_assigment.Models.Bodies.Body;
import com.example.a3634_assigment.R;

import java.util.ArrayList;

public class PlanetAdapter extends RecyclerView.Adapter<PlanetAdapter.PlanetViewHolder> {
    public ArrayList<Body> planets = new ArrayList<>();

    public void setData(ArrayList<Body> planetsToAdapt) {
        this.planets = planetsToAdapt;

    }

    public static class PlanetViewHolder extends RecyclerView.ViewHolder {

        public View view;
        public TextView planetName;
        public PlanetViewHolder(View v) {
            super(v);
            view = v;
            planetName = v.findViewById(R.id.planet_name);
        }
    }
    @NonNull
    @Override
    public PlanetAdapter.PlanetViewHolder onCreateViewHolder (@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.planet, parent, false);

        PlanetAdapter.PlanetViewHolder planetViewHolder= new PlanetAdapter.PlanetViewHolder(view);
        return planetViewHolder;
    }
    @Override
    public void onBindViewHolder(@NonNull final PlanetViewHolder holder, final int position) {
        final Body currentBody = planets.get(position);
        holder.planetName.setText(currentBody.getEnglishName());

        holder.view.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Context context = view.getContext();

                Intent explicitIntent = new Intent(context, PlanetActivity.class);
                explicitIntent.putExtra("englishName", currentBody.getEnglishName());
                context.startActivity(explicitIntent);
            }
        });
    }
    @Override
    public int getItemCount() {
        return planets.size();
    }
}
