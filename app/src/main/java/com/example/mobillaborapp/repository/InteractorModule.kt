package com.example.mobillaborapp.repository

import com.example.mobillaborapp.repository.network.CatAPI
import com.example.mobillaborapp.repository.network.NetworkInteractor
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class InteractorModule {
    @Provides
    @Singleton
    fun provideArtistsInteractor(catPicsApi: CatAPI) = NetworkInteractor(catPicsApi)
}