package com.example.moviestestproject.features.movies_with_filters.domain.mappers

import com.example.moviestestproject.features.movies_with_filters.data.models.Movie
import com.example.moviestestproject.features.movies_with_filters.domain.models.MovieDomain

fun List<Movie>.mapToDomain() = this.map {
    MovieDomain(
        id = it.id,
        description = it.description,
        genres = it.genres,
        imageUrl = it.imageUrl,
        localizedName = it.localizedName,
        name = it.name,
        rating = it.rating,
        year = it.year
    )
}