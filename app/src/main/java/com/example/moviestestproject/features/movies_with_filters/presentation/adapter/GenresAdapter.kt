package com.example.moviestestproject.features.movies_with_filters.presentation.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.AsyncListDiffer
import androidx.recyclerview.widget.RecyclerView
import com.example.moviestestproject.R
import com.example.moviestestproject.features.movies_with_filters.domain.models.GenreDomain
import com.example.moviestestproject.features.movies_with_filters.presentation.adapter.diffutils.GenreDiffCallback

class GenresAdapter: RecyclerView.Adapter<GenreViewHolder>() {

    private val differ = AsyncListDiffer(this, GenreDiffCallback())

    fun setData(items: List<GenreDomain>) {
        differ.submitList(items)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): GenreViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        return GenreViewHolder(inflater.inflate(R.layout.item_genre_layout, parent, false))
    }

    override fun onBindViewHolder(holder: GenreViewHolder, position: Int) {
        holder.bind(differ.currentList[position])
    }

    override fun getItemCount(): Int = differ.currentList.size
}