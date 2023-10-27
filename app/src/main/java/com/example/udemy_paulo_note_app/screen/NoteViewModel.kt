package com.example.udemy_paulo_note_app.screen

import androidx.compose.runtime.mutableStateListOf
import androidx.lifecycle.ViewModel
import com.example.udemy_paulo_note_app.data.NotesDataSource
import com.example.udemy_paulo_note_app.model.Note

class NoteViewModel : ViewModel() {
    private var noteList = mutableStateListOf<Note>()

    init {
        noteList.addAll(NotesDataSource().loadNotes())
    }

    fun addNote(note: Note) {
        noteList.add(note)
    }

    fun removeNote(note: Note) {
        noteList.remove(note)
    }

    fun getAllNotes() = noteList

}