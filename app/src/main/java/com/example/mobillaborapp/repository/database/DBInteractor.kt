package com.example.mobillaborapp.repository.database

import com.example.mobillaborapp.model.Breed
import com.example.mobillaborapp.model.Image
import javax.inject.Inject

class DBInteractor @Inject constructor(private var imageDAO: ImageDAO, private var breedDAO: BreedDAO) {
    suspend fun getImages() = imageDAO.getAllImages()

    suspend fun getImage(id: String) = imageDAO.getSpecificImage(id)

    suspend fun getBreeds() = breedDAO.getAllBreeds()

    suspend fun insertImage(image: Image) {
        imageDAO.insertImage(image)
    }

    suspend fun insertBreed(breed: Breed){
        breedDAO.insertBreed(breed)
    }

    suspend fun deteleBreed(breed: Breed){
        breedDAO.deleteBreed(breed)
    }

    suspend fun deleteImage(image: Image){
        imageDAO.deleteImage(image)
    }
}