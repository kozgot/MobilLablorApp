package com.example.mobillaborapp.repository.database

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import com.example.mobillaborapp.model.Category

@Dao
interface CategoryDAO {
    @Query("SELECT * FROM category WHERE id = :id")
    suspend fun getSpecificCategory(id: Int): List<Category>

    @Query("SELECT * FROM category")
    suspend fun getAllCategories(): List<Category>

    @Insert
    suspend fun insertCategory(vararg category: Category)

    @Delete
    suspend fun deleteCategory(category: Category)
}