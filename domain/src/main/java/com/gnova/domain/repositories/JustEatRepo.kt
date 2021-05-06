package com.gnova.domain.repositories

import com.gnova.domain.models.Restaurant
import io.reactivex.Single

interface JustEatRepo {

    fun getRestaurants(outCode: String): Single<List<Restaurant>>

}