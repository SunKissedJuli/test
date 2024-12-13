package com.example.sobes.data.mapper

import com.example.sobes.data.models.AllShopList
import com.example.sobes.data.models.Shop
import com.example.sobes.domain.modelsUI.AllShopListUi
import com.example.sobes.domain.modelsUI.ShopUi

//fun List<CategoryById>.toUI(): List<CategoryByIdUi> {
//    return map { it.toUI() }
//}

fun AllShopList.toUI(): AllShopListUi{
    return AllShopListUi(
        shopList = this.shopList?.map { it.toUI() }?: emptyList(),
        success = this.success?:false
    )
}



fun Shop.toUI(): ShopUi{
    return ShopUi(
        created = this.created?:"",
        id = this.id?:0,
        name = this.name?:""
    )
}
