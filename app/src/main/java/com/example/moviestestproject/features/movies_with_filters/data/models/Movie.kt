package com.example.moviestestproject.features.movies_with_filters.data.models

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class Movie(
    val description: String?,
    val genres: List<String>?,
    val id: Int?,
    @SerialName("image_url")
    val imageUrl: String?,
    @SerialName("localized_name")
    val localizedName: String?,
    val name: String?,
    val rating: Double?,
    val year: Int?
)