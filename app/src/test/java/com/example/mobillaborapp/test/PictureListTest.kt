package com.example.mobillaborapp.test

import com.example.mobillaborapp.model.network.Image
import com.example.mobillaborapp.testInjector
import com.example.mobillaborapp.ui.picturelist.PicListPresenter
import com.example.mobillaborapp.ui.picturelist.PicListScreen
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
class PictureListTest {
    @Inject
    lateinit var listPresenter: PicListPresenter

    private lateinit var picListScreen: PicListScreen

    @Before
    @Throws(Exception::class)
    fun setup() {
        testInjector.inject(this)
        picListScreen = mock()
        listPresenter.attachScreen(picListScreen)
    }

    @Test
    fun testArtists() {
        listPresenter.loadImagesFromAPI()

        val list = argumentCaptor<MutableList<Image>>()
        Mockito.verify(picListScreen).showImages(list.capture())
        assert(list.value.size > 0)
    }

    @After
    fun tearDown() {
        listPresenter.detachScreen()
    }

}