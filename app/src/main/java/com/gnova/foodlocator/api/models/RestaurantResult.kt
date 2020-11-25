package com.gnova.foodlocator.api.models

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
data class RestaurantResult(
    val Restaurants: List<Restaurant>,
    var ResultCount: Int
) : Parcelable

@Parcelize
data class Restaurant(
    val Id: Int,
    val Cuisines: List<Cuisine>,
    val LogoUrl: String,
    val Name: String,
    val RatingStars: Double,
) : Parcelable

@Parcelize
data class Cuisine(
    val Name: String,
    val SeoName: String
) : Parcelable