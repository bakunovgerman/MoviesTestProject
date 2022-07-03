package com.example.moviestestproject.features.movies_with_filters.presentation.models

data class MovieWrapperPresentationModel(
    val items: List<MoviePresentationModel>
) : MoviesWithGenres {
    override val idItem: Long = items.hashCode().toLong()
}