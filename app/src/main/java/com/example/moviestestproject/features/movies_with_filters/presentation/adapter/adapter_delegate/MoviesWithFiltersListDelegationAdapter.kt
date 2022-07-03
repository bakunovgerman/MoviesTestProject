package com.example.moviestestproject.features.movies_with_filters.presentation.adapter.adapter_delegate

import com.example.moviestestproject.features.movies_with_filters.presentation.adapter.diffutils.MoviesWithFiltersDiffUtilsCallback
import com.example.moviestestproject.features.movies_with_filters.presentation.models.MoviesWithGenres
import com.hannesdorfmann.adapterdelegates4.AdapterDelegate
import com.hannesdorfmann.adapterdelegates4.AsyncListDifferDelegationAdapter

class MoviesWithFiltersListDelegationAdapter(vararg adapterDelegate: AdapterDelegate<List<MoviesWithGenres>>) :
    AsyncListDifferDelegationAdapter<MoviesWithGenres>(
        MoviesWithFiltersDiffUtilsCallback(),
        *adapterDelegate
    )