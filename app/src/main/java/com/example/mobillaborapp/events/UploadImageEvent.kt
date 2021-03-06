package com.example.mobillaborapp.events

import com.example.mobillaborapp.model.network.UploadResponse

data class UploadImageEvent (
    var code: Int = 0,
    var result: UploadResponse? = null,
    var throwable: Throwable? = null
)