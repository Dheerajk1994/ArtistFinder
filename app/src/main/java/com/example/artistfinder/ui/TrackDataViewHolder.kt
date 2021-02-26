package com.example.artistfinder.ui

import android.view.View
import androidx.recyclerview.widget.RecyclerView
import com.example.artistfinder.model.result.TrackPoko

interface ITrackViewHolder {
    fun bindTrack(apiResult : TrackPoko)
}

abstract class DataViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView), ITrackViewHolder

class TrackDataViewHolder(itemView: View) : DataViewHolder(itemView){
    override fun bindTrack(apiResult: TrackPoko) {

    }
}