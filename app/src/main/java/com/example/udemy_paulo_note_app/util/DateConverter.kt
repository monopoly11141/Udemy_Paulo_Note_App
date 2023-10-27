package com.example.udemy_paulo_note_app.util

import androidx.room.TypeConverter
import java.util.*

class DateConverter {

    @TypeConverter
    fun dateToTimeStamp(date: Date): Long {
        return date.time
    }

    @TypeConverter
    fun timeStampToDate(timeStamp: Long): Date? {
        return Date(timeStamp)
    }
}