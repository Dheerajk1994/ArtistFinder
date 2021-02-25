package com.example.artistfinder.ui

import android.view.View
import androidx.recyclerview.widget.RecyclerView
import com.example.artistfinder.model.TrackData

interface ITrackViewHolder {
    fun bindTrack(trackData : TrackData)
}

abstract class DataViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView), ITrackViewHolder

class TrackDataViewHolder(itemView: View) : DataViewHolder(itemView){
    override fun bindTrack(trackData: TrackData) {

    }
}