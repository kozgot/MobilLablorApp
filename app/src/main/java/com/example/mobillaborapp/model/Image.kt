package com.example.mobillaborapp.model

import androidx.room.*
import com.google.gson.annotations.SerializedName

@Entity(tableName = "image", foreignKeys = [ForeignKey(
        entity = Breed::class,
        parentColumns = arrayOf("id"),
        childColumns = arrayOf("breedid"),
        onDelete = ForeignKey.CASCADE)])
data class Image(
        @Ignore
        @SerializedName("breeds")
        var breeds: List<Breed> = ArrayList<Breed>(),

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

        @ColumnInfo(name = "breedid")
        @SerializedName("breed_ids")
        var breedIds: String? = null
)