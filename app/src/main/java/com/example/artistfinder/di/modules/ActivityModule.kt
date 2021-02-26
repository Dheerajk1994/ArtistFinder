package com.example.artistfinder.di.modules

import android.content.Context
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.artistfinder.ui.tracks_fragment.TrackRVAdapter
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class ActivityModule{
    @Provides
    @Singleton
    fun provideTrackRVAdapter() : TrackRVAdapter {
        return TrackRVAdapter()
    }

    @Provides
    fun provideLayoutManager(context : Context) : LinearLayoutManager{
        return LinearLayoutManager(context)
    }
}