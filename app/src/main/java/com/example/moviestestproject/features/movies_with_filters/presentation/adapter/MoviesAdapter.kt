package com.example.moviestestproject.features.movies_with_filters.presentation.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.AsyncListDiffer
import androidx.recyclerview.widget.RecyclerView
import com.example.moviestestproject.R
import com.example.moviestestproject.features.movies_with_filters.data.models.Movie
import com.example.moviestestproject.features.movies_with_filters.presentation.adapter.diffutils.MovieDiffCallback

class MoviesAdapter: RecyclerView.Adapter<MovieViewHolder>() {

    private val differ = AsyncListDiffer(this, MovieDiffCallback())

    fun setData(items: List<Movie>) {
        differ.submitList(items)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MovieViewHolder {
        val inflate = LayoutInflater.from(parent.context)
        return MovieViewHolder(inflate.inflate(R.layout.item_movie_layout, parent, false))
    }

    override fun onBindViewHolder(holder: MovieViewHolder, position: Int) {
        holder.bind(differ.currentList[position])
    }

    override fun getItemCount(): Int = differ.currentList.size
}