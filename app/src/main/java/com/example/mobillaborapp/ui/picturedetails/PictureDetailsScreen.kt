package com.example.mobillaborapp.ui.picturedetails

import com.example.mobillaborapp.model.Image

interface PictureDetailsScreen {
    fun showImage(image: Image?)
    fun navigateToHomePage()
    fun showError(message: String?)
}