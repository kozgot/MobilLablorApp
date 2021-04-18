package com.example.mobillaborapp.mock.database

import com.example.mobillaborapp.model.Image
import com.example.mobillaborapp.repository.database.ImageDAO

class MockImageDAO : ImageDAO {
    override suspend fun getSpecificImage(id: String): List<Image> {
        TODO("Not yet implemented")
    }

    override suspend fun getAllImages(): List<Image> {
        TODO("Not yet implemented")
    }

    override suspend fun insertImage(vararg image: Image) {
        TODO("Not yet implemented")
    }

    override suspend fun deleteImage(image: Image) {
        TODO("Not yet implemented")
    }
}