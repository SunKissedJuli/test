package com.example.sobes.data.mapper

import com.example.sobes.data.models.AddShoppingList
import com.example.sobes.data.models.AllShopList
import com.example.sobes.data.models.Shop
import com.example.sobes.domain.modelsUI.AddShoppingListUi
import com.example.sobes.domain.modelsUI.AllShopListUi
import com.example.sobes.domain.modelsUI.ShopUi

//fun List<CategoryById>.toUI(): List<CategoryByIdUi> {
//    return map { it.toUI() }
//}

fun AddShoppingList.toUI(): AddShoppingListUi{
    return AddShoppingListUi(
        success = this.success?:false,
        listId = this.listId?:0
    )
}

