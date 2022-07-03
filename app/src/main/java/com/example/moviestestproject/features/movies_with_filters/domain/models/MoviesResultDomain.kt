package com.example.moviestestproject.features.movies_with_filters.domain.models

sealed class MoviesResultDomain {
    class Success(val data: List<MovieDomain>) : MoviesResultDomain()
    class Error(val errorMessage: String) : MoviesResultDomain()
}