package com.example.artistfinder.utils

import android.app.Application
import com.example.artistfinder.di.component.AppComponent
import com.example.artistfinder.di.component.DaggerAppComponent
import com.example.artistfinder.di.modules.ApplicationModule

class CustomApplication : Application(){
    companion object{
        private lateinit var applicationComponent : AppComponent

        fun getComponent() : AppComponent{
            return applicationComponent
        }
    }

    override fun onCreate() {
        super.onCreate()
        applicationComponent = DaggerAppComponent.builder()
            .applicationModule(
                ApplicationModule(this)
            ).build()
    }
}