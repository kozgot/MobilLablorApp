package com.example.mobillaborapp.repository.database

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import com.example.mobillaborapp.model.ImageShort

@Dao
interface ShortImageDAO {
    @Query("SELECT * FROM shortimage WHERE id = :id")
    suspend fun getSpecificShortImage(id: String): List<ImageShort>

    @Query("SELECT * FROM shortimage")
    suspend fun getAllShortImages(): List<ImageShort>

    @Insert
    suspend fun insertShortImage(vararg shortImage: ImageShort)

    @Delete
    suspend fun deleteShortImage(shortImage: ImageShort)
}
