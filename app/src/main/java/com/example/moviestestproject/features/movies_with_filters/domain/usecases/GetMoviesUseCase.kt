package com.example.moviestestproject.features.movies_with_filters.domain.usecases

import com.example.moviestestproject.core.utils.Result
import com.example.moviestestproject.features.movies_with_filters.data.models.MoviesResponse
import com.example.moviestestproject.features.movies_with_filters.domain.repository.MoviesRepository
import kotlinx.coroutines.flow.Flow

class GetMoviesUseCase(private val moviesRepository: MoviesRepository) {

    suspend operator fun invoke(): Flow<Result<MoviesResponse>> = moviesRepository.getMovies()
}