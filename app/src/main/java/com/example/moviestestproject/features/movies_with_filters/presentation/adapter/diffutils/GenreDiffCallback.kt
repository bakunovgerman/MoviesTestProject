package com.example.moviestestproject.features.movies_with_filters.presentation.adapter.diffutils

import androidx.recyclerview.widget.DiffUtil
import com.example.moviestestproject.features.movies_with_filters.domain.models.GenreDomain

class GenreDiffCallback: DiffUtil.ItemCallback<GenreDomain>() {

    override fun areItemsTheSame(oldItem: GenreDomain, newItem: GenreDomain): Boolean {
        return oldItem.id == newItem.id
    }

    override fun areContentsTheSame(oldItem: GenreDomain, newItem: GenreDomain): Boolean {
        return oldItem == newItem
    }
}