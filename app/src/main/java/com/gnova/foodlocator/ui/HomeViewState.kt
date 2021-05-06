package com.gnova.foodlocator.ui

import com.gnova.domain.models.Restaurant

sealed class HomeViewState {

    data class Presenting(val restaurants: List<Restaurant>) : HomeViewState()

    object Error : HomeViewState()

    object Loading : HomeViewState()
}