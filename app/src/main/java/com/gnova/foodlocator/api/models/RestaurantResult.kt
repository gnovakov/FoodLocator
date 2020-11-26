package com.gnova.foodlocator.api.models

import android.os.Parcelable
import com.squareup.moshi.Json
import kotlinx.android.parcel.Parcelize

@Parcelize
data class RestaurantResult(
    //@Json(name="Restaurants")
    val Restaurants: List<Restaurant>,
    //@Json(name="ResultCount")
    var ResultCount: Int
) : Parcelable

@Parcelize
data class Restaurant(
    //@Json(name="Id")
    val Id: Int,
    //@Json(name="Cuisines")
    val Cuisines: List<Cuisine>,
    //@Json(name="LogoUrl")
    val LogoUrl: String,
    //@Json(name="Name")
    val Name: String,
    //@Json(name="RatingStars")
    val RatingStars: Double,
) : Parcelable

@Parcelize
data class Cuisine(
    //@Json(name="Name")
    val Name: String,
    //@Json(name="SeoName")
    val SeoName: String
) : Parcelable