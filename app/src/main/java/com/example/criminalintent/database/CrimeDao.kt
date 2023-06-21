package com.example.criminalintent.database

import androidx.room.Dao
import androidx.room.Query
import com.example.criminalintent.model.Crime
import java.util.*

@Dao
interface CrimeDao {

    @Query("Select * FROM crime")
    suspend fun getCrimes(): List<Crime>

    @Query("Select * FROM crime WHERE id=(:id)")
    suspend fun getCrime(id: UUID): Crime

}