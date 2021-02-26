package com.example.artistfinder.ui.tracks_fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.artistfinder.R
import com.example.artistfinder.model.result.TrackPoko
import com.example.artistfinder.ui.TrackRVAdapter
import com.example.artistfinder.utils.CustomApplication
import kotlinx.android.synthetic.main.fragment_tracks.*
import javax.inject.Inject

class TracksFragment(private val trackData : MutableList<TrackPoko>) : Fragment() {

    @Inject
    lateinit var trackRVAdapter: TrackRVAdapter

    @Inject
    lateinit var layoutManager : LinearLayoutManager

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        CustomApplication.getComponent().inject(this)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_tracks, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        rv_tracks.layoutManager = layoutManager
        rv_tracks.adapter = trackRVAdapter

        trackRVAdapter.setData(trackData)
    }
}