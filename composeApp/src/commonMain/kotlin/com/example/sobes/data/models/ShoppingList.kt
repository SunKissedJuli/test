package com.example.sobes.data.models

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
class ShoppingList(
    @SerialName("item_list") val itemList: List<ShoppingItem>?,
    @SerialName("success") val success: Boolean?
)

@Serializable
class ShoppingItem(
    @SerialName("created") val created: String?,
    @SerialName("id") val id: Int?,
    @SerialName("is_crossed") val isCrossed: Boolean?,
    @SerialName("name") val name: String?
)