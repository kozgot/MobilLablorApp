package com.example.mobillaborapp.test

import com.example.mobillaborapp.model.database.DbBreed
import com.example.mobillaborapp.model.network.Breed
import com.example.mobillaborapp.testInjector
import com.example.mobillaborapp.ui.addpicture.AddPicturePresenter
import com.example.mobillaborapp.ui.addpicture.AddPictureScreen
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
class AddPictureTest {
    @Inject
    lateinit var addPicturePresenter:AddPicturePresenter

    private lateinit var addPictureScreen: AddPictureScreen

    private val mainThreadSurrogate = newSingleThreadContext("UI thread")

    @Before
    @Throws(Exception::class)
    fun setup() {
        testInjector.inject(this)
        addPictureScreen = mock()
        addPicturePresenter.attachScreen(addPictureScreen)
        Dispatchers.setMain(mainThreadSurrogate)
    }

    @Test
    fun testQueryBreedsFromDB() {
        runBlocking {
            launch(Dispatchers.Main) {  // Will be launched in the mainThreadSurrogate dispatcher
                val list: List<DbBreed> =
                        withContext(Dispatchers.IO) {
                            addPicturePresenter.queryBreedsFromDb()
                        }

                assert(list.isNotEmpty())
            }
        }
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
        Dispatchers.resetMain() // reset main dispatcher to the original Main dispatcher
        mainThreadSurrogate.close()
    }

}