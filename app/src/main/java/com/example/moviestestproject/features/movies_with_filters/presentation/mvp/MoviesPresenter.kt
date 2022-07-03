package com.example.moviestestproject.features.movies_with_filters.presentation.mvp

import android.content.Context
import com.example.moviestestproject.R
import com.example.moviestestproject.features.movies_with_filters.domain.models.MoviesResultDomain
import com.example.moviestestproject.features.movies_with_filters.domain.usecases.GetGenresListUseCase
import com.example.moviestestproject.features.movies_with_filters.domain.usecases.GetMoviesUseCase
import com.example.moviestestproject.features.movies_with_filters.presentation.mappers.mapToPresentation
import com.example.moviestestproject.features.movies_with_filters.presentation.models.*
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import moxy.InjectViewState
import moxy.MvpPresenter
import moxy.presenterScope
import javax.inject.Inject

@InjectViewState
class MoviesPresenter @Inject constructor(
    private val context: Context,
    private val getMoviesUseCase: GetMoviesUseCase,
    private val getGenresListUseCase: GetGenresListUseCase
) : MvpPresenter<MoviesView>() {

    private var moviesList: List<MoviePresentationModel> = listOf()
    private var genresList: List<GenrePresentationModel> = listOf()

    override fun onFirstViewAttach() {
        super.onFirstViewAttach()
        getMovies()
    }

    fun getMovies() {
        viewState.showLoading()
        presenterScope.launch(Dispatchers.IO) {
            getMoviesUseCase().collect {
                when (it) {
                    is MoviesResultDomain.Success -> {
                        moviesList = it.data.mapToPresentation()
                        genresList = getGenresListUseCase(it.data).mapToPresentation()
                        withContext(Dispatchers.Main) {
                            setData(moviesList, genresList)
                            viewState.hideLoading()
                        }
                    }
                    is MoviesResultDomain.Error -> {
                        withContext(Dispatchers.Main) {
                            viewState.showError(it.errorMessage)
                        }
                    }
                }
            }
        }
    }

    private fun setData(
        movies: List<MoviePresentationModel>,
        genres: List<GenrePresentationModel>
    ) {
        viewState.setData(
            UiState(
                content = mutableListOf<MoviesWithGenres>().apply {
                    add(
                        TitleSectionPresentationModel(title = context.getString(R.string.genres))
                    )
                    addAll(genres)
                    add(
                        TitleSectionPresentationModel(title = context.getString(R.string.movies))
                    )
                    add(MovieWrapperPresentationModel(items = movies))
                }
            )
        )
    }

    fun clickGenreFilter(idGenre: Long, nameGenre: String, isSelected: Boolean) {
        updateSelectedGenres(idGenre = idGenre)
        // если кликнули на жанр который был выбран ранее => фильтрацию убираем
        val movies = if (isSelected) {
            moviesList
        } else {
            moviesList.filter { it.genres?.contains(nameGenre) ?: false }
        }
        setData(movies = movies, genres = genresList)
    }

    private fun updateSelectedGenres(idGenre: Long) {
        genresList = genresList.map { genre ->
            if (genre.id == idGenre) genre.copy(isSelected = !genre.isSelected)
            else genre.copy(isSelected = false)
        }
    }
}