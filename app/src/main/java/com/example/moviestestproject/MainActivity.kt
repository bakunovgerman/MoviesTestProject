package com.example.moviestestproject

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import com.example.moviestestproject.features.movies_with_filters.presentation.MoviesFragment

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        navigateMovieWithFiltersFragment()
    }

    private fun navigateMovieWithFiltersFragment() {
//        supportFragmentManager.beginTransaction()
//            .replace(R.id.fragmentContainerView, MoviesFragment.newInstance() as Fragment)
//            .commit()
    }
}