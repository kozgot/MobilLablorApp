package com.example.mobillaborapp

import android.content.Context
import com.example.mobillaborapp.repository.database.DBInteractor
import com.example.mobillaborapp.repository.network.CatAPI
import com.example.mobillaborapp.repository.network.NetworkInteractor
import com.example.mobillaborapp.ui.UIModule
import com.example.mobillaborapp.ui.addpicture.AddPicturePresenter
import com.example.mobillaborapp.ui.picturedetails.PictureDetailsPresenter
import com.example.mobillaborapp.ui.picturelist.PicListPresenter
import com.example.mobillaborapp.utils.UiExecutor
import dagger.Module
import dagger.Provides
import java.util.concurrent.Executor
import javax.inject.Singleton

@Module
class TestModule(private val context: Context) {
    @Provides
    fun provideContext(): Context {
        return context
    }

    @Provides
    @Singleton
    fun providePicListPresenter(executor: Executor,
                                networkInteractor: NetworkInteractor,
                                dbInteractor: DBInteractor
    ): PicListPresenter {
        return PicListPresenter(executor, networkInteractor, dbInteractor)
    }

    @Provides
    @Singleton
    fun provideDetailsPresenter(
        executor: Executor,
        networkInteractor:
        NetworkInteractor,
        dbInteractor: DBInteractor
    ): PictureDetailsPresenter {
        return PictureDetailsPresenter(executor, networkInteractor, dbInteractor)
    }

    @Provides
    @Singleton
    fun provideaddPicturePresenter(
        executor: Executor,
        networkInteractor:
        NetworkInteractor,
        dbInteractor: DBInteractor
    ): AddPicturePresenter {
        return AddPicturePresenter(executor, networkInteractor, dbInteractor)
    }

    @Provides
    @Singleton
    fun provideNetworkExecutor(): Executor {
        return UiExecutor()
    }

    @Provides
    @Singleton
    fun provideNetworkInteractor(catAPI: CatAPI) = NetworkInteractor(catAPI)
}
