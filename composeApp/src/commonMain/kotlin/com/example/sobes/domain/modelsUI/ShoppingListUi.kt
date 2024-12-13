package com.example.sobes.domain.modelsUI

import com.example.sobes.data.models.ShoppingItem


data class ShoppingListUi(
    val itemList: List<ShoppingItemUi>,
    val success: Boolean
)

data class ShoppingItemUi(
    val created: String,
    val id: Int,
    val isCrossed: Boolean,
    val name: String
)