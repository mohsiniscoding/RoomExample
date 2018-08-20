
package com.example.mohsinraza.roomexample.activities;

import android.arch.persistence.room.Room;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.mohsinraza.roomexample.R;
import com.example.mohsinraza.roomexample.database.MyDatabase;
import com.example.mohsinraza.roomexample.model.Note;

public class AddNote extends AppCompatActivity {


    private static final String TAG = "AddNote";

    EditText title, content;
    Button add_button;
    MyDatabase database;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_note);


        title = (EditText) findViewById(R.id.note_title);
        content = (EditText) findViewById(R.id.note_content);

        add_button = (Button) findViewById(R.id.btn_add_note);
        add_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String title_text = title.getText().toString();
                String content_text = content.getText().toString();

                Note note = new Note(title_text, content_text);


                Log.i(TAG, "onClick: "+title.getText().toString());
                database = Room.databaseBuilder(getApplicationContext(), MyDatabase.class, "notes")
                        .fallbackToDestructiveMigration()
                        .allowMainThreadQueries()
                        .build();
                database.noteDao().insertNote(note);

                Intent intent = new Intent(AddNote.this, MainActivity.class);
                startActivity(intent);


            }
        });





    }
}
