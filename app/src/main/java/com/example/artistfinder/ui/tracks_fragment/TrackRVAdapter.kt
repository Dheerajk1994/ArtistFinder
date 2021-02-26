package com.example.artistfinder.ui.tracks_fragment

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.artistfinder.R
import com.example.artistfinder.model.result.TrackPoko

class TrackRVAdapter : RecyclerView.Adapter<DataViewHolder>() {

    private var trackData : MutableList<TrackPoko> = mutableListOf()

    fun setData(newTracks : List<TrackPoko>){
        this.trackData = newTracks.toMutableList()
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): DataViewHolder {
        return TrackDataViewHolder(
            LayoutInflater.from(parent.context).inflate(R.layout.track_card, parent, false)
        )
    }

    override fun getItemCount(): Int = trackData.size

    override fun onBindViewHolder(holder: DataViewHolder, position: Int) {
        holder.bindTrack(trackData[position])
    }
}