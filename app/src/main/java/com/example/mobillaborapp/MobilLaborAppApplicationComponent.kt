package com.example.mobillaborapp
import com.example.mobillaborapp.repository.InteractorModule
import com.example.mobillaborapp.repository.network.NetworkModule
import com.example.mobillaborapp.ui.UIModule
import com.example.mobillaborapp.ui.addpicture.AddPictureActivity
import com.example.mobillaborapp.ui.picturelist.ScrollingActivity
import dagger.Component
import javax.inject.Singleton

@Singleton
@Component(modules = [UIModule::class, NetworkModule::class, InteractorModule::class])
interface MobilLaborAppApplicationComponent {
    fun inject(scrollingActivity: ScrollingActivity)
    fun inject(addPictureActivity: AddPictureActivity)
}