package com.example.moviestestproject.features.movies_with_filters.presentation.utils

import android.graphics.Rect
import android.view.View
import androidx.recyclerview.widget.RecyclerView
import com.example.moviestestproject.core.utils.dpToPx

class MoviesWithFiltersItemDecorator(private val bottomSpacer: Int) : RecyclerView.ItemDecoration() {

    override fun getItemOffsets(
        outRect: Rect, view: View, parent: RecyclerView, state: RecyclerView.State
    ) {
        outRect.bottom = dpToPx(bottomSpacer)
    }
}