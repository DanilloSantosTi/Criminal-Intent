package com.example.criminalintent.presentation.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.criminalintent.model.Crime
import kotlinx.coroutines.launch
import java.util.*

class CrimeListViewModel : ViewModel() {
    val crimes = mutableListOf<Crime>()

    init {
        viewModelScope.launch {
            crimes += loadCrimes()
        }
    }

    suspend fun loadCrimes(): List<Crime> {
        val result = mutableListOf<Crime>()
        for (i in 0 until SIZE_LIST) {
            val crime = Crime(
                id = UUID.randomUUID(),
                title = "Crime $i",
                date = Date(),
                isSolved = i % 2 == 0,
                requirePolice = i % 2 == 0
            )

            result += crime
        }
        return result
    }

    companion object {
        private const val SIZE_LIST = 100
    }
}
