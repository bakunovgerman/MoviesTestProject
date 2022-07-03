package com.example.moviestestproject.features.movies_with_filters.domain.usecases

import com.example.moviestestproject.features.movies_with_filters.domain.models.GenreDomain
import com.example.moviestestproject.features.movies_with_filters.domain.models.MovieDomain
import javax.inject.Inject

interface GetGenresListUseCase {
    operator fun invoke(moviesList: List<MovieDomain>): List<GenreDomain>
}

class GetGenresListUseCaseImpl @Inject constructor() : GetGenresListUseCase {

    override operator fun invoke(moviesList: List<MovieDomain>): List<GenreDomain> {
        var id = 1L
        val genresList = mutableListOf<GenreDomain>()
        moviesList.forEach { movie ->
            movie.genres?.forEach { genreName ->
                if (!genresList.any { it.name == genreName }) {
                    val genre = GenreDomain(id = id++, name = genreName)
                    genresList.add(genre)
                }
            }

        }
        return genresList
    }
}