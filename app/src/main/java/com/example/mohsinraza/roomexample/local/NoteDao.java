package com.example.mohsinraza.roomexample.local;


import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.Query;

import com.example.mohsinraza.roomexample.model.Note;

import java.util.List;

@Dao
public interface NoteDao {

    @Insert
    void insertNote(Note note);

    @Query("SELECT * FROM notes")
    List<Note> getAllNotes();
}
