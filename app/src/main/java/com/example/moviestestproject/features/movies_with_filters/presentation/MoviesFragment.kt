package com.example.moviestestproject.features.movies_with_filters.presentation

import android.content.Context
import android.os.Bundle
import android.view.View
import by.kirich1409.viewbindingdelegate.viewBinding
import com.example.moviestestproject.R
import com.example.moviestestproject.databinding.FragmentMoviesBinding
import com.example.moviestestproject.features.movie_detail.presentation.MovieDetailFragment
import com.example.moviestestproject.features.movie_detail.presentation.MovieDetailFragment.Companion.MOVIE_DETAIL_FRAGMENT
import com.example.moviestestproject.features.movies_with_filters.presentation.adapter.adapter_delegate.MoviesWithFiltersListDelegationAdapter
import com.example.moviestestproject.features.movies_with_filters.presentation.adapter.adapter_delegate.genresFiltersAdapterDelegate
import com.example.moviestestproject.features.movies_with_filters.presentation.adapter.adapter_delegate.moviesAdapterDelegate
import com.example.moviestestproject.features.movies_with_filters.presentation.adapter.adapter_delegate.titleSectionAdapterDelegate
import com.example.moviestestproject.features.movies_with_filters.presentation.models.MoviePresentationModel
import com.example.moviestestproject.features.movies_with_filters.presentation.models.UiState
import com.example.moviestestproject.features.movies_with_filters.presentation.mvp.MoviesPresenter
import com.example.moviestestproject.features.movies_with_filters.presentation.mvp.MoviesView
import com.example.moviestestproject.getAppComponent
import moxy.MvpAppCompatFragment
import moxy.ktx.moxyPresenter
import javax.inject.Inject
import javax.inject.Provider

class MoviesFragment : MvpAppCompatFragment(R.layout.fragment_movies), MoviesView {

    private val binding: FragmentMoviesBinding by viewBinding()
    private val adapter = MoviesWithFiltersListDelegationAdapter(
        titleSectionAdapterDelegate(),
        genresFiltersAdapterDelegate { id, name, isSelected ->
            moviePresenter.clickGenreFilter(idGenre = id, nameGenre = name, isSelected = isSelected)
        },
        moviesAdapterDelegate() { movie ->
            navigateToMovieDetail(movie)
        }
    )

    @Inject
    lateinit var presenterProvider: Provider<MoviesPresenter>
    private val moviePresenter by moxyPresenter { presenterProvider.get() }

    override fun onAttach(context: Context) {
        getAppComponent().inject(this)
        super.onAttach(context)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initUi()
    }

    private fun initUi() {
        binding.recyclerView.adapter = adapter
        binding.tryButton.setOnClickListener {
            binding.errorLayout.visibility = View.GONE
            moviePresenter.getMovies()
        }
    }

    override fun setData(uiState: UiState) {
        adapter.items = uiState.content
    }

    override fun showLoading() {
        binding.loadingLayout.visibility = View.VISIBLE
    }

    override fun hideLoading() {
        binding.loadingLayout.visibility = View.GONE
    }

    override fun showError(errorMessage: String) {
        binding.errorLayout.visibility = View.VISIBLE
    }

    private fun navigateToMovieDetail(movie: MoviePresentationModel) {
        parentFragmentManager.beginTransaction()
            .add(R.id.fragmentContainerView, MovieDetailFragment.newInstance(movieDetail = movie))
            .addToBackStack(MOVIE_DETAIL_FRAGMENT)
            .commit()
    }

    companion object {
        fun newInstance() = MoviesFragment()
    }
}