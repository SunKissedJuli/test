package com.example.sobes.data.models

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
class AddShoppingList(
    @SerialName("list_id") val listId: Int?,
    @SerialName("success") val success: Boolean?
)