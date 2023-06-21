package com.example.criminalintent.database

import androidx.room.TypeConverters
import java.util.*

class CrimeTypeConvertersc {
    @TypeConverters
    fun fromDate(date: Date): Long{
        return date.time
    }

    @TypeConverters
    fun toDate(millisSinceEpoch: Long): Date {
        return Date(millisSinceEpoch)
    }
}