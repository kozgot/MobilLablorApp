package com.example.mobillaborapp.model

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.google.gson.annotations.SerializedName

@Entity(tableName = "shortimage")
data class ImageShort (
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
        var height: Int? = null
)