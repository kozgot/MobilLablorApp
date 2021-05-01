package com.example.mobillaborapp.model.network

import com.google.gson.annotations.SerializedName

class Breed (
        @SerializedName("id")
        var id: String,

        @SerializedName("name")
        var name: String? = null,

        @SerializedName("indoor")
        var indoor: Int? = null,

        @SerializedName("description")
        var description: String? = null,

        @SerializedName("temperament")
        var temperament: String? = null,

        @SerializedName("life_span")
        var lifeSpan: String? = null,

        @SerializedName("alt_names")
        var altNames: String? = null,

        @SerializedName("wikipedia_url")
        var wikipediaUrl: String? = null,

        @SerializedName("vetstreet_url")
        var vetstreetUrl: String? = null,

        @SerializedName("origin")
        var origin: String? = null,

        @SerializedName("experimental")
        var experimental: Int? = null,

        @SerializedName("hairless")
        var hairless: Int? = null,

        @SerializedName("natural")
        var natural: Int? = null,

        @SerializedName("rare")
        var rare: Int? = null,

        @SerializedName("rex")
        var rex: Int? = null,

        @SerializedName("supress_tail")
        var supressTail: Int? = null,

        @SerializedName("short_legs")
        var shortLegs: Int? = null,

        @SerializedName("hypoallergenic")
        var hypoallergenic: Int? = null,

        @SerializedName("adaptability")
        var adaptability: Int? = null,

        @SerializedName("affection_level")
        var affectionLevel: Int? = null,

        @SerializedName("country_code")
        var countryCode: String? = null,

        @SerializedName("child_friendly")
        var childFriendly: Int? = null,

        @SerializedName("dog_friendly")
        var dogFriendly: Int? = null,

        @SerializedName("energy_level")
        var energyLevel: Int? = null,

        @SerializedName("grooming")
        var grooming: Int? = null,

        @SerializedName("health_issues")
        var healthIssues: Int? = null,

        @SerializedName("intelligence")
        var intelligence: Int? = null,

        @SerializedName("shedding_level")
        var sheddingLevel: Int? = null,

        @SerializedName("social_needs")
        var socialNeeds: Int? = null,

        @SerializedName("stranger_friendly")
        var strangerFriendly: Int? = null,

        @SerializedName("vocalisation")
        var vocalisation: Int? = null
)