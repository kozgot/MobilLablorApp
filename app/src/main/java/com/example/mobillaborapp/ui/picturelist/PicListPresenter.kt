package com.example.mobillaborapp.ui.picturelist

import com.example.mobillaborapp.events.GetBreedsEvent
import com.example.mobillaborapp.events.GetCatImagesEvent
import com.example.mobillaborapp.model.Image
import com.example.mobillaborapp.repository.database.DBInteractor
import com.example.mobillaborapp.repository.network.NetworkInteractor
import com.example.mobillaborapp.ui.Presenter
import org.greenrobot.eventbus.EventBus
import org.greenrobot.eventbus.Subscribe
import org.greenrobot.eventbus.ThreadMode
import java.util.concurrent.Executor
import javax.inject.Inject
import com.example.mobillaborapp.model.Breed

class PicListPresenter @Inject constructor(private val executor: Executor, private val networkInteractor: NetworkInteractor) : Presenter<PicListScreen>()  {
    override fun attachScreen(screen: PicListScreen) {
        super.attachScreen(screen)
        EventBus.getDefault().register(this)
    }

    override fun detachScreen() {
        EventBus.getDefault().unregister(this)
        super.detachScreen()
    }

    fun queryImages() {
        executor.execute {
            networkInteractor.getOwnImages()
        }
    }

    fun queryBreeds() {
        executor.execute {
            networkInteractor.getBreeds()
        }
    }

    @Subscribe(threadMode = ThreadMode.MAIN)
    fun onEventMainThread(event: GetCatImagesEvent) {
        if (event.throwable != null) {
            event.throwable?.printStackTrace()
            if (screen != null) {
                // todo handle error
                //screen?.showNetworkError(event.throwable?.message.orEmpty())
            }
        } else {
            if (screen != null) {
                if (event.images != null) {
                    screen?.showImages(event.images as MutableList<Image>)
                }
            }
        }
    }

    suspend fun saveBreeds(breeds: List<Breed>) {
        breeds.forEach {
            //dbInteractor.insertBreed(it)
        }
    }

    @Subscribe(threadMode = ThreadMode.MAIN)
    fun onGetBreedsEventMainThread(event: GetBreedsEvent) {
        if (event.throwable != null) {
            event.throwable?.printStackTrace()
            if (screen != null) {
                // todo handle error
                //screen?.showNetworkError(event.throwable?.message.orEmpty())
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