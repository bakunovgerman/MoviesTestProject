package com.example.moviestestproject.features.movies_with_filters.domain.repository

import com.example.moviestestproject.core.utils.Result
import com.example.moviestestproject.features.movies_with_filters.data.models.MoviesResponse
import kotlinx.coroutines.flow.Flow

interface MoviesRepository {

    suspend fun getMovies(): Flow<Result<MoviesResponse>>
}