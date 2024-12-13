package com.example.sobes.domain.modelsUI

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

data class AllShopListUi(
    val shopList: List<ShopUi>,
    val success: Boolean,
)

data class ShopUi(
    val created: String,
    val id: Int,
    val name: String,
)