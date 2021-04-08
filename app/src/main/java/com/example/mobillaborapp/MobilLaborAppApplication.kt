package com.example.mobillaborapp

import android.app.Application
import com.example.mobillaborapp.ui.UIModule

class MobilLaborAppApplication: Application() {
    lateinit var injector: MobilLaborAppApplicationComponent

    override fun onCreate() {
        super.onCreate()
        injector = DaggerMobilLaborAppApplicationComponent.builder().uIModule(UIModule(this)).build()
    }
}