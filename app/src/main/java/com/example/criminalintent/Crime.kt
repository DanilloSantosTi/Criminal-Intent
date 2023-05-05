package com.example.criminalintent

import java.text.SimpleDateFormat
import java.util.*

data class Crime(
    val id: UUID,
    val title: String,
    val date: Date,
    val isSolved: Boolean,
    val requirePolice: Boolean = false
) {
    fun formattedDate(date: Date): String {
        val formatter = SimpleDateFormat("EEEE, MMMM, d, yyyy", Locale("pt", "BR"))
        return formatter.format(date)
    }
}
