package com.example.artistfinder.di.component

import com.example.artistfinder.di.modules.ActivityModule
import com.example.artistfinder.di.modules.ApplicationModule
import com.example.artistfinder.di.modules.NetworkModule
import com.example.artistfinder.ui.MainActivity
import dagger.Component
import javax.inject.Singleton


@Component(modules = [
    ApplicationModule::class,
    NetworkModule::class,
    ActivityModule::class
])
@Singleton
interface AppComponent{
    fun inject(mainActivity : MainActivity)
}
