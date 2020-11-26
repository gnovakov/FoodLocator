package com.gnova.foodlocator.ui

import com.gnova.foodlocator.api.models.Restaurant

sealed class MainViewState {

    data class Presenting( val Restaurants: List<Restaurant>) : MainViewState()

    object Error : MainViewState()

    object Loading : MainViewState()
}