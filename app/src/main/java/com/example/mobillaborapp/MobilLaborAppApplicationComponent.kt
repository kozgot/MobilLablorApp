package com.example.mobillaborapp
import com.example.mobillaborapp.repository.InteractorModule
import com.example.mobillaborapp.ui.UIModule
import com.example.mobillaborapp.ui.picturelist.ScrollingActivity
import dagger.Component
import javax.inject.Singleton

@Singleton
@Component(modules = [UIModule::class, InteractorModule::class])
interface MobilLaborAppApplicationComponent {
    fun inject(mainActivity: ScrollingActivity)
}