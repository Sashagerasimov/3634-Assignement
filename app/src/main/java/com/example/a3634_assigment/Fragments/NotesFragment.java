package com.example.a3634_assigment.Fragments;


import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.SearchView;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;


import com.example.a3634_assigment.Activities.CreateNoteActivity;
import com.example.a3634_assigment.Adapters.NotesAdapter;
import com.example.a3634_assigment.Models.Notes;
import com.example.a3634_assigment.R;
import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.util.ArrayList;
import java.util.List;

public class NotesFragment extends Fragment {

    private RecyclerView recyclerView;
    public NotesAdapter notesAdapter;
    //public ImageButton createNote;
    public FloatingActionButton createNote;
    public static ArrayList<Notes> notesList = new ArrayList<>();


    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        final NotesAdapter notesAdapter = new NotesAdapter();




        //set Recycler View
        View view = inflater.inflate(R.layout.fragment_notebook, container, false);
        recyclerView = view.findViewById(R.id.rv_notes);
        LinearLayoutManager layoutManager = new LinearLayoutManager(view.getContext());
        recyclerView.setLayoutManager(layoutManager);
        notesAdapter.setData(notesList);
        recyclerView.setAdapter(notesAdapter);

        createNote = (FloatingActionButton) view.findViewById(R.id.button);
        createNote.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Context context = view.getContext();

                Intent intent = new Intent(context, CreateNoteActivity.class);
                context.startActivity(intent);


            }
            });


    return view;
    }

    public static Notes getNotesById(int catsID2) {
        return notesList.get(catsID2);
    }

    }






