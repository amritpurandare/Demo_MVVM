package com.example.demo_mvvm.model

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query

@Dao
interface NoteDao {

    @Insert
    fun insert(note: Note)

    @Query("DELETE from notes_table")
    fun deleteAllNotes()

    @Query("SELECT * from notes_table")
    fun getAllNotes(): LiveData<List<Note>>
}



