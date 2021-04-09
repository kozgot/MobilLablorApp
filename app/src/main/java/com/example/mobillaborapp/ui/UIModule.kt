package com.example.mobillaborapp.ui

import android.content.Context
import com.example.mobillaborapp.repository.network.NetworkInteractor
import com.example.mobillaborapp.ui.addpicture.AddPicturePresenter
import com.example.mobillaborapp.ui.picturedetails.PictureDetailsPresenter
import com.example.mobillaborapp.ui.picturelist.PicListPresenter
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class UIModule(private val context: Context) {

    @Provides
    fun context() = context

    @Provides
    @Singleton
    fun listPresenter(networkInteractor: NetworkInteractor) = PicListPresenter(networkInteractor)

    @Provides
    @Singleton
    fun pictureDetailsPresenter(networkInteractor: NetworkInteractor) = PictureDetailsPresenter(networkInteractor)


    @Provides
    @Singleton
    fun addPicturePresenter(networkInteractor: NetworkInteractor) = AddPicturePresenter(networkInteractor)
}