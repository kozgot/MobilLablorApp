package com.example.mobillaborapp.ui.picturelist

import com.example.mobillaborapp.events.GetBreedsEvent
import com.example.mobillaborapp.events.GetCatImagesEvent
import com.example.mobillaborapp.model.database.DbImage
import com.example.mobillaborapp.model.network.Image
import com.example.mobillaborapp.repository.network.NetworkInteractor
import com.example.mobillaborapp.ui.Presenter
import org.greenrobot.eventbus.EventBus
import org.greenrobot.eventbus.Subscribe
import org.greenrobot.eventbus.ThreadMode
import java.util.concurrent.Executor
import javax.inject.Inject
import com.example.mobillaborapp.model.network.Breed
import com.example.mobillaborapp.model.utils.convertFromDbImage
import com.example.mobillaborapp.model.utils.convertToDbBreed
import com.example.mobillaborapp.model.utils.convertToDbImage
import com.example.mobillaborapp.repository.database.DBInteractor
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.Job
import kotlinx.coroutines.launch
import kotlin.coroutines.CoroutineContext

class PicListPresenter @Inject constructor(
    private val executor: Executor,
    private val networkInteractor: NetworkInteractor,
    private val dbInteractor: DBInteractor,
    private val uiContext: CoroutineContext = Dispatchers.Main) : Presenter<PicListScreen>() , CoroutineScope {

    private var job: Job = Job()
    override val coroutineContext: CoroutineContext
        get() = uiContext + job

    override fun attachScreen(screen: PicListScreen) {
        super.attachScreen(screen)
        EventBus.getDefault().register(this)
    }

    override fun detachScreen() {
        EventBus.getDefault().unregister(this)
        super.detachScreen()
    }

    fun loadImagesFromAPI() {
        executor.execute {
            networkInteractor.getOwnImages()
        }
    }

    fun loadBreedsFromAPI() {
        executor.execute {
            networkInteractor.getBreeds()
        }
    }

    suspend fun saveBreeds(breeds: List<Breed>) {
        breeds.forEach {
            dbInteractor.insertBreed(it.convertToDbBreed())
        }
    }

    suspend fun queryImagesFromDb(): List<Image>{
        var list = dbInteractor.getImages()
        var imageList = mutableListOf<Image>()
        list.forEach{
            imageList.add(convertFromDbImage(it))
        }
        return imageList
    }

    suspend fun saveImages(images: List<Image>) {
        images.forEach {
            dbInteractor.insertImage(it.convertToDbImage())
        }
    }

    @Subscribe(threadMode = ThreadMode.MAIN)
    fun onEventMainThread(event: GetCatImagesEvent) {
        if (event.throwable != null) {
            event.throwable?.printStackTrace()
            if (screen != null) {
                screen?.showError(event.throwable?.message.orEmpty())
            }
        } else {
            if (screen != null) {
                if (event.images != null) {
                    screen?.showImages(event.images as MutableList<Image>)
                    launch { // launching a coroutine
                        saveImages(images = event.images!!)
                    }
                }
            }
        }
    }

    @Subscribe(threadMode = ThreadMode.MAIN)
    fun onGetBreedsEventMainThread(event: GetBreedsEvent) {
        if (event.throwable != null) {
            event.throwable?.printStackTrace()
            if (screen != null) {
                screen?.showError(event.throwable?.message.orEmpty())
            }
        } else {
            if (screen != null) {
                if (event.breeds != null) {
                     screen?.breedsDownLoaded(breeds = event.breeds)
                }
            }
        }
    }
}