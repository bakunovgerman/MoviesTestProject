package com.example.moviestestproject.features.movies_with_filters.data.repository

import android.util.Log
import com.example.moviestestproject.App.Companion.TAG
import com.example.moviestestproject.core.utils.Result
import com.example.moviestestproject.core.utils.apiRequest
import com.example.moviestestproject.features.movies_with_filters.data.models.MoviesResponse
import com.example.moviestestproject.features.movies_with_filters.data.network.MoviesService
import com.example.moviestestproject.features.movies_with_filters.domain.repository.MoviesRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOn
import javax.inject.Inject

class MoviesRepositoryImpl @Inject constructor(private val moviesService: MoviesService) :
    MoviesRepository {

    override suspend fun getMovies(): Flow<Result<MoviesResponse>> = flow {
        val result = apiRequest { moviesService.getMovies() }
        emit(result)
    }.catch { e ->
        Log.d(TAG, e.message.toString())
        emit(Result.Error(message = e.message.toString()))
    }.flowOn(Dispatchers.IO)
}