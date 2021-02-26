package com.example.artistfinder.di.modules

import android.app.Application
import android.content.Context
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.artistfinder.ui.TrackRVAdapter
import com.example.artistfinder.viewmodel.MainActivityViewModel
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

    @Provides
    fun provideLayoutManager(context : Context) : LinearLayoutManager{
        return LinearLayoutManager(context)
    }
}