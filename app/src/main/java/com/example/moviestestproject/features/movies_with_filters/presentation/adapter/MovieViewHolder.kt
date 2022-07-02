package com.example.moviestestproject.features.movies_with_filters.presentation.adapter

import android.view.View
import androidx.recyclerview.widget.RecyclerView
import coil.load
import com.example.moviestestproject.databinding.ItemMovieLayoutBinding
import com.example.moviestestproject.features.movies_with_filters.data.models.Movie

class MovieViewHolder(view: View) : RecyclerView.ViewHolder(view) {

    private val binding = ItemMovieLayoutBinding.bind(view)

    fun bind(item: Movie) = with(binding) {
        moviePosterImageView.load(item.imageUrl)
        movieTitleTextView.text = item.localizedName
    }
}