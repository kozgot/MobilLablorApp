package com.example.mobillaborapp.mock.database

import com.example.mobillaborapp.repository.database.DBInteractor
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class MockDbModule() {
    @Provides
    @Singleton
    fun providesImageDao(): MockImageDAO {
        return MockImageDAO()
    }

    @Provides
    @Singleton
    fun providesBreedDao(): MockBreedDAO {
        return MockBreedDAO()
    }

    @Provides
    @Singleton
    fun providesDBInteractor(imageDAO: MockImageDAO, breedDAO: MockBreedDAO) = DBInteractor(imageDAO, breedDAO)
}