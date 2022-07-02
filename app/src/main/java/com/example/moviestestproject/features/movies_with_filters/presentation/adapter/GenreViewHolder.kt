package com.example.moviestestproject.features.movies_with_filters.presentation.adapter

import android.view.View
import androidx.recyclerview.widget.RecyclerView
import com.example.moviestestproject.databinding.ItemGenreLayoutBinding
import com.example.moviestestproject.features.movies_with_filters.domain.models.GenreDomain

class GenreViewHolder(view: View) : RecyclerView.ViewHolder(view) {

    private val binding = ItemGenreLayoutBinding.bind(view)

    fun bind(item: GenreDomain) = with(binding) {
        genreNameTextView.text = item.name
    }
}