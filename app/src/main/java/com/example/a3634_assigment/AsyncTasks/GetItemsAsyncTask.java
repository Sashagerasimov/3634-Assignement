package com.example.a3634_assigment.AsyncTasks;

import android.os.AsyncTask;

import com.example.a3634_assigment.Databases.NasaItemsDb;
import com.example.a3634_assigment.Models.NasaImages.Item;

import java.util.List;

public class GetItemsAsyncTask extends AsyncTask<Void, Integer, List<Item>> {

    private AsyncTaskGetDelegate delegate;

    private NasaItemsDb database;

    public void setDelegate(AsyncTaskGetDelegate delegate) {
        this.delegate = delegate;
    }

    public void setDatabase(NasaItemsDb database) {
        this.database = database;
    }

    @Override
    protected List<Item> doInBackground(Void... voids) {
        return database.nasaItemsDao().getAll();
    }

    @Override
    protected void onPostExecute(List<Item> result) {

        delegate.handleTaskGetResult(result);
    }
}