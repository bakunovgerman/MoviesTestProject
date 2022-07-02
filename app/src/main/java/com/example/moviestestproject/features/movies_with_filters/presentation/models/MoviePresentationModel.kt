package com.example.moviestestproject.features.movies_with_filters.presentation.models

import com.example.moviestestproject.features.movies_with_filters.data.models.Movie

data class MoviePresentationModel(
    val items: List<Movie>
): MoviesWithGenres