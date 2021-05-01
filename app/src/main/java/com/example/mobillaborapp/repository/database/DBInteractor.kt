package com.example.mobillaborapp.repository.database

import com.example.mobillaborapp.model.database.DbBreed
import com.example.mobillaborapp.model.database.DbImage
import javax.inject.Inject

class DBInteractor @Inject constructor(private var imageDAO: ImageDAO, private var breedDAO: BreedDAO) {
    suspend fun getImages() = imageDAO.getAllImages()

    suspend fun getImage(id: String) = imageDAO.getSpecificImage(id)

    suspend fun getBreeds() = breedDAO.getAllBreeds()

    suspend fun insertImage(image: DbImage) {
        imageDAO.insertImage(image)
    }

    suspend fun insertBreed(breed: DbBreed){
        breedDAO.insertBreed(breed)
    }

    suspend fun deteleBreed(breed: DbBreed){
        breedDAO.deleteBreed(breed)
    }

    suspend fun deleteImage(image: DbImage){
        imageDAO.deleteImage(image)
    }
}