package com.example.mobillaborapp.repository.database

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import com.example.mobillaborapp.model.Weight

@Dao
interface WeightDAO {
    @Query("SELECT * FROM weight WHERE id = :id")
    suspend fun getSpecificWeight(id: Int): List<Weight>

    @Query("SELECT * FROM weight")
    suspend fun getAllWeights(): List<Weight>

    @Insert
    suspend fun insertWeight(vararg weight: Weight)

    @Delete
    suspend fun deleteWeight(weight: Weight)
}