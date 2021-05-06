package com.gnova.data.mappers

import com.gnova.domain.common.DomainMapper
import com.gnova.domain.models.Restaurant
import javax.inject.Inject

class RestaurantDTOMapper @Inject constructor(): DomainMapper<com.gnova.data.models.Restaurant, Restaurant> {

    override fun mapToDomain(entity: com.gnova.data.models.Restaurant): Restaurant {
        return Restaurant(
            id = entity.id,
            cuisines = entity.cuisines[0].name,
            name = entity.name,
            ratingStars = entity.ratingStars
        )
    }

    override fun mapToEntity(domainModel: Restaurant): com.gnova.data.models.Restaurant {
        TODO("Not yet implemented")
    }

    fun mapToDomainList(restaurants: List<com.gnova.data.models.Restaurant>): List<Restaurant> {
        return restaurants.map {
            mapToDomain(it) }
    }

    fun mapToEntityList(restaurants: List<Restaurant>): List<com.gnova.data.models.Restaurant> {
        return restaurants.map {
            mapToEntity(it) }
    }


}
