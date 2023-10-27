package com.example.udemy_paulo_note_app.util

import java.text.SimpleDateFormat
import java.util.*

fun formatDateFromLongToString(time : Long) : String{
    val date = Date(time)
    return SimpleDateFormat("EEE, d MMM hh:mm aaa", Locale.getDefault()).format(date)
}