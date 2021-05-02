package com.example.mobillaborapp.test

import com.example.mobillaborapp.model.network.Image
import com.example.mobillaborapp.testInjector
import com.example.mobillaborapp.ui.picturedetails.PictureDetailsPresenter
import com.example.mobillaborapp.ui.picturedetails.PictureDetailsScreen
import com.example.mobillaborapp.utils.argumentCaptor
import com.example.mobillaborapp.utils.mock
import kotlinx.coroutines.*
import kotlinx.coroutines.test.resetMain
import kotlinx.coroutines.test.setMain
import org.junit.After
import org.junit.Before
import org.junit.Test

import org.junit.runner.RunWith
import org.mockito.Mockito
import org.robolectric.RobolectricTestRunner
import javax.inject.Inject

@RunWith(RobolectricTestRunner::class)
class PictureDetailsTest {
    @Inject
    lateinit var pictureDetailsPresenter: PictureDetailsPresenter

    private lateinit var pictureDetailsScreen: PictureDetailsScreen

    private val mainThreadSurrogate = newSingleThreadContext("UI thread")

    @Before
    @Throws(Exception::class)
    fun setup() {
        testInjector.inject(this)
        pictureDetailsScreen = mock()
        pictureDetailsPresenter.attachScreen(pictureDetailsScreen)
        Dispatchers.setMain(mainThreadSurrogate)
    }

    @Test
    fun testQueryImageFromDB() {
        runBlocking {
            launch(Dispatchers.Main) {  // Will be launched in the mainThreadSurrogate dispatcher
                val list: List<Image> =
                        withContext(Dispatchers.IO) {
                            pictureDetailsPresenter.getImageFromDb(IMAGEID)
                        }

                assert(list.count() == 1)
                assert(list[0].id == IMAGEID)
                assert(list[0].breeds.count() == 1)
                assert(list[0].breeds[0].name == BreedName)
            }
        }
    }


    @Test
    fun testLoadImageFromAPI() {
        pictureDetailsPresenter.loadImageFromAPI(IMAGEID)

        val image = argumentCaptor<Image>()
        Mockito.verify(pictureDetailsScreen).showImage(image.capture())
        assert(image.value.width!! > 0)
        assert(image.value.height!! > 0)
    }

    @After
    fun tearDown() {
        pictureDetailsPresenter.detachScreen()
        Dispatchers.resetMain() // reset main dispatcher to the original Main dispatcher
        mainThreadSurrogate.close()
    }

    companion object {
        private const val IMAGEID = "2u0QIn3hP"
        private const val BreedName = "Bambino"
    }
}