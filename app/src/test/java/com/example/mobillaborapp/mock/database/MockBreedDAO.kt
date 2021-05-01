package com.example.mobillaborapp.mock.database

import com.example.mobillaborapp.model.database.DbBreed
import com.example.mobillaborapp.repository.database.BreedDAO

class MockBreedDAO : BreedDAO {
    override suspend fun getSpecificBreed(id: String): List<DbBreed> {
        TODO("Not yet implemented")
    }

    override suspend fun getAllBreeds(): List<DbBreed> {
        TODO("Not yet implemented")
    }

    override suspend fun insertBreed(vararg breed: DbBreed) {
        TODO("Not yet implemented")
    }

    override suspend fun deleteBreed(breed: DbBreed) {
        TODO("Not yet implemented")
    }
}