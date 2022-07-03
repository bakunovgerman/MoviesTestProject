package com.example.moviestestproject.di

import android.content.Context
import com.example.moviestestproject.features.movies_with_filters.presentation.MoviesFragment
import dagger.BindsInstance
import dagger.Component
import javax.inject.Singleton

@Singleton
@Component(modules = [DataModule::class, DomainModule::class])
interface AppComponent {

    fun inject(moviesFragment: MoviesFragment)

    @Component.Factory
    interface Factory {
        fun create(@BindsInstance context: Context): AppComponent
    }
}