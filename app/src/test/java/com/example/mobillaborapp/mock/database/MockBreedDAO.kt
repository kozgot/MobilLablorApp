package com.example.mobillaborapp.mock.database

import com.example.mobillaborapp.model.Breed
import com.example.mobillaborapp.repository.database.BreedDAO

class MockBreedDAO : BreedDAO {
    override suspend fun getSpecificBreed(id: String): List<Breed> {
        TODO("Not yet implemented")
    }

    override suspend fun getAllBreeds(): List<Breed> {
        TODO("Not yet implemented")
    }

    override suspend fun insertBreed(vararg breed: Breed) {
        TODO("Not yet implemented")
    }

    override suspend fun deleteBreed(breed: Breed) {
        TODO("Not yet implemented")
    }
}