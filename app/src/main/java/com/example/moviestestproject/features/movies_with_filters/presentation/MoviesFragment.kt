package com.example.moviestestproject.features.movies_with_filters.presentation

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import com.example.moviestestproject.databinding.FragmentMoviesBinding
import com.example.moviestestproject.features.movies_with_filters.presentation.adapter.adapter_delegate.genresFiltersAdapterDelegate
import com.example.moviestestproject.features.movies_with_filters.presentation.adapter.adapter_delegate.moviesAdapterDelegate
import com.example.moviestestproject.features.movies_with_filters.presentation.models.UiState
import com.example.moviestestproject.features.movies_with_filters.presentation.mvp.MoviesPresenter
import com.example.moviestestproject.features.movies_with_filters.presentation.mvp.MoviesView
import com.hannesdorfmann.adapterdelegates4.ListDelegationAdapter
import moxy.MvpAppCompatFragment
import moxy.ktx.moxyPresenter

class MoviesFragment : MvpAppCompatFragment(), MoviesView {

    private var _binding: FragmentMoviesBinding? = null
    private val binding get() = _binding!!
    private val adapter = ListDelegationAdapter(
        genresFiltersAdapterDelegate(),
        moviesAdapterDelegate()
    )

    private val moviePresenter by moxyPresenter { MoviesPresenter() }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentMoviesBinding.inflate(inflater)
        return super.onCreateView(inflater, container, savedInstanceState)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initUi()
        moviePresenter.getMovies()
    }

    private fun initUi() {
        binding.recyclerView.adapter = adapter
    }

    override fun setData(uiState: UiState) {
        adapter.items = uiState.moviesWithGenresFiltersList
    }

    override fun showLoading() {
        binding.loadingLayout.visibility = View.VISIBLE
    }

    override fun hideLoading() {
        binding.loadingLayout.visibility = View.GONE
    }

    override fun showError(errorMessage: String) {
        Toast.makeText(context, errorMessage, Toast.LENGTH_SHORT).show()
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

    companion object {
        fun newInstance() = MoviesFragment()
    }
}