package com.example.mobillaborapp.model

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.google.gson.annotations.SerializedName

@Entity(tableName = "image")
data class Image(
        @ColumnInfo(name = "breeds")
        @SerializedName("breeds")
        var breeds: List<Breed> = ArrayList<Breed>(),

        @ColumnInfo(name = "categories")
        @SerializedName("categories")
        var categories: List<Category> = ArrayList<Category>(),

        @PrimaryKey
        @SerializedName("id")
        var id: String? = null,

        @ColumnInfo(name = "url")
        @SerializedName("url")
        var url: String? = null,

        @ColumnInfo(name = "width")
        @SerializedName("width")
        var width: Int? = null,

        @ColumnInfo(name = "height")
        @SerializedName("height")
        var height: Int? = null,

        @ColumnInfo(name = "subid")
        @SerializedName("sub_id")
        var subId: String? = null,

        @ColumnInfo(name = "createdat")
        @SerializedName("created_at")
        var createdAt: String? = null,

        @ColumnInfo(name = "originalfilename")
        @SerializedName("original_filename")
        var originalFilename: String? = null,

        @ColumnInfo(name = "breedids")
        @SerializedName("breed_ids")
        var breedIds: String? = null
)