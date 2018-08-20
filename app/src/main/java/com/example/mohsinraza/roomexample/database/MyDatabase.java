package com.example.mohsinraza.roomexample.database;

import android.arch.persistence.room.Database;
import android.arch.persistence.room.RoomDatabase;

import com.example.mohsinraza.roomexample.local.NoteDao;
import com.example.mohsinraza.roomexample.model.Note;


@Database(entities = {Note.class}, version = 1)
public abstract class MyDatabase extends RoomDatabase {
    public abstract NoteDao noteDao();
}
