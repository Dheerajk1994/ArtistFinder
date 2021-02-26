package com.example.artistfinder.viewmodel

import android.view.View
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.artistfinder.model.repository.TrackRepository
import com.example.artistfinder.model.result.TrackPoko
import io.reactivex.disposables.CompositeDisposable
import javax.inject.Inject

interface IMainActivityViewModel {
    val trackData: LiveData<MutableList<TrackPoko>>
    val loadingScreenVisibility: LiveData<Int>
    fun searchArtist(name: String)
}

class MainActivityViewModel @Inject constructor(private val trackRepository: TrackRepository) :
    ViewModel(), IMainActivityViewModel {
    override val trackData: LiveData<MutableList<TrackPoko>>
        get(){
            return mutableTrackData
        }
    override val loadingScreenVisibility: LiveData<Int>
        get(){
            return mutableLoadingScreenLiveData
        }

    private var mutableLoadingScreenLiveData : MutableLiveData<Int> = MutableLiveData()
    private var mutableTrackData: MutableLiveData<MutableList<TrackPoko>> = MutableLiveData()

    private val disposable = CompositeDisposable()

    override fun searchArtist(name: String) {
        showLoadingScreen()
        disposable.add(
            trackRepository.searchArtist(name)
                .subscribe({
                    if (it.isNotEmpty()) {
                        mutableTrackData.postValue(it)
                    }
                    hideLoadingScreen()
                }, {
                    /*Error handler*/
                })
        )
    }

    fun showLoadingScreen() {
        mutableLoadingScreenLiveData.postValue(View.VISIBLE)
    }

    fun hideLoadingScreen() {
        mutableLoadingScreenLiveData.postValue(View.INVISIBLE)
    }
}