package com.example.moviestestproject.features.movies_with_filters.presentation.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.AsyncListDiffer
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.moviestestproject.R
import com.example.moviestestproject.databinding.ItemMovieLayoutBinding
import com.example.moviestestproject.features.movies_with_filters.presentation.adapter.diffutils.MovieDiffCallback
import com.example.moviestestproject.features.movies_with_filters.presentation.models.MoviePresentationModel

class MoviesAdapter(private val clickMovieCallback: (MoviePresentationModel) -> Unit) : RecyclerView.Adapter<MoviesAdapter.MovieViewHolder>() {

    private val differ = AsyncListDiffer(this, MovieDiffCallback())

    fun setData(items: List<MoviePresentationModel>) {
        differ.submitList(items)
    }

    inner class MovieViewHolder(private val view: View) : RecyclerView.ViewHolder(view) {

        private val binding = ItemMovieLayoutBinding.bind(view)

        fun bind(item: MoviePresentationModel) = with(binding) {
            binding.root.setOnClickListener {
                clickMovieCallback(item)
            }
            if (item.imageUrl != null) {
                imageNotFoundOrError.visibility = View.INVISIBLE
                Glide.with(view.context).load(item.imageUrl)
                    .error(R.drawable.ic_error_loading_image).into(moviePosterImageView)
            } else {
                imageNotFoundOrError.visibility = View.VISIBLE
                imageNotFoundOrError.text = view.context.getString(R.string.image_not_found)
            }
            movieTitleTextView.text = item.localizedName
        }
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