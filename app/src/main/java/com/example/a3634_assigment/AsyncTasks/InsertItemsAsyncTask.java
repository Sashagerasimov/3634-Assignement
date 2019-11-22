package com.example.a3634_assigment.AsyncTasks;

import android.os.AsyncTask;

import com.example.a3634_assigment.Databases.NasaItemsDb;
import com.example.a3634_assigment.Models.NasaImages.Item;

import java.util.Arrays;

public class InsertItemsAsyncTask extends AsyncTask<Item, Integer, String> {

    private AsyncTaskInsertDelegate delegate;

    private NasaItemsDb database;

    public void setDelegate(AsyncTaskInsertDelegate delegate) {
        this.delegate = delegate;
    }

    public void setDatabase(NasaItemsDb database) {
        this.database = database;
    }

    @Override
    protected void onPreExecute() {
        super.onPreExecute();
    }

    @Override
    protected String doInBackground(Item...items) {

        database.nasaItemsDao().insertAll(Arrays.asList(items));

        return "This value will be passed to onPostExecute as the result parameter.";
    }

    @Override
    protected void onPostExecute(String result) {

        delegate.handleTaskResult(result);
    }
}