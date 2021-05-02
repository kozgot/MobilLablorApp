package com.example.mobillaborapp.ui.addpicture

import com.example.mobillaborapp.model.network.Breed

interface AddPictureScreen {
    fun showResponse(response: String)
    fun showBreeds(breeds: List<Breed>?)
}