package com.example.moviestestproject.features.movies_with_filters.presentation.mappers

import com.example.moviestestproject.features.movies_with_filters.domain.models.GenreDomain
import com.example.moviestestproject.features.movies_with_filters.domain.models.MovieDomain
import com.example.moviestestproject.features.movies_with_filters.presentation.models.GenrePresentationModel
import com.example.moviestestproject.features.movies_with_filters.presentation.models.MoviePresentationModel

fun List<GenreDomain>.mapToPresentation() = this.map {
    GenrePresentationModel(
        id = it.id,
        name = it.name
    )
}

@JvmName("mapToPresentationMovieDomain")
fun List<MovieDomain>.mapToPresentation() = this.map {
    MoviePresentationModel(
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