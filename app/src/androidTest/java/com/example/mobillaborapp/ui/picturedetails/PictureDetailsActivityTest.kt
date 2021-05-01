package com.example.mobillaborapp.ui.picturedetails

import android.content.Intent
import androidx.test.espresso.Espresso
import androidx.test.espresso.assertion.ViewAssertions
import androidx.test.espresso.matcher.ViewMatchers
import androidx.test.ext.junit.runners.AndroidJUnit4
import com.example.mobillaborapp.R
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
    fun testSearch() {
        Espresso.onView(ViewMatchers.withId(R.id.tvBreed))
            .check(ViewAssertions.matches(ViewMatchers.withText(PictureDetailsActivityTest.BreedName)))
        /*
        waitFor(2000) {
            onView(allOf(withId(com.example.mobillaborapp.R.id.tvName), withText(ARTIST))).check(matches(isDisplayed()))
        }
         */
    }

    companion object {
        private const val IMAGEID = "AC/DC"
        private const val BreedName = "Abyssian"
    }

    @After
    fun tearDown() {
    }
}