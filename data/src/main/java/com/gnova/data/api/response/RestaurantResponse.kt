package com.gnova.data.api.response

import com.gnova.data.models.RestaurantDTO
import com.google.gson.annotations.SerializedName

data class RestaurantResponse(
    @SerializedName("Restaurants")
    val restaurants: List<RestaurantDTO>
)