package com.example.a3634_assigment.Fragments;

import android.content.Context;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.example.a3634_assigment.Activities.PlanetActivity;
import com.example.a3634_assigment.Adapters.ExploreImagesAdapter;
import com.example.a3634_assigment.Models.NasaImages.Collection;
import com.example.a3634_assigment.Models.NasaImages.Item;
import com.example.a3634_assigment.Models.NasaImages.Link;
import com.example.a3634_assigment.Models.NasaImages.Link_;
import com.example.a3634_assigment.Models.NasaImages.NasaResponse;
import com.example.a3634_assigment.R;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;

public class ExploreFragment extends Fragment {
    private RecyclerView recyclerView;

    public ExploreFragment(){

    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_explore, container, false);
        recyclerView = view.findViewById(R.id.image_rv);
        //LinearLayoutManager layoutManager = new LinearLayoutManager(view.getContext());
        //recyclerView.setLayoutManager(layoutManager);
        recyclerView.setLayoutManager(new GridLayoutManager(getContext(), 3));

        final ExploreImagesAdapter exploreImagesAdapter = new ExploreImagesAdapter();

        String nasaImagesUrl = "https://images-api.nasa.gov/search?q=" + PlanetActivity.name + "&media_type=image&year_end=2018";
        Context context = getContext();
        RequestQueue requestQueue = Volley.newRequestQueue(context);

        Response.Listener<String> responseListener = new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {

                Gson gson = new Gson();
                NasaResponse nasaResponse = gson.fromJson(response, NasaResponse.class);
                List<Item> itemsList = nasaResponse.getCollection().getItems();
                ArrayList<Item> items = new ArrayList<>(itemsList);
                exploreImagesAdapter.setData(items);
                recyclerView.setAdapter(exploreImagesAdapter);

            }
        };

        Response.ErrorListener errorListener = new Response.ErrorListener() {
            @Override
            public void onErrorResponse (VolleyError error) {
                System.out.println(error.toString());
            }
        };
        StringRequest stringRequest = new StringRequest(Request.Method.GET, nasaImagesUrl, responseListener, errorListener);
        requestQueue.add(stringRequest);

        recyclerView.setHasFixedSize(true);
        return view;
    }
}
