package com.gnova.foodlocator.api

import com.gnova.foodlocator.api.models.RestaurantResponse
import io.reactivex.Single
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers
import javax.inject.Inject

class FoodRepo @Inject constructor(private val foodApi: FoodApi){

    fun getRestaurants(outCode: String): Single<RestaurantResponse> =
        foodApi.getRestaurants(outCode)

            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())

}