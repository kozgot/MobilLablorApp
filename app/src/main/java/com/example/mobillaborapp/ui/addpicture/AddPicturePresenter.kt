package com.example.mobillaborapp.ui.addpicture

import com.example.mobillaborapp.events.UploadImageEvent
import com.example.mobillaborapp.repository.network.NetworkInteractor
import com.example.mobillaborapp.ui.Presenter
import okhttp3.MediaType
import okhttp3.MultipartBody
import okhttp3.RequestBody
import org.greenrobot.eventbus.EventBus
import org.greenrobot.eventbus.Subscribe
import org.greenrobot.eventbus.ThreadMode
import java.io.File
import java.util.concurrent.Executor
import javax.inject.Inject

class AddPicturePresenter @Inject constructor(
    private val executor: Executor,
    private val networkInteractor: NetworkInteractor
): Presenter<AddPictureScreen>() {
    override fun attachScreen(screen: AddPictureScreen) {
        super.attachScreen(screen)
        EventBus.getDefault().register(this)
    }

    override fun detachScreen() {
        EventBus.getDefault().unregister(this)
        super.detachScreen()
    }

    fun uploadImage(fileToUpload: File, breedId: String) {
        val requestFile = RequestBody.create(
            MediaType.parse("image/jpeg"),
            fileToUpload
        )
        val body = MultipartBody.Part.createFormData( "file", fileToUpload.name, requestFile)
        val breedRequestBody = RequestBody.create(MediaType.parse("multipart/form-data"), breedId)
        executor.execute {
            networkInteractor.uploadImage(body, breedRequestBody)
        }
    }

    @Subscribe(threadMode = ThreadMode.MAIN)
    fun onEventMainThread(event: UploadImageEvent) {
        if (event.throwable != null) {
            event.throwable?.printStackTrace()
            if (screen != null) {
                screen?.showResponse(event.throwable?.message.orEmpty())
            }
        } else {
            if (screen != null) {
                if (event.result != null) {
                    screen?.showResponse("Image uploaded successfully!")
                }
            }
        }
    }
}