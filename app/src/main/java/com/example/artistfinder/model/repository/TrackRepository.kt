package com.example.artistfinder.model.repository

import com.example.artistfinder.model.remote.NetworkService
import com.example.artistfinder.model.result.TrackPoko
import io.reactivex.Single
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers
import javax.inject.Inject

open class TrackRepository @Inject constructor(private val networkService : NetworkService){
    fun searchArtist(query : String) : Single<MutableList<TrackPoko>> {
        return getTracksFromRemote(query)
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
    }

    private fun getTracksFromRemote(query : String) : Single<MutableList<TrackPoko>> {
        return networkService
            .getTracks(query)
            .map {
                it.results
            }
    }
}