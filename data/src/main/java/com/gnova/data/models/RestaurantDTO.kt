package com.gnova.data.models

import com.google.gson.annotations.SerializedName
import java.io.Serializable

data class RestaurantDTO(
    @SerializedName("Id")
    val id: Int,
    @SerializedName("Cuisines")
    val cuisines: List<Cuisine>,
    @SerializedName("Name")
    val name: String,
    @SerializedName("RatingStars")
    val ratingStars: Double
)

data class Cuisine(
    @SerializedName("Name")
    val name: String
)