package com.example.mobillaborapp

import com.example.mobillaborapp.mock.database.MockDbModule
import com.example.mobillaborapp.mock.network.MockNetworkModule
import com.example.mobillaborapp.repository.InteractorModule
import com.example.mobillaborapp.test.AddPictureTest
import com.example.mobillaborapp.test.PictureDetailsTest
import com.example.mobillaborapp.test.PictureListTest
import dagger.Component
import javax.inject.Singleton

@Singleton
@Component(modules = [MockNetworkModule::class, TestModule::class, MockDbModule::class])
interface TestComponent : MobilLaborAppApplicationComponent {
    fun inject(pictureListTest: PictureListTest)
    fun inject(pictureDetailsTest: PictureDetailsTest)
    fun inject(addPictureTest: AddPictureTest)
}
