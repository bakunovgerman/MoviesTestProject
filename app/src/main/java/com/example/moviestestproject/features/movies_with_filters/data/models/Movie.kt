package com.example.moviestestproject.features.movies_with_filters.data.models

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class Movie(
    val description: String? = null,
    val genres: List<String>?,
    val id: Long?,
    @SerialName("image_url")
    val imageUrl: String? = null,
    @SerialName("localized_name")
    val localizedName: String?,
    val name: String?,
    val rating: Double? = null,
    val year: Int?
)