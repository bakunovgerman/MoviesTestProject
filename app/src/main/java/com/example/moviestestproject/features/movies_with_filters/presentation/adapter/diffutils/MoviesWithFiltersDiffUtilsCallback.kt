package com.example.moviestestproject.features.movies_with_filters.presentation.adapter.diffutils

import androidx.recyclerview.widget.DiffUtil
import com.example.moviestestproject.features.movies_with_filters.presentation.models.MoviesWithGenres

class MoviesWithFiltersDiffUtilsCallback : DiffUtil.ItemCallback<MoviesWithGenres>() {
    override fun areItemsTheSame(oldItem: MoviesWithGenres, newItem: MoviesWithGenres): Boolean {
        return oldItem.idItem == oldItem.idItem
    }

    override fun areContentsTheSame(oldItem: MoviesWithGenres, newItem: MoviesWithGenres): Boolean {
        return oldItem.equals(newItem)
    }
}