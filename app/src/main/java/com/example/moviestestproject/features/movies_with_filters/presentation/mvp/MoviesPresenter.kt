package com.example.moviestestproject.features.movies_with_filters.presentation.mvp

import com.example.moviestestproject.core.base.BasePresenter
import com.example.moviestestproject.core.utils.Result
import com.example.moviestestproject.features.movies_with_filters.data.network.MoviesService
import com.example.moviestestproject.features.movies_with_filters.data.repository.MoviesRepositoryImpl
import com.example.moviestestproject.features.movies_with_filters.domain.usecases.GetGenresListUseCase
import com.example.moviestestproject.features.movies_with_filters.domain.usecases.GetMoviesUseCase
import com.example.moviestestproject.features.movies_with_filters.presentation.models.GenrePresentationModel
import com.example.moviestestproject.features.movies_with_filters.presentation.models.MoviePresentationModel
import com.example.moviestestproject.features.movies_with_filters.presentation.models.UiState
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import moxy.InjectViewState

@InjectViewState()
class MoviesPresenter : BasePresenter<MoviesView>() {

    private val getMoviesUseCase = GetMoviesUseCase(MoviesRepositoryImpl(MoviesService.create()))
    private val getGenresListUseCase = GetGenresListUseCase()

    fun getMovies() {
        coroutineScope.launch {
            getMoviesUseCase().collect {
                when (it) {
                    is Result.Success -> {
                        val moviesList = it.value?.movies ?: emptyList()
                        val genresFiltersList = getGenresListUseCase(moviesList)
                        withContext(Dispatchers.Main) {
                            viewState.setData(
                                UiState(
                                    listOf(
                                        GenrePresentationModel(items = genresFiltersList),
                                        MoviePresentationModel(items = moviesList)
                                    )
                                )
                            )
                        }
                    }
                    is Result.Error -> {
                        viewState.showError(it.message)
                    }
                }
            }
        }
    }
}