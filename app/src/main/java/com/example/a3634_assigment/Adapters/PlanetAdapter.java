package com.example.a3634_assigment.Adapters;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.a3634_assigment.Activities.PlanetActivity;
import com.example.a3634_assigment.Models.Planet;
import com.example.a3634_assigment.R;

import java.util.ArrayList;

public class PlanetAdapter extends RecyclerView.Adapter<PlanetAdapter.PlanetViewHolder> {
    public ArrayList<Planet> planets = new ArrayList<>();

    public void setData(ArrayList<Planet> planetsToAdapt) {
        this.planets = planetsToAdapt;

    }

    public static class PlanetViewHolder extends RecyclerView.ViewHolder {

        public View view;
        public TextView planetName;
        public ImageView planetImage;
        public PlanetViewHolder(View v) {
            super(v);
            view = v;
            planetName = v.findViewById(R.id.planet_name);
            planetImage =v.findViewById(R.id.planet_image);
        }
    }
    @NonNull
    @Override
    public PlanetAdapter.PlanetViewHolder onCreateViewHolder (@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.planet, parent, false);

        PlanetAdapter.PlanetViewHolder planetViewHolder= new PlanetAdapter.PlanetViewHolder(view);
        return planetViewHolder;
    }
    //onBindViewHolder uses intents to pass name of current planet which
    // will be used for the planet activity
    @Override
    public void onBindViewHolder(@NonNull final PlanetViewHolder holder, final int position) {
        final Planet currentPlanet = planets.get(position);
        holder.planetName.setText(currentPlanet.getName());
        holder.planetImage.setImageResource(currentPlanet.getImageDrawableId());

        holder.view.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Context context = view.getContext();

                Intent explicitIntent = new Intent(context, PlanetActivity.class);
                explicitIntent.putExtra("Name", currentPlanet.getName());
                context.startActivity(explicitIntent);
            }
        });
    }
    @Override
    public int getItemCount() {
        return planets.size();
    }
}
