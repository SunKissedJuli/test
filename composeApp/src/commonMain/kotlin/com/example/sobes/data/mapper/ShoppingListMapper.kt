package com.example.sobes.data.mapper

import com.example.sobes.data.models.ShoppingItem
import com.example.sobes.data.models.ShoppingList
import com.example.sobes.domain.modelsUI.ShoppingItemUi
import com.example.sobes.domain.modelsUI.ShoppingListUi

fun ShoppingList.toUI(): ShoppingListUi{
    return ShoppingListUi(
        itemList = this.itemList?.map{it.toUI()}?: emptyList(),
        success = false
    )
}

fun ShoppingItem.toUI(): ShoppingItemUi{
    return ShoppingItemUi(
        created = this.created.orEmpty(),
        id = this.id?:0,
        isCrossed = this.isCrossed?:false,
        name = this.name.orEmpty()
    )
}

