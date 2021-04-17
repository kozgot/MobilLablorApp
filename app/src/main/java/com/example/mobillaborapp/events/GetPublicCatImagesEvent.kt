package com.example.mobillaborapp.events

import com.example.mobillaborapp.model.Image

data class GetPublicCatImagesEvent(
        var code: Int = 0,
        var images: List<Image>? = null,
        var throwable: Throwable? = null
)