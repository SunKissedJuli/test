package com.example.sobes.data.models

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
class AllShopList(
    @SerialName("shop_list") val shopList: List<Shop>?,
    @SerialName("success") val success: Boolean?,
)
@Serializable
class Shop(
    @SerialName("created") val created: String?,
    @SerialName("id")  val id: Int?,
    @SerialName("name") val name: String?,
)