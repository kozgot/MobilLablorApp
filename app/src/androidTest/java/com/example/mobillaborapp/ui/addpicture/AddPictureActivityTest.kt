package com.example.mobillaborapp.ui.addpicture

import androidx.test.platform.app.InstrumentationRegistry
import org.junit.After
import org.junit.Before

import org.junit.Assert.*
import org.junit.Test

class AddPictureActivityTest {

    @Before
    fun setUp() {
    }

    @Test
    fun useAppContext1() {
        // Context of the app under test.
        val appContext = InstrumentationRegistry.getInstrumentation().targetContext
        assertEquals("com.example.mobillaborapp", appContext.packageName)
    }

    @After
    fun tearDown() {
    }
}