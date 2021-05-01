package com.example.mobillaborapp.ui.picturelist

import com.example.mobillaborapp.model.network.Breed
import com.example.mobillaborapp.model.network.Image

interface PicListScreen {
    fun showImages(imagesList: List<Image>?)
    fun showError(message: String)
    fun breedsDownLoaded(breeds: List<Breed>?)
}