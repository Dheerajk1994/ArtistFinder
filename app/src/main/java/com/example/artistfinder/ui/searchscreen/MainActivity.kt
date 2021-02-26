package com.example.artistfinder.ui.searchscreen

import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.inputmethod.InputMethodManager
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.Observer
import com.example.artistfinder.R
import com.example.artistfinder.databinding.ActivityMainBinding
import com.example.artistfinder.ui.tracks_fragment.TracksFragment
import com.example.artistfinder.utils.CustomApplication
import com.example.artistfinder.viewmodel.MainActivityViewModel
import javax.inject.Inject

class MainActivity : AppCompatActivity() {

    @Inject
    lateinit var viewModel: MainActivityViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        CustomApplication.getComponent().inject(this)

        val binding = DataBindingUtil.setContentView<ActivityMainBinding>(this, R.layout.activity_main)
        binding.mainActivityViewModel = viewModel
        binding.artistName = binding.etArtistName

        viewModel.trackData.observe(this, Observer {
            val fragment = TracksFragment(it)
            supportFragmentManager
                .beginTransaction()
                .add(R.id.fl_tracks_fragment, fragment)
                .addToBackStack(null)
                .commit()
        })

        viewModel.hideLoadingScreen()
    }

    private fun closeKeyBoard(){
        val view = this.currentFocus
        if(view != null){
            val inputManager = getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager
            inputManager.hideSoftInputFromWindow(view.windowToken, 0)
        }
    }
}