package com.example.moviestestproject.features.movies_with_filters.presentation.models

data class TitleSectionPresentationModel(
    val title: String
): MoviesWithGenres {
    override val idItem: Long = title.hashCode().toLong()
}
