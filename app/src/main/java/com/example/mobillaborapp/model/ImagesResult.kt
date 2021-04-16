package com.example.mobillaborapp.model

import com.google.gson.annotations.SerializedName

class ImagesResult {
    @SerializedName("images")
    var images: ArrayList<Image>? = null
}