package com.gnova.data.repositories

import com.gnova.data.api.JustEatApi
import com.gnova.data.mappers.RestaurantDTOMapper
import com.gnova.domain.models.Restaurant
import com.gnova.domain.repositories.JustEatRepo
import io.reactivex.Single
import javax.inject.Inject

class JustEatRepoImpl @Inject constructor(
    private val justEatApi: JustEatApi,
    private val mapper: RestaurantDTOMapper
): JustEatRepo {

    override fun getRestaurants(outCode: String): Single<List<Restaurant>> {

        return justEatApi.getRestaurants(outCode)
            .map {
                mapper.mapToDomainList(it.restaurants)
            }

    }



}