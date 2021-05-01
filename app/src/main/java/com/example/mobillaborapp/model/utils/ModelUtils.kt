package com.example.mobillaborapp.model.utils

import com.example.mobillaborapp.model.database.DbBreed
import com.example.mobillaborapp.model.database.DbImage
import com.example.mobillaborapp.model.network.Breed
import com.example.mobillaborapp.model.network.Image

fun Breed.convertToDbBreed(): DbBreed {
    return DbBreed(null, this.id!!,  this.name,
        this.indoor,  this.description, this.temperament,
        this.lifeSpan, this.altNames, this.wikipediaUrl,
        this.vetstreetUrl, this.origin, this.experimental,
        this.hairless, this.natural, this.rare, this.rex,
        this.supressTail, this.shortLegs, this.hypoallergenic,
        this.adaptability, this.affectionLevel, this.countryCode,
        this.childFriendly, this.dogFriendly, this.energyLevel,
        this.grooming, this.healthIssues, this.intelligence,
        this.sheddingLevel, this.socialNeeds, this.vocalisation)
}

fun convertFromDbBreed(dbBreed: DbBreed): Breed {
    return Breed(dbBreed.originalBreedId,  dbBreed.name,
        dbBreed.indoor,  dbBreed.description, dbBreed.temperament,
        dbBreed.lifeSpan, dbBreed.altNames, dbBreed.wikipediaUrl,
        dbBreed.vetstreetUrl, dbBreed.origin, dbBreed.experimental,
        dbBreed.hairless, dbBreed.natural, dbBreed.rare, dbBreed.rex,
        dbBreed.supressTail, dbBreed.shortLegs, dbBreed.hypoallergenic,
        dbBreed.adaptability, dbBreed.affectionLevel, dbBreed.countryCode,
        dbBreed.childFriendly, dbBreed.dogFriendly, dbBreed.energyLevel,
        dbBreed.grooming, dbBreed.healthIssues, dbBreed.intelligence,
        dbBreed.sheddingLevel, dbBreed.socialNeeds, dbBreed.vocalisation)
}

fun Image.convertToDbImage(): DbImage {
    var dbBreed: DbBreed? = null
    if (this.breeds != null && this.breeds.isNotEmpty()) {
        var breed = this.breeds[0]
        dbBreed = breed.convertToDbBreed()
    }

    return DbImage(dbBreed, null, this.id!!, this.url, this.width, this.height, this.subId, this.createdAt, this.originalFilename, this.breedIds)
}

fun convertFromDbImage(dbImage: DbImage) : Image {
    var breedList = mutableListOf<Breed>()
    if (dbImage.breed != null) {
        breedList.add(convertFromDbBreed(dbImage.breed!!))
    }

    return Image(breedList, dbImage.originalImageId, dbImage.url, dbImage.width, dbImage.height, dbImage.subId, dbImage.createdAt, dbImage.originalFilename, dbImage.breedIds)
}
