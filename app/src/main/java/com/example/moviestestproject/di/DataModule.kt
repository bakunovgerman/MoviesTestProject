package com.example.moviestestproject.di

import com.example.moviestestproject.BuildConfig
import com.example.moviestestproject.core.utils.addJsonConverter
import com.example.moviestestproject.core.utils.setClient
import com.example.moviestestproject.features.movies_with_filters.data.network.MoviesService
import com.example.moviestestproject.features.movies_with_filters.data.repository.MoviesRepositoryImpl
import com.example.moviestestproject.features.movies_with_filters.domain.repository.MoviesRepository
import dagger.Binds
import dagger.Module
import dagger.Provides
import retrofit2.Retrofit
import javax.inject.Singleton

@Module(includes = [DataModule.BindsDataModule::class])
class DataModule {

    @Singleton
    @Provides
    fun provideRetrofit(): Retrofit {
        return Retrofit.Builder()
            .baseUrl(BuildConfig.BASE_URL)
            .setClient()
            .addJsonConverter()
            .build()
    }

    @Provides
    fun provideMoviesService(retrofit: Retrofit): MoviesService {
        return retrofit.create(MoviesService::class.java)
    }

    @Module
    interface BindsDataModule {

        @Binds
        fun bindMoviesRepository(impl: MoviesRepositoryImpl): MoviesRepository
    }
}