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

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.ItemTouchHelper;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;


import com.example.a3634_assigment.Activities.CreateNoteActivity;
import com.example.a3634_assigment.Adapters.NotesAdapter;
import com.example.a3634_assigment.Database.SessionInfo;
import com.example.a3634_assigment.Models.Notes;
import com.example.a3634_assigment.R;
import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.util.ArrayList;
import java.util.List;

public class NotesFragment extends Fragment {

    //declare widgets and items needed
    private RecyclerView recyclerView;
    public static NotesAdapter notesAdapter;
    public FloatingActionButton createNote;
    public static List<Notes> notesList;


    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        notesAdapter = new NotesAdapter();


        //get all notes from db
        //notesList = SessionInfo.mNotesDatabase.notesDao().getAll();


        //set Recycler View
        View view = inflater.inflate(R.layout.fragment_notebook, container, false);
        recyclerView = view.findViewById(R.id.rv_notes);
        LinearLayoutManager layoutManager = new LinearLayoutManager(view.getContext());
        recyclerView.setLayoutManager(layoutManager);
        new ItemTouchHelper(itemTouchCallback).attachToRecyclerView(recyclerView);


        //sets data
        notesAdapter.setData((ArrayList<Notes>) notesList);
        recyclerView.setAdapter(notesAdapter);

        //mUsers = SessionData.mUserDatabase.mUserDao().getAll();

        //takes you to class to create new note
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


    ItemTouchHelper.SimpleCallback itemTouchCallback = new ItemTouchHelper.SimpleCallback(0, ItemTouchHelper.RIGHT | ItemTouchHelper.LEFT) {
        @Override
        public boolean onMove(@NonNull RecyclerView recyclerView, @NonNull RecyclerView.ViewHolder viewHolder, @NonNull RecyclerView.ViewHolder target) {
            return false;
        }

        @Override
        public void onSwiped(@NonNull RecyclerView.ViewHolder viewHolder, int direction) {
            notesList.remove(viewHolder.getAdapterPosition());
            notesAdapter.notifyDataSetChanged();
            //SessionInfo.mNotesDatabase.notesDao().deleteNotes();
        }
    };


    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        notesList = SessionInfo.mNotesDatabase.notesDao().getAll();
    }
}







