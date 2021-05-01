package com.example.mobillaborapp.ui.picturelist

import com.example.mobillaborapp.model.Breed
import com.example.mobillaborapp.model.Image

interface PicListScreen {
    fun showImages(imagesList: List<Image>?)
    fun breedsDownLoaded(breeds: List<Breed>?)
}