package com.example.mobillaborapp

import android.app.Activity


val Activity.injector: MobilLaborAppApplicationComponent
    get() {
        return (this.applicationContext as MobilLaborAppApplication).injector
    }
