package com.gnova.data.api.response

import com.gnova.data.models.Restaurant
import com.google.gson.annotations.SerializedName
import java.io.Serializable

data class RestaurantResponse(
    @SerializedName("Restaurants")
    val restaurants: List<Restaurant>,
    @SerializedName("ResultCount")
    var resultCount: Int
)