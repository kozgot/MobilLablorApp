package com.example.mobillaborapp.repository.database

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import com.example.mobillaborapp.model.Breed

@Dao
interface BreedDAO {
    @Query("SELECT * FROM breed WHERE id = :id")
    suspend fun getSpecificBreed(id: Int): List<Breed>

    @Query("SELECT * FROM breed")
    suspend fun getAllBreeds(): List<Breed>

    @Insert
    suspend fun insertBreed(vararg breed: Breed)

    @Delete
    suspend fun deleteBreed(breed: Breed)
}