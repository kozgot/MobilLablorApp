package com.example.mobillaborapp.model

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.google.gson.annotations.SerializedName

@Entity(tableName = "breed")
data class Breed (
        @PrimaryKey
        @SerializedName("id")
        var id: Int? = null,

        @ColumnInfo(name = "name")
        @SerializedName("name")
        var name: String? = null,

        @ColumnInfo(name = "indoor")
        @SerializedName("indoor")
        var indoor: Int? = null,

        @ColumnInfo(name = "image")
        @SerializedName("image")
        var image: ImageShort? = null,

        @ColumnInfo(name = "temperament")
        @SerializedName("temperament")
        var temperament: String? = null,

        @ColumnInfo(name = "lifespan")
        @SerializedName("life_span")
        var lifeSpan: String? = null,

        @ColumnInfo(name = "altnames")
        @SerializedName("alt_names")
        var altNames: String? = null,

        @ColumnInfo(name = "wikipediaurl")
        @SerializedName("wikipedia_url")
        var wikipediaUrl: String? = null,

        @ColumnInfo(name = "vetstreeturl")
        @SerializedName("vetstreet_url")
        var vetstreetUrl: String? = null,

        @ColumnInfo(name = "referenceimageid")
        @SerializedName("reference_image_id")
        var referenceImageId: String? = null,

        @ColumnInfo(name = "origin")
        @SerializedName("origin")
        var origin: String? = null,

        @ColumnInfo(name = "experimental")
        @SerializedName("experimental")
        var experimental: Int? = null,

        @ColumnInfo(name = "hairless")
        @SerializedName("hairless")
        var hairless: Int? = null,

        @ColumnInfo(name = "natural")
        @SerializedName("natural")
        var natural: Int? = null,

        @ColumnInfo(name = "rare")
        @SerializedName("rare")
        var rare: Int? = null,

        @ColumnInfo(name = "rex")
        @SerializedName("rex")
        var rex: Int? = null,

        @ColumnInfo(name = "supresstail")
        @SerializedName("supress_tail")
        var supressTail: Int? = null,

        @ColumnInfo(name = "shortlegs")
        @SerializedName("short_legs")
        var shortLegs: Int? = null,

        @ColumnInfo(name = "hypoallergenic")
        @SerializedName("hypoallergenic")
        var hypoallergenic: Int? = null,

        @ColumnInfo(name = "adaptability")
        @SerializedName("adaptability")
        var adaptability: Int? = null,

        @ColumnInfo(name = "affectionlevel")
        @SerializedName("affection_level")
        var affectionLevel: Int? = null,

        @ColumnInfo(name = "countrycode")
        @SerializedName("country_code")
        var countryCode: String? = null,

        @ColumnInfo(name = "childfriendly")
        @SerializedName("child_friendly")
        var childFriendly: Int? = null,

        @ColumnInfo(name = "dogfriendly")
        @SerializedName("dog_friendly")
        var dogFriendly: Int? = null,

        @ColumnInfo(name = "energylevel")
        @SerializedName("energy_level")
        var energyLevel: Int? = null,

        @ColumnInfo(name = "grooming")
        @SerializedName("grooming")
        var grooming: Int? = null,

        @ColumnInfo(name = "healthissues")
        @SerializedName("health_issues")
        var healthIssues: Int? = null,

        @ColumnInfo(name = "intelligence")
        @SerializedName("intelligence")
        var intelligence: Int? = null,

        @ColumnInfo(name = "sheddinglevel")
        @SerializedName("shedding_level")
        var sheddingLevel: Int? = null,

        @ColumnInfo(name = "socialneeds")
        @SerializedName("social_needs")
        var socialNeeds: Int? = null,

        @ColumnInfo(name = "strangerfriendly")
        @SerializedName("stranger_friendly")
        var strangerFriendly: Int? = null,

        @ColumnInfo(name = "vocalisation")
        @SerializedName("vocalisation")
        var vocalisation: Int? = null
)