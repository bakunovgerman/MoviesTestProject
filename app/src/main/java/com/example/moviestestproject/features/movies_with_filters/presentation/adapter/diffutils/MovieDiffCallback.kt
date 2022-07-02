package com.example.moviestestproject.features.movies_with_filters.presentation.adapter.diffutils

import androidx.recyclerview.widget.DiffUtil
import com.example.moviestestproject.features.movies_with_filters.data.models.Movie

class MovieDiffCallback: DiffUtil.ItemCallback<Movie>() {

    override fun areItemsTheSame(oldItem: Movie, newItem: Movie): Boolean {
        return oldItem.id == newItem.id
    }

    override fun areContentsTheSame(oldItem: Movie, newItem: Movie): Boolean {
        return oldItem == newItem
    }
}