package com.example.mobillaborapp.mock.database

import com.example.mobillaborapp.model.database.DbImage
import com.example.mobillaborapp.repository.database.ImageDAO

class MockImageDAO : ImageDAO {
    override suspend fun getSpecificImage(id: String): List<DbImage> {
        TODO("Not yet implemented")
    }

    override suspend fun getAllImages(): List<DbImage> {
        TODO("Not yet implemented")
    }

    override suspend fun insertImage(vararg image: DbImage) {
        TODO("Not yet implemented")
    }

    override suspend fun deleteImage(image: DbImage) {
        TODO("Not yet implemented")
    }
}