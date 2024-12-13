package com.example.sobes.domain.repository

import com.example.sobes.domain.modelsUI.AddShoppingListUi
import com.example.sobes.domain.modelsUI.AllShopListUi
import com.example.sobes.domain.modelsUI.ShoppingListUi
import com.example.sobes.platform.Either
import com.example.sobes.platform.Failure


interface Repository {
    suspend fun createTestKey(): Either<Failure, String>

    suspend fun authenticate(): Either<Failure, Unit>

    suspend fun createShoppingList(name:String): Either<Failure, AddShoppingListUi>

    suspend fun removeShoppingList(listId: Int): Either<Failure, Unit>

    suspend fun addToShoppingList(name: String, id: Int, n: Int): Either<Failure, Unit>

    suspend fun removeFromList(listId: Int, itemId: Int): Either<Failure, Unit>

    suspend fun crossItOff(id: Int): Either<Failure, Unit>

    suspend fun getAllMyShopLists(): Either<Failure, AllShopListUi>

    suspend fun getShoppingList(id: Int): Either<Failure,ShoppingListUi>
}
