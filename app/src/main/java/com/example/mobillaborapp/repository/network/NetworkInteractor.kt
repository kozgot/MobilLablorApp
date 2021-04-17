package com.example.mobillaborapp.repository.network


import android.util.Log
import com.example.mobillaborapp.events.*
import okhttp3.RequestBody
import org.greenrobot.eventbus.EventBus
import javax.inject.Inject

const val XApiKey = "16d40230-356f-4ee1-83ab-b3b9189b52f4"

class NetworkInteractor @Inject constructor(private var catsApi: CatAPI) {
    fun getOwnImages(page: Int?) {
        val event = GetCatImagesEvent()
        try {
            val catImagesQueryCall =
                catsApi.listOwnImages(XApiKey, 3, page)

            val response = catImagesQueryCall.execute()
            Log.d("Response", response.body().toString())
            if (response.code() != 200) {
                throw Exception("Result code is not 200")
            }
            event.code = response.code()
            event.images = response.body()
            EventBus.getDefault().post(event)
        } catch (e: Exception) {
            event.throwable = e
            EventBus.getDefault().post(event)
        }
    }

    fun getPublicImages(page: Int?) {
        val event = GetPublicCatImagesEvent()
        try {
            val catImagesQueryCall =
                    catsApi.listPublicImages(XApiKey, 3, page)

            val response = catImagesQueryCall.execute()
            Log.d("Response", response.body().toString())
            if (response.code() != 200) {
                throw Exception("Result code is not 200")
            }
            event.code = response.code()
            event.images = response.body()
            EventBus.getDefault().post(event)
        } catch (e: Exception) {
            event.throwable = e
            EventBus.getDefault().post(event)
        }
    }

    fun getBreeds() {
        val event = GetBreedsEvent()
        try {
            val catBreedsQueryCall =
                    catsApi.listBreeds(XApiKey)

            val response = catBreedsQueryCall.execute()
            Log.d("Response", response.body().toString())
            if (response.code() != 200) {
                throw Exception("Result code is not 200")
            }
            event.code = response.code()
            event.breeds = response.body()
            EventBus.getDefault().post(event)
        } catch (e: Exception) {
            event.throwable = e
            EventBus.getDefault().post(event)
        }
    }

    fun getImageById(id: String) {
        val event = GetImageEvent()
        try {
            val catImageQueryCall =
                    catsApi.getImage(id, XApiKey)

            val response = catImageQueryCall.execute()
            Log.d("Response", response.body().toString())
            if (response.code() != 200) {
                throw Exception("Result code is not 200")
            }
            event.code = response.code()
            event.image = response.body()
            EventBus.getDefault().post(event)
        } catch (e: Exception) {
            event.throwable = e
            EventBus.getDefault().post(event)
        }
    }

    fun deleteImage(id: String) {
        val event = DeleteImageEvent()
        try {
            val deleteImageQueryCall =
                    catsApi.getImage(id, XApiKey)

            val response = deleteImageQueryCall.execute()
            Log.d("Response", response.body().toString())
            if (response.code() != 200) {
                throw Exception("Result code is not 200")
            }
            event.code = response.code()
            EventBus.getDefault().post(event)
        } catch (e: Exception) {
            event.throwable = e
            EventBus.getDefault().post(event)
        }
    }

    fun uploadImage(requestBody: RequestBody, breedId: String) {
        val event = UploadImageEvent()
        try {
            val uploadImageQueryCall =
                    catsApi.uploadImage(requestBody, XApiKey, breedId)

            val response = uploadImageQueryCall.execute()
            Log.d("Response", response.body().toString())
            if (response.code() != 200) {
                throw Exception("Result code is not 200")
            }
            event.code = response.code()
            event.result = response.body()
            EventBus.getDefault().post(event)
        } catch (e: Exception) {
            event.throwable = e
            EventBus.getDefault().post(event)
        }
    }
}