package com.example.mobillaborapp.model

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.google.gson.annotations.SerializedName

@Entity(tableName = "category")
data class Category (
        @PrimaryKey
        @SerializedName("id")
        var id: Int? = null,

        @ColumnInfo(name = "name")
        @SerializedName("name")
        var name: String? = null
)