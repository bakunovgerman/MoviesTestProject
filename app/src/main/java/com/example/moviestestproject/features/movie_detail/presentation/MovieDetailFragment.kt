package com.example.moviestestproject.features.movie_detail.presentation

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import by.kirich1409.viewbindingdelegate.viewBinding
import com.bumptech.glide.Glide
import com.example.moviestestproject.R
import com.example.moviestestproject.databinding.FragmentMovieDetailBinding
import com.example.moviestestproject.features.movies_with_filters.presentation.models.MoviePresentationModel

class MovieDetailFragment : Fragment(R.layout.fragment_movie_detail) {

    private val binding: FragmentMovieDetailBinding by viewBinding()
    private val movieDetail: MoviePresentationModel? by lazy {
        arguments?.getParcelable(
            ARG_MOVIE_DETAIL
        )
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initUi()
    }

    private fun initUi() {
        movieDetail?.let {
            with(binding) {
                Glide.with(requireContext()).load(it.imageUrl)
                    .error(R.drawable.ic_error_loading_image)
                    .into(posterMovieImageView)
                nameTextView.text = it.name
                yearTextView.text = String.format(YEAR_FORMAT, it.year.toString())
                ratingTextView.text = String.format(RATING_MOVIE_FORMAT, it.rating ?: NO_DATA)
                descriptionTextView.text = it.description
                toolbar.title = it.localizedName
            }
        }
        binding.toolbar.setNavigationOnClickListener {
            parentFragmentManager.popBackStack()
        }
    }

    companion object {
        @JvmStatic
        fun newInstance(movieDetail: MoviePresentationModel) =
            MovieDetailFragment().apply {
                arguments = Bundle().apply {
                    putParcelable(ARG_MOVIE_DETAIL, movieDetail)
                }
            }

        const val MOVIE_DETAIL_FRAGMENT = "MovieDetailFragment"
        private const val ARG_MOVIE_DETAIL = "movie_detail"
        private const val RATING_MOVIE_FORMAT = "Рейтинг: %s"
        private const val YEAR_FORMAT = "Год: %s"
        private const val NO_DATA = "Нет данных."
    }
}