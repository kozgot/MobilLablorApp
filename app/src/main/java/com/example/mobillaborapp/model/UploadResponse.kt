package com.example.mobillaborapp.model

import com.google.gson.annotations.SerializedName

class UploadResponse {
    @SerializedName("id")
    var id: String? = null

    @SerializedName("url")
    var url: String? = null

    @SerializedName("width")
    var width: Int? = null

    @SerializedName("height")
    var height: Int? = null

    @SerializedName("original_filename")
    var originalFilename: String? = null

    @SerializedName("pending")
    var pending: Int? = null

    @SerializedName("approved")
    var approved: Int? = null
}