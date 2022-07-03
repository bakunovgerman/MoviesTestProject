package com.example.moviestestproject.di

import com.example.moviestestproject.features.movies_with_filters.domain.usecases.GetGenresListUseCase
import com.example.moviestestproject.features.movies_with_filters.domain.usecases.GetGenresListUseCaseImpl
import com.example.moviestestproject.features.movies_with_filters.domain.usecases.GetMoviesUseCase
import com.example.moviestestproject.features.movies_with_filters.domain.usecases.GetMoviesUseCaseImpl
import dagger.Binds
import dagger.Module

@Module
interface DomainModule {

    @Binds
    fun bindGetMoviesUseCase(impl: GetMoviesUseCaseImpl): GetMoviesUseCase

    @Binds
    fun binGetGenresListUseCase(impl: GetGenresListUseCaseImpl): GetGenresListUseCase
}