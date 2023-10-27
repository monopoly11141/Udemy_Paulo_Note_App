package com.example.udemy_paulo_note_app.util

import androidx.room.TypeConverter
import java.util.*

class UUIDConverter {

    @TypeConverter
    fun UUIDToString(uuid: UUID): String {
        return uuid.toString()
    }

    @TypeConverter
    fun stringToUUID(string : String) : UUID {
        return UUID.fromString(string)
    }
}