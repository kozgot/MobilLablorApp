package com.example.mobillaborapp.mock.database

import com.example.mobillaborapp.model.database.DbBreed
import com.example.mobillaborapp.repository.database.BreedDAO

class MockBreedDAO : BreedDAO {
    override suspend fun getSpecificBreed(id: String): List<DbBreed> {
        var breedList = mutableListOf<DbBreed>()
        var mockBreed = DbBreed(null, "bamb", "Bambino", 0,
            "The Bambino is a breed of cat that was created as a cross between the Sphynx and the Munchkin breeds. The Bambino cat has short legs, large upright ears, and is usually hairless. They love to be handled and cuddled up on the laps of their family members.",
            "Affectionate, Lively, Friendly, Intelligent","12 - 14","",
            "https://en.wikipedia.org/wiki/Bambino_cat","","United States", 1,
            1, 0, 0, 0, 0, 1, 0, 5, 5,
            "US", 4, 5, 5, 1, 1, 5, 1,
            3, 3, 3)
        breedList.add(mockBreed)
        return breedList
    }

    override suspend fun getAllBreeds(): List<DbBreed> {
        var breedList = mutableListOf<DbBreed>()
        var mockBreed = DbBreed(null, "bamb", "Bambino", 0,
            "The Bambino is a breed of cat that was created as a cross between the Sphynx and the Munchkin breeds. The Bambino cat has short legs, large upright ears, and is usually hairless. They love to be handled and cuddled up on the laps of their family members.",
            "Affectionate, Lively, Friendly, Intelligent","12 - 14","",
            "https://en.wikipedia.org/wiki/Bambino_cat","","United States", 1,
            1, 0, 0, 0, 0, 1, 0, 5, 5,
            "US", 4, 5, 5, 1, 1, 5, 1,
            3, 3, 3)
        breedList.add(mockBreed)
        return breedList
    }

    override suspend fun insertBreed(vararg breed: DbBreed) {
        TODO("Not yet implemented")
    }

    override suspend fun deleteBreed(breed: DbBreed) {
        TODO("Not yet implemented")
    }
}