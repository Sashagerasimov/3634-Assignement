package com.example.a3634_assigment.Activities;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.Toast;

import com.example.a3634_assigment.Fragments.NotesFragment;
import com.example.a3634_assigment.Models.Notes;
import com.example.a3634_assigment.R;
import com.google.android.material.floatingactionbutton.FloatingActionButton;

public class CreateNoteActivity extends AppCompatActivity {

    public EditText noteTitle;
    public EditText noteContent;
    public FloatingActionButton add;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_create_note);

        noteTitle = findViewById(R.id.title);
        noteContent = findViewById(R.id.content);

        add = findViewById(R.id.addNote);

        add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                String nTitle = noteTitle.getText().toString(); //gets you the contents of edit text
                String nContent = noteContent.getText().toString();
                int nId = 0;
                if (NotesFragment.notesList.isEmpty()){
                    nId = 0;
                }
                else {
                    nId = NotesFragment.notesList.get(NotesFragment.notesList.size() - 1).getId() + 1;
                }
                Notes object = new Notes(nId, nTitle, nContent);
                NotesFragment.notesList.add(object);
                Toast.makeText(CreateNoteActivity.this, "Note created!", Toast.LENGTH_SHORT).show();
                NotesFragment.notesAdapter.notifyDataSetChanged();

                finish();

            }

        });



    }
}
