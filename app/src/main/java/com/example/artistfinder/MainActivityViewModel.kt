package com.example.artistfinder

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

interface IMainActivityViewModel{
    val onArtistDataReceived : MutableLiveData<Boolean>
    fun searchArtist(name : String)
}

class MainActivityViewModel : ViewModel(), IMainActivityViewModel{
    override val onArtistDataReceived: MutableLiveData<Boolean> = MutableLiveData()

    override fun searchArtist(name: String) {

    }
}