package com.gnova.foodlocator.ui

import com.gnova.foodlocator.api.models.Restaurant

sealed class HomeViewState {

    data class Presenting( val Restaurants: List<Restaurant>) : HomeViewState()

    object Error : HomeViewState()

    object Loading : HomeViewState()
}