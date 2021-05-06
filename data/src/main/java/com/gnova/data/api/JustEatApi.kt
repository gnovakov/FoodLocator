package com.gnova.data.api

import com.gnova.data.api.response.RestaurantResponse
import io.reactivex.Single
import retrofit2.http.GET
import retrofit2.http.Path


interface JustEatApi {

    @GET("/restaurants/bypostcode/{outCode}")
    fun getRestaurants(
        @Path("outCode") outCode: String
    ): Single<RestaurantResponse>

}