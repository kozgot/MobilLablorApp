package com.example.mobillaborapp.test

import com.example.mobillaborapp.model.network.Breed
import com.example.mobillaborapp.testInjector
import com.example.mobillaborapp.ui.addpicture.AddPicturePresenter
import com.example.mobillaborapp.ui.addpicture.AddPictureScreen
import com.example.mobillaborapp.utils.argumentCaptor
import com.example.mobillaborapp.utils.mock
import org.junit.After
import org.junit.Before

import org.junit.Test
import org.junit.runner.RunWith
import org.mockito.Mockito
import org.robolectric.RobolectricTestRunner
import javax.inject.Inject

@RunWith(RobolectricTestRunner::class)
class AddPictureTest {
    @Inject
    lateinit var addPicturePresenter:AddPicturePresenter

    private lateinit var addPictureScreen: AddPictureScreen

    @Before
    @Throws(Exception::class)
    fun setup() {
        testInjector.inject(this)
        addPictureScreen = mock()
        addPicturePresenter.attachScreen(addPictureScreen)
    }

    @Test
    fun testLoadImage() {
        addPicturePresenter.loadImagesFromAPI()

        val list = argumentCaptor<MutableList<Image>>()
        Mockito.verify(addPictureScreen).showImages(list.capture())
        assert(list.value.size > 0)
    }

    @Test
    fun testLoadBreedsFromAPI() {
        addPicturePresenter.getBreedsFromAPI()

        val breedList = argumentCaptor<MutableList<Breed>>()
        Mockito.verify(addPictureScreen).showBreeds(breedList.capture())
        assert(breedList.value.size > 0)
    }

    @After
    fun tearDown() {
        addPicturePresenter.detachScreen()
    }

}