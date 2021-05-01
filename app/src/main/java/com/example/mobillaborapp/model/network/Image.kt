package com.example.mobillaborapp.model.network

import com.google.gson.annotations.SerializedName

class Image(
        @SerializedName("breeds")
        var breeds: List<Breed> = ArrayList(),

        @SerializedName("id")
        var id: String,

        @SerializedName("url")
        var url: String? = null,

        @SerializedName("width")
        var width: Int? = null,

        @SerializedName("height")
        var height: Int? = null,

        @SerializedName("sub_id")
        var subId: String? = null,

        @SerializedName("created_at")
        var createdAt: String? = null,

        @SerializedName("original_filename")
        var originalFilename: String? = null,

        @SerializedName("breed_ids")
        var breedIds: String? = null
)