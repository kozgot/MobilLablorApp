package com.example.mobillaborapp.mock.database

import com.example.mobillaborapp.model.database.DbBreed
import com.example.mobillaborapp.model.database.DbImage
import com.example.mobillaborapp.repository.database.ImageDAO

class MockImageDAO : ImageDAO {
    override suspend fun getSpecificImage(id: String): List<DbImage> {
        var imageList = mutableListOf<DbImage>()
        var mockBreed = DbBreed(null, "bamb", "Bambino", 0,
            "The Bambino is a breed of cat that was created as a cross between the Sphynx and the Munchkin breeds. The Bambino cat has short legs, large upright ears, and is usually hairless. They love to be handled and cuddled up on the laps of their family members.",
            "Affectionate, Lively, Friendly, Intelligent","12 - 14","",
            "https://en.wikipedia.org/wiki/Bambino_cat","","United States", 1,
            1, 0, 0, 0, 0, 1, 0, 5, 5,
            "US", 4, 5, 5, 1, 1, 5, 1,
            3, 3, 3)
        var mockImage = DbImage(mockBreed, null,"2u0QIn3hP", "https://cdn2.thecatapi.com/images/2u0QIn3hP.jpg",
            3648, 2736, null, "2021-05-01T17:16:36.000Z", "IMG_20210428_204622.jpg", "bamb")
        imageList.add(mockImage)
        return imageList
    }

    override suspend fun getAllImages(): List<DbImage> {
        var imageList = mutableListOf<DbImage>()
        var mockBreed = DbBreed(null, "bamb", "Bambino", 0,
            "The Bambino is a breed of cat that was created as a cross between the Sphynx and the Munchkin breeds. The Bambino cat has short legs, large upright ears, and is usually hairless. They love to be handled and cuddled up on the laps of their family members.",
            "Affectionate, Lively, Friendly, Intelligent","12 - 14","",
            "https://en.wikipedia.org/wiki/Bambino_cat","","United States", 1,
            1, 0, 0, 0, 0, 1, 0, 5, 5,
            "US", 4, 5, 5, 1, 1, 5, 1,
            3, 3, 3)
        var mockImage = DbImage(mockBreed, null,"2u0QIn3hP", "https://cdn2.thecatapi.com/images/2u0QIn3hP.jpg",
            3648, 2736, null, "2021-05-01T17:16:36.000Z", "IMG_20210428_204622.jpg", "bamb")
        imageList.add(mockImage)
        return imageList
    }

    override suspend fun insertImage(vararg image: DbImage) {
        TODO("Not yet implemented")
    }

    override suspend fun deleteImage(image: DbImage) {
        TODO("Not yet implemented")
    }
}