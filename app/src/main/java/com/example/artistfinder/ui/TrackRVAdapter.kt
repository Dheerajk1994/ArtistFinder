package com.example.artistfinder.ui

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.artistfinder.R
import com.example.artistfinder.model.TrackData

class TrackRVAdapter : RecyclerView.Adapter<DataViewHolder>() {

    private var trackData : MutableList<TrackData> = mutableListOf()

    fun setData(newTracks : List<TrackData>){
        this.trackData = newTracks.toMutableList()
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): DataViewHolder {
        return TrackDataViewHolder(LayoutInflater.from(parent.context).inflate(R.layout.track_card, parent, false))
    }

    override fun getItemCount(): Int = trackData.size

    override fun onBindViewHolder(holder: DataViewHolder, position: Int) {
        holder.bindTrack(trackData[position])
    }
}