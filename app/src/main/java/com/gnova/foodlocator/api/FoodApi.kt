package com.gnova.foodlocator.api

import com.gnova.foodlocator.api.models.RestaurantResponse
import io.reactivex.Single
import retrofit2.http.GET
import retrofit2.http.Path


interface FoodApi {

    @GET("/restaurants/bypostcode/{outCode}")
    fun getRestaurants(
        @Path("outCode") outCode: String
): Single<RestaurantResponse>

}