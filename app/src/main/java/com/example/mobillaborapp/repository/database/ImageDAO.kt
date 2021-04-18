package com.example.mobillaborapp.repository.database

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import com.example.mobillaborapp.model.Image

@Dao
interface ImageDAO {
    @Query("SELECT * FROM image WHERE id = :id")
    suspend fun getSpecificImage(id: String): List<Image>

    @Query("SELECT * FROM image")
    suspend fun getAllImages(): List<Image>

    @Insert
    suspend fun insertImage(vararg image: Image)

    @Delete
    suspend fun deleteImage(image: Image)
}