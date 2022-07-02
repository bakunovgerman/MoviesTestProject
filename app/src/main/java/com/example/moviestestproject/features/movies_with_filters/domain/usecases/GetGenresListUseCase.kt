package com.example.moviestestproject.features.movies_with_filters.domain.usecases

import com.example.moviestestproject.features.movies_with_filters.data.models.Movie
import com.example.moviestestproject.features.movies_with_filters.domain.models.GenreDomain

class GetGenresListUseCase {

    operator fun invoke(moviesList: List<Movie>): List<GenreDomain> {
        var id = 1
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