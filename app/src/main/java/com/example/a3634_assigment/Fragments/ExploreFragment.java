package com.example.a3634_assigment.Fragments;

import android.content.Context;
import android.os.Bundle;
import android.util.Log;
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
import com.example.a3634_assigment.Database.NasaItemsDb;
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
                // Our db insert method call used to be here last week. But that's on the main thread.
                // So we replace it with an AsyncTask that runs the query on a worker thread.
//                db.bookDao().insertAll(bestsellers);
                InsertItemsAsyncTask insertItemsAsyncTask = new InsertItemsAsyncTask();
                insertItemsAsyncTask.setDatabase(db);
                // I'm giving a reference to THIS fragment to be the delegate. I'm telling the
                // AsyncTask, that the fragment that I'm in right now, will be your delegate.
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

    // This method is required to be implemented, because we use the interface. This method is called
    // from the AsyncTask once the task has completed. It gives the result back to this class so
    // that we can use the result to update our UI.
    @Override
    public void handleTaskResult(String result) {
        Toast.makeText(getContext(), "AsyncTask insert done", Toast.LENGTH_SHORT).show();

        // In this case, this method is called after the Insert task is done. After inserting, I
        // want to update my UI to reflect the new list of Books. To do this, I have made another
        // AsyncTask that runs to get the Books from the database.
        // So after my Insert AsyncTask finishes, this method will be called and it will start
        // a second AsyncTask to get the books.
        GetItemsAsyncTask getItemsAsyncTask = new GetItemsAsyncTask();
        getItemsAsyncTask.setDatabase(NasaItemsDb.getInstance(getContext()));
        getItemsAsyncTask.setDelegate(this);
        getItemsAsyncTask.execute();
    }

    // This is a method for the second interface. This Fragment can be a delegate for two different
    // AsyncTasks that return different types of results, because I implement the two interfaces.
    @Override
    public void handleTaskGetResult(List<Item> items) {
        // When the get AsyncTask is done, it'll return to me the list of books. Then I just update
        // the UI.
        ArrayList<Item> syncList = new ArrayList<>(items);
        //exploreImagesAdapter.setData(syncList);
        //recyclerView.setAdapter(exploreImagesAdapter);
    }
}
