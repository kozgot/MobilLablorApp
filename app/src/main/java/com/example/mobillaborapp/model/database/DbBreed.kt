package com.example.mobillaborapp.model.database

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "breed")
data class DbBreed (
        @PrimaryKey(autoGenerate = true)
        var breedId: Long?,

        // the ID from the model used by the API
        @ColumnInfo(name = "originalBreedId")
        var originalBreedId: String,

        @ColumnInfo(name = "name")
        var name: String? = null,

        @ColumnInfo(name = "indoor")
        var indoor: Int? = null,

        @ColumnInfo(name = "description")
        var description: String? = null,

        @ColumnInfo(name = "temperament")
        var temperament: String? = null,

        @ColumnInfo(name = "lifespan")
        var lifeSpan: String? = null,

        @ColumnInfo(name = "altnames")
        var altNames: String? = null,

        @ColumnInfo(name = "wikipediaurl")
        var wikipediaUrl: String? = null,

        @ColumnInfo(name = "vetstreeturl")
        var vetstreetUrl: String? = null,

        @ColumnInfo(name = "origin")
        var origin: String? = null,

        @ColumnInfo(name = "experimental")
        var experimental: Int? = null,

        @ColumnInfo(name = "hairless")
        var hairless: Int? = null,

        @ColumnInfo(name = "natural")
        var natural: Int? = null,

        @ColumnInfo(name = "rare")
        var rare: Int? = null,

        @ColumnInfo(name = "rex")
        var rex: Int? = null,

        @ColumnInfo(name = "supresstail")
        var supressTail: Int? = null,

        @ColumnInfo(name = "shortlegs")
        var shortLegs: Int? = null,

        @ColumnInfo(name = "hypoallergenic")
        var hypoallergenic: Int? = null,

        @ColumnInfo(name = "adaptability")
        var adaptability: Int? = null,

        @ColumnInfo(name = "affectionlevel")
        var affectionLevel: Int? = null,

        @ColumnInfo(name = "countrycode")
        var countryCode: String? = null,

        @ColumnInfo(name = "childfriendly")
        var childFriendly: Int? = null,

        @ColumnInfo(name = "dogfriendly")
        var dogFriendly: Int? = null,

        @ColumnInfo(name = "energylevel")
        var energyLevel: Int? = null,

        @ColumnInfo(name = "grooming")
        var grooming: Int? = null,

        @ColumnInfo(name = "healthissues")
        var healthIssues: Int? = null,

        @ColumnInfo(name = "intelligence")
        var intelligence: Int? = null,

        @ColumnInfo(name = "sheddinglevel")
        var sheddingLevel: Int? = null,

        @ColumnInfo(name = "socialneeds")
        var socialNeeds: Int? = null,

        @ColumnInfo(name = "strangerfriendly")
        var strangerFriendly: Int? = null,

        @ColumnInfo(name = "vocalisation")
        var vocalisation: Int? = null
)