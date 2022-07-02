package com.example.moviestestproject.features.movies_with_filters.data.models

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class MoviesResponse(
    @SerialName("films")
    val movies: List<Movie>?
)