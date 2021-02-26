package com.example.artistfinder.di.modules

import com.example.artistfinder.ui.TrackRVAdapter
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class ActivityModule{
    @Provides
    @Singleton
    fun provideTrackRVAdapter() : TrackRVAdapter{
        return TrackRVAdapter()
    }
}