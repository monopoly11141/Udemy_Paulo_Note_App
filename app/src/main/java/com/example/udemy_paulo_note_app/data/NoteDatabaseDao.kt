package com.example.udemy_paulo_note_app.data

import androidx.room.*
import com.example.udemy_paulo_note_app.model.Note
import kotlinx.coroutines.flow.Flow

@Dao
interface NoteDatabaseDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertNote(note: Note)

    @Delete
    suspend fun deleteNote(note: Note)

    @Query("DELETE from note_table")
    suspend fun deleteAllNotes()

    @Update(onConflict = OnConflictStrategy.REPLACE)
    suspend fun updateNote(note: Note)

    @Query("SELECT * from note_table where note_id = :id")
    suspend fun getNoteById(id: String): Note

    @Query("SELECT * from note_table")
    fun getAllNotes(): Flow<List<Note>>
}
