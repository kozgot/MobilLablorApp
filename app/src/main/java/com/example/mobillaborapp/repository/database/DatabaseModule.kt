package com.example.mobillaborapp.repository.database

import android.content.Context
import androidx.room.Room
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class DatabaseModule(private val context: Context) {
    @Provides
    fun context() = context

    @Provides
    @Singleton
    fun providesImageDao(): ImageDAO{
        return AppDatabase.getInstance(context).imageDao()
    }

    @Provides
    @Singleton
    fun providesBreedDao(): BreedDAO{
        return AppDatabase.getInstance(context).breedDao()
    }

    @Provides
    @Singleton
    fun providesDBInteractor(imageDAO: ImageDAO, breedDAO: BreedDAO) = DBInteractor(imageDAO, breedDAO)
}