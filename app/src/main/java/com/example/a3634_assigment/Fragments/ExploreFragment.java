package com.example.a3634_assigment.Fragments;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

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
import com.example.a3634_assigment.AsyncTasks.AsyncTaskGetDelegate;
import com.example.a3634_assigment.AsyncTasks.AsyncTaskInsertDelegate;
import com.example.a3634_assigment.AsyncTasks.GetItemsAsyncTask;
import com.example.a3634_assigment.AsyncTasks.InsertItemsAsyncTask;
import com.example.a3634_assigment.Databases.NasaItemsDb;
import com.example.a3634_assigment.Models.NasaImages.Item;
import com.example.a3634_assigment.Models.NasaImages.NasaResponse;
import com.example.a3634_assigment.R;
import com.google.gson.Gson;

import java.util.ArrayList;
import java.util.List;

public class ExploreFragment extends Fragment implements AsyncTaskInsertDelegate, AsyncTaskGetDelegate {
    private RecyclerView recyclerView;
    //private ExploreImagesAdapter exploreImagesAdapter;

    public ExploreFragment() {

    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_explore, container, false);
        recyclerView = view.findViewById(R.id.image_rv);
        LinearLayoutManager layoutManager = new LinearLayoutManager(view.getContext());
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setLayoutManager(new GridLayoutManager(getContext(), 3));

        final ExploreImagesAdapter exploreImagesAdapter = new ExploreImagesAdapter();

        String nasaImagesUrl = "https://images-api.nasa.gov/search?q=" + PlanetActivity.name + "&media_type=image&year_end=2018";

        final RequestQueue requestQueue = Volley.newRequestQueue(getActivity());

        Response.Listener<String> responseListener = new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {

                Gson gson = new Gson();
                NasaResponse nasaResponse = gson.fromJson(response, NasaResponse.class);
                List<Item> itemsList = nasaResponse.getCollection().getItems();
                ArrayList<Item> items = new ArrayList<>(itemsList);
                exploreImagesAdapter.setData(items);
                recyclerView.setAdapter(exploreImagesAdapter);

                NasaItemsDb db = NasaItemsDb.getInstance(getContext());
                InsertItemsAsyncTask insertItemsAsyncTask = new InsertItemsAsyncTask();
                insertItemsAsyncTask.setDatabase(db);

                // Reference to this fragment to be the delegate. Telling the
                // AsyncTask, that the current fragment will be the delegate.
                insertItemsAsyncTask.setDelegate(ExploreFragment.this);

                Item[] items2 = itemsList.toArray(new Item[itemsList.size()]);
                insertItemsAsyncTask.execute(items2);

                requestQueue.stop();
            }
        };

        Response.ErrorListener errorListener = new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                System.out.println(error.toString());
            }
        };
        StringRequest stringRequest = new StringRequest(Request.Method.GET, nasaImagesUrl, responseListener, errorListener);
        requestQueue.add(stringRequest);

        recyclerView.setHasFixedSize(true);
        return view;
    }

    @Override
    public void handleTaskResult(String result) {
        // In this case, this method is called after the Insert task is done. After inserting we
        // want to update the UI to reflect the new list of items.
        GetItemsAsyncTask getItemsAsyncTask = new GetItemsAsyncTask();
        getItemsAsyncTask.setDatabase(NasaItemsDb.getInstance(getContext()));
        getItemsAsyncTask.setDelegate(this);
        getItemsAsyncTask.execute();
    }

    @Override
    public void handleTaskGetResult(List<Item> items) {
        ArrayList<Item> syncList = new ArrayList<>(items);
        //Async did not return a list of items for some reason so reverting back to functioning arraylist
        //exploreImagesAdapter.setData(syncList);
        //recyclerView.setAdapter(exploreImagesAdapter);
    }
}
