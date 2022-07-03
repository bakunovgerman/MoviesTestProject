package com.example.moviestestproject.features.movies_with_filters.presentation.adapter.adapter_delegate

import android.content.res.Configuration
import com.example.moviestestproject.R
import com.example.moviestestproject.databinding.ItemGenreLayoutBinding
import com.example.moviestestproject.databinding.ItemMoviesListLayoutBinding
import com.example.moviestestproject.databinding.ItemTitleSectionLayoutBinding
import com.example.moviestestproject.features.movies_with_filters.presentation.adapter.MoviesAdapter
import com.example.moviestestproject.features.movies_with_filters.presentation.models.*
import com.example.moviestestproject.features.movies_with_filters.presentation.utils.MoviesGridSpacingItemDecoration
import com.hannesdorfmann.adapterdelegates4.dsl.adapterDelegateViewBinding

fun titleSectionAdapterDelegate() =
    adapterDelegateViewBinding<TitleSectionPresentationModel, MoviesWithGenres, ItemTitleSectionLayoutBinding>(
        { layoutInflater, root ->
            ItemTitleSectionLayoutBinding.inflate(
                layoutInflater,
                root,
                false
            )
        }
    ) {

        bind {
            binding.nameTitle.text = item.title
        }
    }

fun genresFiltersAdapterDelegate(clickCallback: (Long, String, Boolean) -> Unit) =
    adapterDelegateViewBinding<GenrePresentationModel, MoviesWithGenres, ItemGenreLayoutBinding>(
        { layoutInflater, root ->
            ItemGenreLayoutBinding.inflate(
                layoutInflater,
                root,
                false
            )
        }
    ) {

        binding.root.setOnClickListener {
            with(item) { clickCallback(id, name, isSelected) }
        }

        bind {
            binding.genreNameTextView.text = item.name
            if (item.isSelected) {
                binding.genreNameTextView.setBackgroundResource(R.drawable.bg_genre_selected)
            } else {
                binding.genreNameTextView.setBackgroundResource(R.drawable.bg_genre)
            }
        }
    }

private const val BOTTOM_SPACE_GRID = 20
fun moviesAdapterDelegate(clickMovieCallback: (MoviePresentationModel) -> Unit) =
    adapterDelegateViewBinding<MovieWrapperPresentationModel, MoviesWithGenres, ItemMoviesListLayoutBinding>(
        { layoutInflater, root ->
            ItemMoviesListLayoutBinding.inflate(
                layoutInflater,
                root,
                false
            ).apply {
                moviesRecyclerView.apply {
                    addItemDecoration(
                        MoviesGridSpacingItemDecoration(
                            bottom = BOTTOM_SPACE_GRID,
                            gridSpanCount = when (resources.configuration.orientation) {
                                Configuration.ORIENTATION_LANDSCAPE -> 4
                                else -> 2
                            }
                        )
                    )
                }
            }
        }
    ) {

        val moviesAdapter = MoviesAdapter(clickMovieCallback = clickMovieCallback)
        binding.moviesRecyclerView.adapter = moviesAdapter

        bind {
            moviesAdapter.setData(item.items)
        }
    }