package com.example.a3634_assigment.Fragments;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.example.a3634_assigment.Adapters.PlanetAdapter;
import com.example.a3634_assigment.Models.Bodies.Body;
import com.example.a3634_assigment.Models.Bodies.BodyResponse;
import com.example.a3634_assigment.R;
import com.google.gson.Gson;

import java.util.ArrayList;
import java.util.List;

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

        final PlanetAdapter planetAdapter = new PlanetAdapter();

        String solarUrl = "https://api.le-systeme-solaire.net/rest/bodies/";

        Context context = getContext();
        RequestQueue requestQueue = Volley.newRequestQueue(context);

        Response.Listener<String> responseListener = new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                Gson gson = new Gson();
                BodyResponse bodyResponse = gson.fromJson(response, BodyResponse.class);
                List<Body> bodies = bodyResponse.getBodies();
                ArrayList<Body> planets = new ArrayList<>();
                planets.add(bodies.get(240));
                planets.add(bodies.get(244));
                planets.add(bodies.get(243));
                planets.add(bodies.get(239));
                planets.add(bodies.get(238));
                planets.add(bodies.get(241));
                planets.add(bodies.get(199));
                planets.add(bodies.get(219));
                planets.add(bodies.get(208));

                planetAdapter.setData(planets);
                recyclerView.setAdapter(planetAdapter);
                
            }
        };

        Response.ErrorListener errorListener = new Response.ErrorListener() {
            @Override
            public void onErrorResponse (VolleyError error) {
                System.out.println(error.toString());
            }
        };
        StringRequest stringRequest = new StringRequest(Request.Method.GET, solarUrl, responseListener, errorListener);
        requestQueue.add(stringRequest);

        recyclerView.setHasFixedSize(true);
        return view;
    }
}
