package com.example.moviestestproject.features.movies_with_filters.presentation.utils

import android.app.Activity
import android.graphics.Rect
import android.util.DisplayMetrics
import android.util.Log
import android.view.View
import androidx.recyclerview.widget.RecyclerView
import com.example.moviestestproject.core.utils.dpToPx

class MoviesGridSpacingItemDecoration(private val bottom: Int, private val gridSpanCount: Int) :
    RecyclerView.ItemDecoration() {

    override fun getItemOffsets(
        outRect: Rect, view: View, parent: RecyclerView, state: RecyclerView.State
    ) {
        val position: Int = parent.getChildAdapterPosition(view)

        val displayMetrics = DisplayMetrics()
        (view.context as Activity).windowManager.defaultDisplay.getMetrics(displayMetrics)
        val width = displayMetrics.widthPixels

        if (gridSpanCount == 4) {
            if((position+1) % 4 != 0) {
                outRect.right = getMargin(width)
            }
        } else if (position % 2 != 0) {
            outRect.left = getMargin(width)
        }

        outRect.bottom = dpToPx(bottom)
    }

    private fun getMargin(width: Int): Int = (width - dpToPx(40)) / gridSpanCount - dpToPx(150)
}
