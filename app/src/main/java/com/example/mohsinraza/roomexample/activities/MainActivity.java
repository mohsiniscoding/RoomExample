package com.example.mohsinraza.roomexample.activities;

import android.arch.persistence.room.Room;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.Menu;
import android.view.MenuItem;

import com.example.mohsinraza.roomexample.NotesRecyclerViewAdapter;
import com.example.mohsinraza.roomexample.R;
import com.example.mohsinraza.roomexample.activities.AddNote;
import com.example.mohsinraza.roomexample.database.MyDatabase;
import com.example.mohsinraza.roomexample.model.Note;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);



        RecyclerView notes_list = (RecyclerView) findViewById(R.id.rv_notes);
        notes_list.hasFixedSize();
        notes_list.setLayoutManager(new LinearLayoutManager(this));


        MyDatabase database = Room.databaseBuilder(getApplicationContext(), MyDatabase.class, "notes")
                .fallbackToDestructiveMigration()
                .allowMainThreadQueries()
                .build();

        List<Note> notes = database.noteDao().getAllNotes();

        NotesRecyclerViewAdapter adapter = new NotesRecyclerViewAdapter(notes);
        notes_list.setAdapter(adapter);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu,menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        if(item.getItemId() == R.id.menu_note_add){

            startActivity(new Intent(this, AddNote.class));

        }

        return super.onOptionsItemSelected(item);
    }
}
