package com.example.criminalintent

import androidx.lifecycle.ViewModel
import java.util.*

class CrimeListViewModel : ViewModel() {
    val crimes = mutableListOf<Crime>()

    init {
        for (i in 0 until SIZE_LIST){
            val crime = Crime(
                id = UUID.randomUUID(),
                title = "Crime $i",
                date = Date(),
                isSolved = i % 2 == 0,
                requirePolice = i % 2 == 0
            )

            crimes += crime
        }
    }

    companion object {
        private const val SIZE_LIST = 100
    }
}
