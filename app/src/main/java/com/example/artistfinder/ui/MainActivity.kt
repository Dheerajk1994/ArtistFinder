package com.example.artistfinder.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.example.artistfinder.R
import com.example.artistfinder.utils.CustomApplication
import com.example.artistfinder.viewmodel.MainActivityViewModel
import kotlinx.android.synthetic.main.activity_main.*
import javax.inject.Inject

class MainActivity : AppCompatActivity() {

    //TODO inject viewmodel
    @Inject
    lateinit var viewModel : MainActivityViewModel

    @Inject
    lateinit var trackRVAdapter: TrackRVAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        CustomApplication.getComponent().inject(this)

        //viewModel = ViewModelProvider(this, ViewModelProvider.NewInstanceFactory()).get(MainActivityViewModel::class.java)

        viewModel.trackData.observe(this, Observer {
            trackRVAdapter.setData(it)
        })

        setupSearchButton()
    }

    //Listen into the user clicking the search button
    //Could be improved with data-binding and send the search directly to the ViewModel
    private fun setupSearchButton(){
        btn_search_artist.setOnClickListener{
            val nameToSearch = et_artist_name.text.toString()
            if(nameToSearch.isNotBlank()){
                viewModel.searchArtist(nameToSearch)
            }
            else{
                Toast.makeText(this, "Please enter the name of the artist you want to search", Toast.LENGTH_SHORT).show()
            }
        }
    }
}