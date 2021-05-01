package com.example.mobillaborapp.ui

import android.content.Context
import com.example.mobillaborapp.repository.database.DBInteractor
import com.example.mobillaborapp.repository.network.NetworkInteractor
import com.example.mobillaborapp.ui.addpicture.AddPicturePresenter
import com.example.mobillaborapp.ui.picturedetails.PictureDetailsPresenter
import com.example.mobillaborapp.ui.picturelist.PicListPresenter
import dagger.Module
import dagger.Provides
import java.util.concurrent.Executor
import java.util.concurrent.Executors
import javax.inject.Singleton

@Module
class UIModule(private val context: Context) {

    @Provides
    fun context() = context

    @Provides
    @Singleton
    fun listPresenter(executor: Executor, networkInteractor: NetworkInteractor, dbInteractor: DBInteractor) = PicListPresenter(executor, networkInteractor, dbInteractor)

    @Provides
    @Singleton
    fun pictureDetailsPresenter(executor: Executor, networkInteractor: NetworkInteractor) = PictureDetailsPresenter(executor, networkInteractor)


    @Provides
    @Singleton
    fun addPicturePresenter(executor: Executor, networkInteractor: NetworkInteractor, dbInteractor: DBInteractor) = AddPicturePresenter(executor, networkInteractor, dbInteractor)

    @Provides
    @Singleton
    fun networkExecutor(): Executor = Executors.newFixedThreadPool(1)
}