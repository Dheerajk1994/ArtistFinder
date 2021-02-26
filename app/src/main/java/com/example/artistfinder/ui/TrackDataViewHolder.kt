package com.example.artistfinder.ui

import android.view.View
import androidx.recyclerview.widget.RecyclerView
import com.example.artistfinder.model.result.TrackPoko
import kotlinx.android.synthetic.main.track_card.view.*

interface ITrackViewHolder {
    fun bindTrack(apiResult : TrackPoko)
}

abstract class DataViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView), ITrackViewHolder

class TrackDataViewHolder(itemView: View) : DataViewHolder(itemView){
    override fun bindTrack(apiResult: TrackPoko) {
        itemView.tv_artist_name.text = apiResult.artistName
        itemView.tv_track_name.text = apiResult.trackName
        itemView.tv_release_date.text = apiResult.releaseData
        itemView.tv_primary_genre_name.text = apiResult.primaryGenreName
        itemView.tv_track_price.text = "$ ${apiResult.trackPrice}"
    }
}