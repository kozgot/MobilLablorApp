package com.example.mobillaborapp.ui.picturelist

import com.example.mobillaborapp.repository.network.NetworkInteractor
import com.example.mobillaborapp.ui.Presenter
import javax.inject.Inject

class PicListPresenter @Inject constructor(networkInteractor: NetworkInteractor) : Presenter<PicListScreen?>()  {
    override fun attachScreen(screen: PicListScreen?) {
        super.attachScreen(screen)
        // todo...
    }

    override fun detachScreen() {
        super.detachScreen()
    }
}