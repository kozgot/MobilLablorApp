package com.example.mobillaborapp.test

import android.content.Intent
import androidx.test.espresso.Espresso
import androidx.test.espresso.assertion.ViewAssertions
import androidx.test.espresso.matcher.ViewMatchers
import androidx.test.ext.junit.runners.AndroidJUnit4
import com.example.mobillaborapp.R
import com.example.mobillaborapp.ui.picturedetails.PictureDetailsActivity
import com.example.mobillaborapp.utils.AndroidTestUtils
import com.example.mobillaborapp.utils.EspressoTest
import org.junit.After
import org.junit.Before

import org.junit.Test
import org.junit.runner.RunWith

@RunWith(AndroidJUnit4::class)
class PictureDetailsActivityTest : EspressoTest<PictureDetailsActivity>(PictureDetailsActivity::class.java) {

    @Before
    fun setUp() {
        AndroidTestUtils.setTestInjector()
        activityRule.launchActivity(Intent().putExtra("IMAGE_ID", PictureDetailsActivityTest.IMAGEID))
    }

    @Test
    fun testOpenDetails() {
        Espresso.onView(ViewMatchers.withId(R.id.tvBreed))
                .check(ViewAssertions.matches(ViewMatchers.withText(PictureDetailsActivityTest.BreedName)))
        Espresso.onView(ViewMatchers.withId(R.id.tvDescription))
                .check(ViewAssertions.matches(ViewMatchers.withText(PictureDetailsActivityTest.BreedDesc)))
    }

    companion object {
        private const val IMAGEID = "2u0QIn3hP"
        private const val BreedName = "Bambino"
        private const val BreedDesc = "The Bambino is a breed of cat that was created as a cross between the Sphynx and the Munchkin breeds. The Bambino cat has short legs, large upright ears, and is usually hairless. They love to be handled and cuddled up on the laps of their family members."
    }

    @After
    fun tearDown() {
    }
}