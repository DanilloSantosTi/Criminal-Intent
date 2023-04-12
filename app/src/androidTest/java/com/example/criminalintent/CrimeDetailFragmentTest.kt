package com.example.criminalintent

import androidx.fragment.app.testing.FragmentScenario
import androidx.fragment.app.testing.FragmentScenario.Companion.launch
import androidx.test.espresso.Espresso.*
import androidx.test.espresso.action.ViewActions.typeText
import androidx.test.espresso.assertion.ViewAssertions.matches
import androidx.test.espresso.matcher.ViewMatchers.*
import org.hamcrest.CoreMatchers.equalTo
import org.junit.Assert.*

import org.junit.After
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith
import org.junit.runners.JUnit4
import java.util.*

@RunWith(JUnit4::class)
class CrimeDetailFragmentTest {

    private lateinit var scenario: FragmentScenario<CrimeDetailFragment>

    @Before
    fun setUp() {
        scenario = launch(CrimeDetailFragment::class.java)
    }

    @After
    fun tearDown() {
        scenario.close()
    }

    @Test
    fun checkValueCrimeTitle(){
        val titleCrime = "Roubaram meu pão"

        onView(withId(R.id.crime_title)).perform(typeText(titleCrime))

        closeSoftKeyboard()

        scenario.onFragment{fragment ->
            assertEquals(titleCrime, fragment.crime.title)
        }
    }

    @Test
    fun checkValueCrimeSolved() {
        scenario.onFragment{fragment ->
            assertFalse(fragment.binding.crimeSolved.isChecked)

            fragment.binding.crimeSolved.isChecked = true
        }

        onView(withId(R.id.crime_solved)).check(matches(isChecked()))
    }
}
