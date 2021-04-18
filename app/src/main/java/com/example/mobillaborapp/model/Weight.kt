package com.example.mobillaborapp.model

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.google.gson.annotations.SerializedName

@Entity(tableName = "weight")
data class Weight (
        @PrimaryKey(autoGenerate = true)
        var id: Int? = null,

        @ColumnInfo(name = "imperial")
        @SerializedName("imperial")
        var imperial: String? = null,

        @ColumnInfo(name = "metric")
        @SerializedName("metric")
        var metric: String? = null
)