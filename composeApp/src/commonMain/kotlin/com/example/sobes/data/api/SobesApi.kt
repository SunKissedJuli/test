package com.example.sobes.data.api

import com.example.sobes.data.models.AddShoppingList
import com.example.sobes.data.models.AllShopList
import com.example.sobes.data.models.ShoppingList
import de.jensklingenberg.ktorfit.http.POST
import de.jensklingenberg.ktorfit.http.Query

interface SobesApi {

    @POST("CreateTestKey?")
    suspend fun createTestKey(): String

    @POST("Authentication")
    suspend fun authentication(
        @Query("key") key: String,
    ): Unit

    @POST("CreateShoppingList?")
    suspend fun CreateShoppingList(
        @Query("key") key: String,
        @Query("name") name: String,
    ): AddShoppingList

    @POST("RemoveShoppingList?")
    suspend fun RemoveShoppingList(
        @Query("key") key: String,
        @Query("list_id") listId: Int,
    ): Unit

    @POST("AddToShoppingList?")
    suspend fun AddToShoppingList(
        @Query("key") key: String,
        @Query("id") id: Int,
        @Query("value") name: String,
        @Query("n") n: Int,
    ): Unit

    @POST("RemoveFromList?")
    suspend fun RemoveFromList(
        @Query("key") key: String,
        @Query("list_id") listId: Int,
        @Query("item_id") itemId: Int,
    ): Unit

    @POST("CrossItOff?")
    suspend fun CrossItOff(
        @Query("key") key: String,
        @Query("id") id: Int,
    ): Unit

    @POST("GetAllMyShopLists?")
    suspend fun GetAllMyShopLists(
        @Query("key") key: String,
    ): AllShopList

    @POST("GetShoppingList?")
    suspend fun GetShoppingList(
        @Query("key") key: String,
        @Query("list_id") id: Int,
    ): ShoppingList

}