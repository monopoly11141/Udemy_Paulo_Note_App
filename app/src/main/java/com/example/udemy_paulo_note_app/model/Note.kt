package com.example.udemy_paulo_note_app.model

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import java.time.Instant
import java.util.*

@Entity(tableName = "note_table")
data class Note constructor(
    @PrimaryKey
    @ColumnInfo(name = "note_id")
    val id: UUID = UUID.randomUUID(),

    @ColumnInfo(name = "note_title")
    val title: String,

    @ColumnInfo(name = "note_description")
    val description: String,

    @ColumnInfo(name = "note_entry_date")
    val entryDate: Date = Date.from(Instant.now())

)
