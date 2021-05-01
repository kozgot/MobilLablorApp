package com.example.mobillaborapp.repository.database

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import com.example.mobillaborapp.model.database.DbBreed

@Dao
interface BreedDAO {
    @Query("SELECT * FROM breed WHERE breedId = :id")
    suspend fun getSpecificBreed(id: String): List<DbBreed>

    @Query("SELECT * FROM breed")
    suspend fun getAllBreeds(): List<DbBreed>

    @Insert
    suspend fun insertBreed(vararg breed: DbBreed)

    @Delete
    suspend fun deleteBreed(breed: DbBreed)
}