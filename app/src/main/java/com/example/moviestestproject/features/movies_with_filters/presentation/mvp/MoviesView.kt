package com.example.moviestestproject.features.movies_with_filters.presentation.mvp

import com.example.moviestestproject.features.movies_with_filters.presentation.models.UiState
import moxy.MvpView
import moxy.viewstate.strategy.AddToEndSingleStrategy
import moxy.viewstate.strategy.StateStrategyType

@StateStrategyType(value = AddToEndSingleStrategy::class)
interface MoviesView : MvpView {

    fun showLoading()
    fun hideLoading()
    fun showError(errorMessage: String)
    fun setData(uiState: UiState)
}