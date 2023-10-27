package com.example.udemy_paulo_note_app.repository

import com.example.udemy_paulo_note_app.data.NoteDatabaseDao
import com.example.udemy_paulo_note_app.model.Note
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.conflate
import kotlinx.coroutines.flow.flowOn
import javax.inject.Inject

class NoteRepository @Inject constructor(private val noteDatabaseDao: NoteDatabaseDao) {

    suspend fun addNote(note: Note) = noteDatabaseDao.insertNote(note)
    suspend fun updateNote(note: Note) = noteDatabaseDao.updateNote(note)
    suspend fun deleteNote(note: Note) = noteDatabaseDao.deleteNote(note)
    suspend fun deleteAllNote() = noteDatabaseDao.deleteAllNotes()
    fun getAllNotes(): Flow<List<Note>> = noteDatabaseDao.getAllNotes()
        .flowOn(Dispatchers.IO)
        .conflate()



}