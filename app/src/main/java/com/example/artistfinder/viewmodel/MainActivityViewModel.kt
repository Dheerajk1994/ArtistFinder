package com.example.artistfinder.viewmodel

import android.view.View
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.artistfinder.model.repository.TrackRepository
import com.example.artistfinder.model.result.TrackPoko
import io.reactivex.disposables.CompositeDisposable
import javax.inject.Inject

interface IMainActivityViewModel{
    fun searchArtist(name : String)
}

class MainActivityViewModel @Inject constructor(private val trackRepository : TrackRepository): ViewModel(), IMainActivityViewModel {
    var trackData : MutableLiveData<MutableList<TrackPoko>> = MutableLiveData()
    var loadingScreenVisibility : MutableLiveData<Int> = MutableLiveData()

    private val disposable = CompositeDisposable()

    override fun searchArtist(name: String) {
        showLoadingScreen()
        disposable.add(
            trackRepository.searchArtist(name)
                .subscribe({
                    if(it.isNotEmpty()){
                        trackData.postValue(it)
                    }
                    hideLoadingScreen()
                },{
                    /*Error handler*/
                })
        )
    }

    private fun showLoadingScreen(){
        loadingScreenVisibility.postValue(View.VISIBLE)
    }

    private fun hideLoadingScreen(){
        loadingScreenVisibility.postValue(View.INVISIBLE)
    }
}