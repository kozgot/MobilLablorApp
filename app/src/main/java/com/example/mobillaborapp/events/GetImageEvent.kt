package com.example.mobillaborapp.events

import com.example.mobillaborapp.model.network.Image

data class GetImageEvent(
    var code: Int = 0,
    var image: Image? = null,
    var throwable: Throwable? = null
)