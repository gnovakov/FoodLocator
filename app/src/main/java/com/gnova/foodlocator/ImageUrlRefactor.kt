package com.gnova.foodlocator

fun refactorImgUrl( baseImgUrl: String, id: Int): String {
    val imgUrl = baseImgUrl + id.toString() + ".gif"
    return imgUrl
}