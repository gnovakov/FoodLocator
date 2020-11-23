package com.gnova.foodlocator.api

import android.text.Editable
import com.gnova.foodlocator.api.models.RestaurantResult
import io.reactivex.Single
import retrofit2.http.GET
import retrofit2.http.Path


interface FoodApi {

    @GET("/restaurants/bypostcode/{outCode}")
    fun getRestaurants(
        @Path("outCode") outCode: Editable
    ): Single<RestaurantResult>

}