package com.example.moviestestproject.features.movies_with_filters.data.network

import com.example.moviestestproject.core.utils.addJsonConverter
import com.example.moviestestproject.core.utils.setClient
import com.example.moviestestproject.features.movies_with_filters.data.models.MoviesResponse
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.http.GET

interface MoviesService {

    @GET("films.json")
    suspend fun getMovies(): Response<MoviesResponse>

    companion object {
        private const val BASE_URL = "https://api.themoviedb.org/3/"

        fun create(): MoviesService {
            return Retrofit.Builder()
                .baseUrl(BASE_URL)
                .setClient()
                .addJsonConverter()
                .build()
                .create(MoviesService::class.java)
        }
    }
}