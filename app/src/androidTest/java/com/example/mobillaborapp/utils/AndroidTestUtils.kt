package com.example.mobillaborapp.utils


import androidx.test.platform.app.InstrumentationRegistry
import com.example.mobillaborapp.AndroidTestModule
import com.example.mobillaborapp.MobilLaborAppApplication

import com.example.mobillaborapp.DaggerAndroidTestComponent
import com.example.mobillaborapp.DaggerMobilLaborAppApplicationComponent
import com.example.mobillaborapp.ui.UIModule

object AndroidTestUtils {

    fun setTestInjector() {
        val instrumentation = InstrumentationRegistry.getInstrumentation()
        val app = instrumentation.targetContext.applicationContext as MobilLaborAppApplication

        val androidTestComponent = DaggerAndroidTestComponent.builder().androidTestModule(
            AndroidTestModule(app)
        ).build()
        app.injector = androidTestComponent
    }

    fun setProdutionInjector() {
        val instrumentation = InstrumentationRegistry.getInstrumentation()
        val app = instrumentation.targetContext.applicationContext as MobilLaborAppApplication

        val androidTestComponent = DaggerMobilLaborAppApplicationComponent.builder().uIModule(
            UIModule(app)
        ).build()
        app.injector = androidTestComponent
    }
}
