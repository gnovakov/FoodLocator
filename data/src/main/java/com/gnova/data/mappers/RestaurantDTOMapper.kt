package com.gnova.data.mappers

import com.gnova.data.models.RestaurantDTO
import com.gnova.domain.common.DomainMapper
import com.gnova.domain.models.Restaurant
import javax.inject.Inject

class RestaurantDTOMapper @Inject constructor(): DomainMapper<RestaurantDTO, Restaurant> {

    override fun mapToDomain(entity: RestaurantDTO): Restaurant {
        return Restaurant(
            id = entity.id,
            cuisines = entity.cuisines[0].name,
            name = entity.name,
            ratingStars = entity.ratingStars
        )
    }

    override fun mapToEntity(domainModel: Restaurant): RestaurantDTO {
        TODO("Not yet implemented")
    }

    fun mapToDomainList(restaurantDTOS: List<RestaurantDTO>): List<Restaurant> {
        return restaurantDTOS.map {
            mapToDomain(it) }
    }

    fun mapToEntityList(restaurants: List<Restaurant>): List<RestaurantDTO> {
        return restaurants.map {
            mapToEntity(it) }
    }


}
