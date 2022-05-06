package com.chsh.orange

import android.app.Application
import com.chsh.orange.util.GlobalContext

class OrangeApplication : Application() {

    override fun onCreate() {
        super.onCreate()
        GlobalContext.context = this
    }

}