package com.example.demo_mvvm.model

import android.app.Application
import android.os.AsyncTask
import androidx.lifecycle.LiveData

class NoteRepository(application: Application) {

    private lateinit var noteDao: NoteDao

    private lateinit var allNotes: LiveData<List<Note>>


    init {

        val database: NoteDatabase = NoteDatabase.invoke(
            application.applicationContext
        )

        noteDao = database.noteDao()

        allNotes = noteDao.getAllNotes()
    }


    fun insert(note: Note) {

        InsertNoteTask(noteDao).execute(note)

    }


    fun deleteAllNotes() {
        DeleteAllNotesAsyncTask(noteDao).execute()
    }

    fun getAllNotes() = allNotes

    private class InsertNoteTask(val noteDao: NoteDao) : AsyncTask<Note, Unit, Unit>() {

        override fun doInBackground(vararg params: Note?) {

            noteDao.insert(params[0]!!)

        }

    }


    private class DeleteAllNotesAsyncTask(val noteDao: NoteDao) : AsyncTask<Unit, Unit, Unit>() {

        override fun doInBackground(vararg p0: Unit?) {
            noteDao.deleteAllNotes()
        }
    }
}


