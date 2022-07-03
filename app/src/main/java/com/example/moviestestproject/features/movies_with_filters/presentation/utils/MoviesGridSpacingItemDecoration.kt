package com.example.moviestestproject.features.movies_with_filters.presentation.utils

import android.app.Activity
import android.content.res.Resources
import android.graphics.Rect
import android.util.DisplayMetrics
import android.util.Log
import android.view.View
import androidx.recyclerview.widget.RecyclerView
import com.example.moviestestproject.core.utils.dpToPx

class MoviesGridSpacingItemDecoration(private val bottom: Int) : RecyclerView.ItemDecoration() {

    override fun getItemOffsets(
        outRect: Rect, view: View, parent: RecyclerView, state: RecyclerView.State
    ) {
        val position: Int = parent.getChildAdapterPosition(view)

        val displayMetrics = DisplayMetrics()
        (view.context as Activity).windowManager.defaultDisplay.getMetrics(displayMetrics)
        val width = displayMetrics.widthPixels

        if (position % 2 != 0) {
            outRect.left = (width - dpToPx(40)) / 2 - dpToPx(150)
        }

        outRect.bottom = dpToPx(bottom)
    }
}
