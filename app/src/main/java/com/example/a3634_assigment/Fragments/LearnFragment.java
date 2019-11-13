package com.example.a3634_assigment.Fragments;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.example.a3634_assigment.Activities.PlanetActivity;
import com.example.a3634_assigment.Models.Body;
import com.example.a3634_assigment.Models.BodyResponse;
import com.example.a3634_assigment.R;
import com.google.gson.Gson;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class LearnFragment extends Fragment {
    private Button planetButton;

    public LearnFragment() {

    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_learn, container, false);

        String solarUrl = "https://api.le-systeme-solaire.net/rest/bodies/";

        Context context = getContext();
        RequestQueue requestQueue = Volley.newRequestQueue(context);

        Response.Listener<String> responseListener = new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                Gson gson = new Gson();
                BodyResponse bodyResponse = gson.fromJson(response, BodyResponse.class);
                List<Body> bodies = bodyResponse.getBodies();
                Body test = bodies.get(264);
                System.out.println(test.getName());
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

        planetButton = view.findViewById(R.id.planet);
        planetButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent myIntent = new Intent(getContext(), PlanetActivity.class);
                getActivity().startActivity(myIntent);
            }
        });

        return view;
    }
}
