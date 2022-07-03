package com.example.moviestestproject.features.movies_with_filters.presentation.models

data class GenrePresentationModel(
    val id: Long,
    val name: String,
    val isSelected: Boolean = false
) : MoviesWithGenres {
    override val idItem: Long = id
}
