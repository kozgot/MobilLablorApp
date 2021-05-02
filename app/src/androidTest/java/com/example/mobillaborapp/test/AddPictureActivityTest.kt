package com.example.mobillaborapp.test

import android.content.Intent
import androidx.test.espresso.Espresso
import androidx.test.espresso.assertion.ViewAssertions
import androidx.test.espresso.matcher.ViewMatchers
import androidx.test.ext.junit.runners.AndroidJUnit4
import com.example.mobillaborapp.R
import com.example.mobillaborapp.ui.addpicture.AddPictureActivity
import com.example.mobillaborapp.utils.AndroidTestUtils
import com.example.mobillaborapp.utils.EspressoTest
import org.junit.After
import org.junit.Before

import org.junit.Test
import org.junit.runner.RunWith

@RunWith(AndroidJUnit4::class)
class AddPictureActivityTest : EspressoTest<AddPictureActivity>(AddPictureActivity::class.java){

    @Before
    fun setUp() {
        AndroidTestUtils.setTestInjector()
        activityRule.launchActivity(Intent())
    }

    @Test
    fun testBreedSpinner() {
        Espresso.onView(ViewMatchers.withId(R.id.mySpinner))
                .check(ViewAssertions.matches(ViewMatchers.withSpinnerText(AddPictureActivityTest.BreedName)))
    }

    companion object {
        private const val BreedName = "Bambino"
    }

    @After
    fun tearDown() {
    }
}