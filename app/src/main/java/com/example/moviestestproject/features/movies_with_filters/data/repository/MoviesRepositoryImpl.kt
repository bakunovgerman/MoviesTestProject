package com.example.moviestestproject.features.movies_with_filters.data.repository

import com.example.moviestestproject.core.utils.Result
import com.example.moviestestproject.core.utils.apiRequest
import com.example.moviestestproject.features.movies_with_filters.data.models.MoviesResponse
import com.example.moviestestproject.features.movies_with_filters.data.network.MoviesService
import com.example.moviestestproject.features.movies_with_filters.domain.repository.MoviesRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOn

class MoviesRepositoryImpl(private val moviesService: MoviesService) : MoviesRepository {

    override suspend fun getMovies(): Flow<Result<MoviesResponse>> = flow {
        val result = apiRequest { moviesService.getMovies() }
        emit(result)
    }.flowOn(Dispatchers.IO)
}