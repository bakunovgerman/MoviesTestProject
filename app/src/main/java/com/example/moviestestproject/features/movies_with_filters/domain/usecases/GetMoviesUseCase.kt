package com.example.moviestestproject.features.movies_with_filters.domain.usecases

import com.example.moviestestproject.core.utils.Result
import com.example.moviestestproject.features.movies_with_filters.domain.mappers.mapToDomain
import com.example.moviestestproject.features.movies_with_filters.domain.models.MoviesResultDomain
import com.example.moviestestproject.features.movies_with_filters.domain.repository.MoviesRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map
import javax.inject.Inject

interface GetMoviesUseCase {
    suspend operator fun invoke(): Flow<MoviesResultDomain>
}

class GetMoviesUseCaseImpl @Inject constructor(private val moviesRepository: MoviesRepository) :
    GetMoviesUseCase {

    override suspend operator fun invoke(): Flow<MoviesResultDomain> =
        moviesRepository.getMovies().map { result ->
            when (result) {
                is Result.Success -> MoviesResultDomain.Success(
                    data = result.value?.movies?.mapToDomain()?.sortedBy { it.localizedName }
                        ?: emptyList()
                )
                is Result.Error -> MoviesResultDomain.Error(errorMessage = result.message)
            }
        }
}