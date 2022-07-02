package com.example.moviestestproject.features.movies_with_filters.presentation.models

import com.example.moviestestproject.features.movies_with_filters.domain.models.GenreDomain

data class GenrePresentationModel(val items: List<GenreDomain>): MoviesWithGenres
