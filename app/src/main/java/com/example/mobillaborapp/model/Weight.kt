package com.example.mobillaborapp.model

import com.google.gson.annotations.SerializedName

class Weight {
    @SerializedName("imperial")
    var imperial: String? = null

    @SerializedName("metric")
    var metric: String? = null
}