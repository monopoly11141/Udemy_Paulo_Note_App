package com.example.udemy_paulo_note_app.di

import android.content.Context
import androidx.room.Room
import com.example.udemy_paulo_note_app.data.NoteDatabase
import com.example.udemy_paulo_note_app.data.NoteDatabaseDao
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@InstallIn(SingletonComponent::class)
@Module
object AppModule {

    @Singleton
    @Provides
    fun providesNoteDatabaseDao(noteDatabase: NoteDatabase): NoteDatabaseDao {
        return noteDatabase.noteDao()
    }

    @Singleton
    @Provides
    fun providesAppDatabase(@ApplicationContext context: Context): NoteDatabase {
        return Room.databaseBuilder(
            context,
            NoteDatabase::class.java,
            "notes_db"
        ).fallbackToDestructiveMigration()
            .build()
    }

}