package com.example.mobillaborapp.model

import com.google.gson.annotations.SerializedName

class Weight {
    @SerializedName("imperial")
    var imperial: String? = null

    @SerializedName("metric")
    var metric: String? = null

    override fun equals(o: Any?): Boolean {
        if (this === o) {
            return true
        }
        if (o == null || javaClass != o.javaClass) {
            return false
        }
        val weight = o as Weight
        return imperial == weight.imperial &&
                metric == weight.metric
    }

    override fun toString(): String {
        val sb = StringBuilder()
        sb.append("class Weight {\n")
        sb.append("    imperial: ").append(toIndentedString(imperial)).append("\n")
        sb.append("    metric: ").append(toIndentedString(metric)).append("\n")
        sb.append("}")
        return sb.toString()
    }

    /**
     * Convert the given object to string with each line indented by 4 spaces
     * (except the first line).
     */
    private fun toIndentedString(o: Any?): String {
        return o?.toString()?.replace("\n", "\n    ") ?: "null"
    }
}