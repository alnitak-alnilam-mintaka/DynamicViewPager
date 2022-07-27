package com.polinasmogi.viewpager.models

data class BookModel(
    var designType: DesignTypes,
    var coverImage: String,
    var bookType: BookTypes,
    var deliveryAddress: String,
    var email: String
)

enum class DesignTypes(val key: String) {
    BASE("base"),
    CUSTOM ("custom")
}

enum class BookTypes(val key: String) {
    PAPER("paper"),
    E_BOOK("e_book")
}
