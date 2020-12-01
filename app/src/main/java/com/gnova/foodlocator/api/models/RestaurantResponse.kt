package com.gnova.foodlocator.api.models

import android.os.Parcelable
import com.google.gson.annotations.SerializedName

import kotlinx.android.parcel.Parcelize

@Parcelize
data class RestaurantResponse(
    @SerializedName("Restaurants")
    val restaurants: List<Restaurant>,
    @SerializedName("ResultCount")
    var resultCount: Int
) : Parcelable

@Parcelize
data class Restaurant(
    @SerializedName("Id")
    val id: Int,
    @SerializedName("Cuisines")
    val cuisines: List<Cuisine>,
    @SerializedName("LogoUrl")
    val logoUrl: String,
    @SerializedName("Name")
    val name: String,
    @SerializedName("RatingStars")
    val ratingStars: Double,
) : Parcelable

@Parcelize
data class Cuisine(
    @SerializedName("Name")
    val name: String,
    @SerializedName("SeoName")
    val seoName: String
) : Parcelable