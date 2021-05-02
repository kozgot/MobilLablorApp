package com.example.mobillaborapp

import android.content.Context
import com.example.mobillaborapp.repository.database.DBInteractor
import com.example.mobillaborapp.repository.network.CatAPI
import com.example.mobillaborapp.repository.network.NetworkInteractor
import com.example.mobillaborapp.ui.UIModule
import com.example.mobillaborapp.ui.addpicture.AddPicturePresenter
import com.example.mobillaborapp.ui.picturedetails.PictureDetailsPresenter
import com.example.mobillaborapp.ui.picturelist.PicListPresenter
import dagger.Module
import dagger.Provides
import java.util.concurrent.Executor
import javax.inject.Singleton

@Module
class AndroidTestModule(context: Context) {
    private val uiModule: UIModule = UIModule(context)

    @Provides
    fun provideContext(): Context {
        return uiModule.context()
    }

    @Provides
    @Singleton
    fun providePicListPresenter(executor: Executor,
                                networkInteractor: NetworkInteractor,
                                dbInteractor: DBInteractor
    ): PicListPresenter {
        return uiModule.listPresenter(executor, networkInteractor, dbInteractor)
    }

    @Provides
    @Singleton
    fun provideDetailsPresenter(
        executor: Executor,
        networkInteractor:
        NetworkInteractor,
        dbInteractor: DBInteractor): PictureDetailsPresenter {
        return uiModule.pictureDetailsPresenter(executor, networkInteractor, dbInteractor)
    }

    @Provides
    @Singleton
    fun provideaddPicturePresenter(
        executor: Executor,
        networkInteractor:
        NetworkInteractor,
        dbInteractor: DBInteractor): AddPicturePresenter {
        return uiModule.addPicturePresenter(executor, networkInteractor, dbInteractor)
    }

    @Provides
    @Singleton
    fun provideNetworkExecutor(): Executor {
        return uiModule.networkExecutor()
    }

    @Provides
    @Singleton
    fun provideNetworkInteractor(catAPI: CatAPI) = NetworkInteractor(catAPI)
}
