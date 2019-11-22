package com.example.a3634_assigment.AsyncTasks;

import com.example.a3634_assigment.Models.NasaImages.Item;

import java.util.List;

public interface AsyncTaskGetDelegate {
    void handleTaskGetResult(List<Item> items);
}