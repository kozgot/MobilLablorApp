package com.example.mobillaborapp.model.network

import com.google.gson.annotations.SerializedName

class ErrorResponse {
    @SerializedName("message")
    var message: String? = null

    @SerializedName("headers")
    var headers: Headers? = null

    @SerializedName("status")
    var status: Int? = null

    @SerializedName("level")
    var level: String? = null
}