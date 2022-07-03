package com.example.moviestestproject.features.movies_with_filters.presentation.adapter

import android.view.View
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.moviestestproject.R
import com.example.moviestestproject.databinding.ItemMovieLayoutBinding
import com.example.moviestestproject.features.movies_with_filters.presentation.models.MoviePresentationModel

class MovieViewHolder(private val view: View) : RecyclerView.ViewHolder(view) {

    private val binding = ItemMovieLayoutBinding.bind(view)

    fun bind(item: MoviePresentationModel) = with(binding) {
        if (item.imageUrl != null) {
            imageNotFoundOrError.visibility = View.INVISIBLE
            Glide.with(view.context).load(item.imageUrl).error(R.drawable.ic_error).into(moviePosterImageView)
        } else {
            imageNotFoundOrError.visibility = View.VISIBLE
            imageNotFoundOrError.text = view.context.getString(R.string.image_not_found)
        }
        movieTitleTextView.text = item.localizedName
    }
}