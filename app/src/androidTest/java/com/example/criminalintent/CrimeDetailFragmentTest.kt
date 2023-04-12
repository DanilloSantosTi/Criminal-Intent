package com.example.criminalintent

import androidx.fragment.app.testing.FragmentScenario
import androidx.fragment.app.testing.launchFragmentInContainer
import androidx.test.espresso.Espresso.closeSoftKeyboard
import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.action.ViewActions.click
import androidx.test.espresso.action.ViewActions.replaceText
import androidx.test.espresso.assertion.ViewAssertions.matches
import androidx.test.espresso.matcher.ViewMatchers.isChecked
import androidx.test.espresso.matcher.ViewMatchers.withId
import org.junit.After
import org.junit.Assert.assertEquals
import org.junit.Assert.assertFalse
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
        scenario = launchFragmentInContainer()
    }

    @After
    fun tearDown() {
        scenario.close()
    }

    @Test
    fun checkValueCrimeTitle(){
        val titleCrime = "Roubaram meu pão"

        onView(withId(R.id.crime_title)).perform(replaceText(titleCrime))

        closeSoftKeyboard()

        scenario.onFragment{fragment ->
            assertEquals(titleCrime, fragment.crime.title)
        }
    }

    @Test
    fun checkValueCrimeSolved() {
        scenario.onFragment{fragment ->
            assertFalse(fragment.binding.crimeSolved.isChecked)
        }

        onView(withId(R.id.crime_solved)).perform(click())

        onView(withId(R.id.crime_solved)).check(matches(isChecked()))
    }
}
