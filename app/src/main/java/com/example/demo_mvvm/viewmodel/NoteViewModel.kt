package com.example.demo_mvvm.viewmodel

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import com.example.demo_mvvm.model.Note
import com.example.demo_mvvm.model.NoteRepository

class NoteViewModel(application: Application) : AndroidViewModel(application) {


    private var repository: NoteRepository = NoteRepository(application)

    fun insert(note: Note) {
        repository.insert(note)
    }


    fun deleteAllNotes() {
        repository.deleteAllNotes()
    }

    fun getAllNotes(): LiveData<List<Note>> {
        return repository.getAllNotes()
    }
}