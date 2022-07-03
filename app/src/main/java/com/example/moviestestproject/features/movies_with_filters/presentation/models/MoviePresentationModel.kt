package com.example.moviestestproject.features.movies_with_filters.presentation.models

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class MoviePresentationModel(
    val description: String? = null,
    val genres: List<String>?,
    val id: Long?,
    val imageUrl: String? = null,
    val localizedName: String?,
    val name: String?,
    val rating: Double?,
    val year: Int?
) : Parcelable
