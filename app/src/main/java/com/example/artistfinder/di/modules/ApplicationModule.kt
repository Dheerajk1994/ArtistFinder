package com.example.artistfinder.di.modules

import android.app.Application
import android.content.Context
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class ApplicationModule(var application : Application){
    @Provides
    fun providesApplicationContext() : Context{
        return application.applicationContext
    }
}