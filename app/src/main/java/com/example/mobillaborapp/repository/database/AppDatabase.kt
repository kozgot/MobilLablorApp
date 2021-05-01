package com.example.mobillaborapp.repository.database

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.example.mobillaborapp.model.Breed
import com.example.mobillaborapp.model.Image

@Database(entities = [Image::class, Breed::class], version = 1)
abstract class AppDatabase : RoomDatabase() {
    abstract fun imageDao(): ImageDAO
    abstract fun breedDao(): BreedDAO

    companion object{
        @Volatile
        private var INSTANCE: AppDatabase? = null
        fun getInstance(context: Context): AppDatabase {
            return INSTANCE ?: synchronized(this) {
                INSTANCE ?: Room.databaseBuilder(
                        context.applicationContext,
                        AppDatabase::class.java, "cats_database"
                )
                        .fallbackToDestructiveMigration()
                        .build()
                        .also { INSTANCE = it }
            }
        }

    }
}