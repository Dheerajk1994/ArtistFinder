package com.example.artistfinder.ui.searchscreen

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.fragment.app.FragmentManager
import androidx.lifecycle.Observer
import com.example.artistfinder.R
import com.example.artistfinder.ui.TrackRVAdapter
import com.example.artistfinder.ui.tracks_fragment.TracksFragment
import com.example.artistfinder.utils.CustomApplication
import com.example.artistfinder.viewmodel.MainActivityViewModel
import kotlinx.android.synthetic.main.activity_main.*
import javax.inject.Inject

class MainActivity : AppCompatActivity() {

    //TODO inject viewmodel
    @Inject
    lateinit var viewModel: MainActivityViewModel


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        CustomApplication.getComponent().inject(this)

        //viewModel = ViewModelProvider(this, ViewModelProvider.NewInstanceFactory()).get(MainActivityViewModel::class.java)

        viewModel.trackData.observe(this, Observer {
            val fragment = TracksFragment(it)
            supportFragmentManager
                .beginTransaction()
                .add(R.id.fl_tracks_fragment, fragment)
                .addToBackStack(null)
                .commit()
        })

        viewModel.loadingScreenVisibility.observe(this, Observer {
            if (it == View.VISIBLE) {
                fl_loading.visibility = View.VISIBLE
            } else {
                fl_loading.visibility = View.INVISIBLE
            }
        })

        setupSearchButton()
    }

    //Listen into the user clicking the search button
    //Could be improved with data-binding and send the search directly to the ViewModel
    private fun setupSearchButton() {
        btn_search_artist.setOnClickListener {
            val nameToSearch = et_artist_name.text.toString()
            if (nameToSearch.isNotBlank()) {
                viewModel.searchArtist(nameToSearch)
            } else {
                Toast.makeText(
                    this,
                    "Please enter the name of the artist you want to search",
                    Toast.LENGTH_SHORT
                ).show()
            }
        }
    }
}