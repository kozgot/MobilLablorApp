package com.example.mobillaborapp.test

import com.example.mobillaborapp.model.database.DbBreed
import com.example.mobillaborapp.model.network.Breed
import com.example.mobillaborapp.model.utils.convertToDbBreed
import com.example.mobillaborapp.ui.picturelist.PicListScreen
import org.junit.After
import org.junit.Before
import org.junit.Test

import org.junit.Assert.*

class ModelUtilsKtTest {

    private lateinit var dbBreed: DbBreed
    private lateinit var breed: Breed

    @Before
    fun setUp() {
        dbBreed = DbBreed(null, "bamb", "Bambino", 0,
            "The Bambino is a breed of cat that was created as a cross between the Sphynx and the Munchkin breeds. The Bambino cat has short legs, large upright ears, and is usually hairless. They love to be handled and cuddled up on the laps of their family members.",
            "Affectionate, Lively, Friendly, Intelligent","12 - 14","",
            "https://en.wikipedia.org/wiki/Bambino_cat","","United States", 1,
            1, 0, 0, 0, 0, 1, 0, 5, 5,
            "US", 4, 5, 5, 1, 1, 5, 1,
            3, 3, 3)
        breed = Breed( "bamb", "Bambino", 0,
            "The Bambino is a breed of cat that was created as a cross between the Sphynx and the Munchkin breeds. The Bambino cat has short legs, large upright ears, and is usually hairless. They love to be handled and cuddled up on the laps of their family members.",
            "Affectionate, Lively, Friendly, Intelligent","12 - 14","",
            "https://en.wikipedia.org/wiki/Bambino_cat","","United States", 1,
            1, 0, 0, 0, 0, 1, 0, 5, 5,
            "US", 4, 5, 5, 1, 1, 5, 1,
            3, 3, 3)
    }

    @After
    fun tearDown() {
    }

    @Test
    fun testConvertToDbBreed() {
        val convertedDbBreed = breed.convertToDbBreed()
        assert(dbBreed == convertedDbBreed)
    }

    @Test
    fun testConvertFromBreed() {
        val convertedBreed = com.example.mobillaborapp.model.utils.convertFromDbBreed(dbBreed)
        assert(breed == convertedBreed)
    }


    @Test
    fun convertToDbImage() {
    }

    @Test
    fun convertFromDbImage() {
    }
}