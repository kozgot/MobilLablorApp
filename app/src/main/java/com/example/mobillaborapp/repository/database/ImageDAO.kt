package com.example.mobillaborapp.repository.database

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import com.example.mobillaborapp.model.database.DbImage

@Dao
interface ImageDAO {
    @Query("SELECT * FROM image WHERE originalImageId = :id")
    suspend fun getSpecificImage(id: String): List<DbImage>

    @Query("SELECT * FROM image")
    suspend fun getAllImages(): List<DbImage>

    @Insert
    suspend fun insertImage(vararg image: DbImage)

    @Delete
    suspend fun deleteImage(image: DbImage)
}