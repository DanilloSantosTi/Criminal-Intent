package com.example.criminalintent.model

import androidx.room.Entity
import androidx.room.PrimaryKey
import java.text.SimpleDateFormat
import java.util.*

@Entity
data class Crime(
    @PrimaryKey val id: UUID,
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
