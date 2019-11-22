package com.example.a3634_assigment.Fragments;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.example.a3634_assigment.Activities.PlanetActivity;
//import com.example.a3634_assigment.Models.Bodies.BodyResponse;
import com.example.a3634_assigment.R;
import com.google.gson.Gson;

import org.w3c.dom.Text;

public class ReadFragment extends Fragment {
    private TextView title;
    private TextView description;
    private TextView wiki;

    public ReadFragment() {

    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_read, container, false);

        description = view.findViewById(R.id.description);
        title = view.findViewById(R.id.wiki_title);
        wiki = view.findViewById(R.id.wiki_link);
        title.setText(PlanetActivity.name);

        final String wikiUrl = "https://en.wikipedia.org/w/api.php?format=json&action=query&prop=extracts&exintro&explaintext&redirects=1&titles="+PlanetActivity.name+"%20(planet)";

        Context context = getContext();
        final RequestQueue requestQueue = Volley.newRequestQueue(context);

        Response.Listener<String> responseListener = new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                String string = (response.substring(response.lastIndexOf("extract")+10,response.length()-5));
                string = string.replace("\\n", "\n\n");
                string = string.replaceAll("\\(.*?\\)", "");
                description.setText(string);

                requestQueue.stop();
            }
        };

        Response.ErrorListener errorListener = new Response.ErrorListener() {
            @Override
            public void onErrorResponse (VolleyError error) {
                System.out.println(error.toString());
            }
        };
        StringRequest stringRequest = new StringRequest(Request.Method.GET, wikiUrl, responseListener, errorListener);
        requestQueue.add(stringRequest);

        wiki.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent browserIntent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://en.wikipedia.org/wiki/"+PlanetActivity.name+"%20(planet)"));
                startActivity(browserIntent);
            }
        });

        return view;
    }
}
