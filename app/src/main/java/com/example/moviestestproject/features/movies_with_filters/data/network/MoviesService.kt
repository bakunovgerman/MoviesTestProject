package com.example.moviestestproject.features.movies_with_filters.data.network

import com.example.moviestestproject.features.movies_with_filters.data.models.MoviesResponse
import retrofit2.Response
import retrofit2.http.GET

interface MoviesService {

    @GET("films.json")
    suspend fun getMovies(): Response<MoviesResponse>
}