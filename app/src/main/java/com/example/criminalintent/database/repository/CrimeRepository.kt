package com.example.criminalintent.database.repository

import android.content.Context

class CrimeRepository private constructor(context: Context) {

    companion object {
        private var INSTANCE: CrimeRepository? = null

        fun initialize(context: Context) {
            if (INSTANCE == null) {
                INSTANCE = CrimeRepository(context)
            }
        }

        fun get(): CrimeRepository {
            return INSTANCE
                ?: throw java.lang.IllegalStateException("CrimeRepository must be initialized")
        }
    }
}