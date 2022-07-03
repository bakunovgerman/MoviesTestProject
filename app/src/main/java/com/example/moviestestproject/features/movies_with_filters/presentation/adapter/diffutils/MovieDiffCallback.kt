package com.example.moviestestproject.features.movies_with_filters.presentation.adapter.diffutils

import androidx.recyclerview.widget.DiffUtil
import com.example.moviestestproject.features.movies_with_filters.presentation.models.MoviePresentationModel

class MovieDiffCallback : DiffUtil.ItemCallback<MoviePresentationModel>() {

    override fun areItemsTheSame(
        oldItem: MoviePresentationModel,
        newItem: MoviePresentationModel
    ): Boolean {
        return oldItem.id == newItem.id
    }

    override fun areContentsTheSame(
        oldItem: MoviePresentationModel,
        newItem: MoviePresentationModel
    ): Boolean {
        return oldItem == newItem
    }
}