package com.chsh.orange

import android.app.Application
import com.chsh.orange.app.util.GlobalContext
import dagger.hilt.android.HiltAndroidApp

@HiltAndroidApp
class OrangeApplication : Application() {

    override fun onCreate() {
        super.onCreate()
        GlobalContext.context = this
    }

}