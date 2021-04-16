package com.example.mobillaborapp.model

import com.google.gson.annotations.SerializedName

class Category {
    @SerializedName("id")
    var id: Int? = null

    @SerializedName("name")
    var name: String? = null

    override fun equals(o: Any?): Boolean {
        if (this === o) {
            return true
        }
        if (o == null || javaClass != o.javaClass) {
            return false
        }
        val category = o as Category
        return id == category.id &&
                name == category.name
    }
}