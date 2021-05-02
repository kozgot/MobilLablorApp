package com.example.mobillaborapp

import com.example.mobillaborapp.mock.database.MockDbModule
import com.example.mobillaborapp.mock.network.MockNetworkModule
import dagger.Component
import javax.inject.Singleton

@Singleton
@Component(modules = [MockNetworkModule::class, AndroidTestModule::class, MockDbModule::class])
interface AndroidTestComponent : MobilLaborAppApplicationComponent
