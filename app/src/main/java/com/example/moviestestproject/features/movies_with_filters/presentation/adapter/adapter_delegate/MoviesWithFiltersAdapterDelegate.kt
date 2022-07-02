package com.example.moviestestproject.features.movies_with_filters.presentation.adapter.adapter_delegate

import com.example.moviestestproject.databinding.ItemGenresFiltersLayoutBinding
import com.example.moviestestproject.databinding.ItemMoviesListLayoutBinding
import com.example.moviestestproject.features.movies_with_filters.presentation.adapter.GenresAdapter
import com.example.moviestestproject.features.movies_with_filters.presentation.adapter.MoviesAdapter
import com.example.moviestestproject.features.movies_with_filters.presentation.models.GenrePresentationModel
import com.example.moviestestproject.features.movies_with_filters.presentation.models.MoviePresentationModel
import com.example.moviestestproject.features.movies_with_filters.presentation.models.MoviesWithGenres
import com.hannesdorfmann.adapterdelegates4.dsl.adapterDelegateViewBinding

fun genresFiltersAdapterDelegate() =
    adapterDelegateViewBinding<GenrePresentationModel, MoviesWithGenres, ItemGenresFiltersLayoutBinding>(
        { layoutInflater, root ->
            ItemGenresFiltersLayoutBinding.inflate(
                layoutInflater,
                root,
                false
            )
        }
    ) {

        val adapter = GenresAdapter()
        binding.genresFiltersRecyclerView.adapter = adapter

        bind {
            adapter.setData(item.items)
        }
    }

fun moviesAdapterDelegate() =
    adapterDelegateViewBinding<MoviePresentationModel, MoviesWithGenres, ItemMoviesListLayoutBinding>(
        { layoutInflater, root ->
            ItemMoviesListLayoutBinding.inflate(
                layoutInflater,
                root,
                false
            )
        }
    ) {

        val adapter = MoviesAdapter()
        binding.moviesRecyclerView.adapter = adapter

        bind {
            adapter.setData(item.items)
        }
    }