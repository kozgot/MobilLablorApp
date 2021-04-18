package com.example.mobillaborapp.repository.database

import androidx.room.Database
import androidx.room.RoomDatabase
import com.example.mobillaborapp.model.Image

@Database(entities = [Image::class], version = 1)
abstract class AppDatabase : RoomDatabase() {
    abstract fun imageDao(): ImageDAO
    abstract fun breedDao(): BreedDAO
}