package com.example.mobillaborapp.ui.picturedetails

import com.example.mobillaborapp.events.DeleteImageEvent
import com.example.mobillaborapp.events.GetImageEvent
import com.example.mobillaborapp.model.network.Image
import com.example.mobillaborapp.model.utils.convertFromDbImage
import com.example.mobillaborapp.model.utils.convertToDbImage
import com.example.mobillaborapp.repository.database.DBInteractor
import com.example.mobillaborapp.repository.network.NetworkInteractor
import com.example.mobillaborapp.ui.Presenter
import org.greenrobot.eventbus.EventBus
import org.greenrobot.eventbus.Subscribe
import org.greenrobot.eventbus.ThreadMode
import java.util.concurrent.Executor
import javax.inject.Inject

class PictureDetailsPresenter @Inject constructor(
    private val executor: Executor,
    private val networkInteractor: NetworkInteractor,
    private val dbInteractor: DBInteractor) : Presenter<PictureDetailsScreen>() {

    override fun attachScreen(screen: PictureDetailsScreen) {
        super.attachScreen(screen)
        EventBus.getDefault().register(this)
    }

    override fun detachScreen() {
        EventBus.getDefault().unregister(this)
        super.detachScreen()
    }

    fun loadImageFromAPI(id: String) {
        executor.execute {
            networkInteractor.getImageById(id)
        }
    }

    suspend fun deleteImage(image: Image) {
        executor.execute {
            networkInteractor.deleteImage(image.id!!)
        }

        dbInteractor.deleteImage(image.convertToDbImage())
    }

    suspend fun getImageFromDb(imageId: String): List<Image> {
        var dbImageList = dbInteractor.getImage(imageId)
        var imageList = mutableListOf<Image>()
        dbImageList.forEach{
            imageList.add(convertFromDbImage(it))
        }
        return imageList
    }

    @Subscribe(threadMode = ThreadMode.MAIN)
    fun onEventMainThread(event: GetImageEvent) {
        if (event.throwable != null) {
            event.throwable?.printStackTrace()
            if (screen != null) {
                screen?.showError(event.throwable?.message.orEmpty())
            }
        } else {
            if (screen != null) {
                if (event.image != null) {
                    screen?.showImage(event.image)
                }
            }
        }
    }

    @Subscribe(threadMode = ThreadMode.MAIN)
    fun onEventMainThread2(event: DeleteImageEvent) {
        if (event.throwable != null) {
            event.throwable?.printStackTrace()
            if (screen != null) {
                screen?.showError(event.throwable?.message.orEmpty())
            }
        } else {
            if (screen != null) {
                screen?.navigateToHomePage()
            }
        }
    }
}