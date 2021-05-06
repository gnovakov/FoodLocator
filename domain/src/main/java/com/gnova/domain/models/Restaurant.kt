package com.gnova.domain.models

import java.io.Serializable


data class Restaurant (
    val id: Int = 0,
    val name: String = "",
    val cuisines: String = "",
    val ratingStars: Double = 0.0
) : Serializable
