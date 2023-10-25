package com.example.udemy_paulo_note_app.model

import android.os.Build
import androidx.annotation.RequiresApi
import java.time.LocalDateTime
import java.util.*

@RequiresApi(Build.VERSION_CODES.O)
data class Note  constructor(
    val id: UUID = UUID.randomUUID(),
    val title: String,
    val description : String,
    val entryDate : LocalDateTime = LocalDateTime.now()

)
