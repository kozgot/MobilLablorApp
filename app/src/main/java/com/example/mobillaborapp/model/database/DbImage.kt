package com.example.mobillaborapp.model.database

import androidx.room.*

@Entity(tableName = "image")
data class DbImage(
        @Embedded
        var breed: DbBreed? = null,

        @PrimaryKey(autoGenerate = true)
        var imageId: Long?,

        // the ID from the model used by the API
        @ColumnInfo(name = "originalImageId")
        var originalImageId: String,

        @ColumnInfo(name = "url")
        var url: String? = null,

        @ColumnInfo(name = "width")
        var width: Int? = null,

        @ColumnInfo(name = "height")
        var height: Int? = null,

        @ColumnInfo(name = "subid")
        var subId: String? = null,

        @ColumnInfo(name = "createdat")
        var createdAt: String? = null,

        @ColumnInfo(name = "originalfilename")
        var originalFilename: String? = null,

        @ColumnInfo(name = "breedids")
        var breedIds: String? = null
) {
        override fun equals(other: Any?) = (other is DbImage) &&
                other.breed == this.breed &&
                other.breedIds == this.breedIds &&
                other.imageId == this.imageId &&
                other.originalFilename == this.originalFilename &&
                other.originalImageId == this.originalImageId &&
                other.createdAt == this.createdAt &&
                other.subId == this.subId &&
                other.url == this.url &&
                other.height == this.height &&
                other.width == this.width
}