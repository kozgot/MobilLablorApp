package com.example.mobillaborapp.repository.network


import android.util.Log
import com.example.mobillaborapp.events.GetCatImagesEvent
import org.greenrobot.eventbus.EventBus
import javax.inject.Inject

class NetworkInteractor @Inject constructor(private var catsApi: CatAPI) {
    fun getArtists(artistQuery: String) {
        val event = GetCatImagesEvent()

        try {
            val catImagesQueryCall =
                catsApi.listOwnImages("...todo: api key ", 3, 0)

            val response = catImagesQueryCall.execute()
            Log.d("Reponse", response.body().toString())
            if (response.code() != 200) {
                throw Exception("Result code is not 200")
            }
            event.code = response.code()
            event.images = response.body()?.images
            EventBus.getDefault().post(event)
        } catch (e: Exception) {
            event.throwable = e
            EventBus.getDefault().post(event)
        }
    }
}