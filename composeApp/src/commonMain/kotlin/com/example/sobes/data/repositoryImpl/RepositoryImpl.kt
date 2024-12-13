package com.example.sobes.data.repositoryImpl

import com.example.sobes.data.api.SobesApi
import com.example.sobes.data.mapper.toUI
import com.example.sobes.domain.manager.AuthManager
import com.example.sobes.domain.modelsUI.AddShoppingListUi
import com.example.sobes.domain.modelsUI.AllShopListUi
import com.example.sobes.domain.modelsUI.ShoppingListUi
import com.example.sobes.domain.repository.Repository
import com.example.sobes.platform.Either
import com.example.sobes.platform.Failure
import com.example.sobes.platform.apiCall

class RepositoryImpl(
    private val sobesApi: SobesApi,
    private val manager: AuthManager
) : Repository {

    override suspend fun createTestKey(): Either<Failure, String> {
        return apiCall(call = {
            sobesApi.createTestKey() })
    }

    override suspend fun authenticate(): Either<Failure, Unit> {
        return apiCall(call = {
            sobesApi.authentication(
                key = manager.key?:""
            )
        },
            mapResponse = {Unit})
    }

    override suspend fun createShoppingList(name:String): Either<Failure, AddShoppingListUi> {
        return apiCall(call = {
            sobesApi.CreateShoppingList(
                key = manager.key?:"",
                name = name
            )
        },
            mapResponse = {it.toUI()})
    }

    override suspend fun removeShoppingList(listId: Int): Either<Failure, Unit> {
        return apiCall(call = {
            sobesApi.RemoveShoppingList(
                key = manager.key?:"",
                listId = listId
            )
        },
            mapResponse = {Unit})
    }

    override suspend fun addToShoppingList(name: String, id: Int, n: Int): Either<Failure, Unit> {
        return apiCall(call = {
            sobesApi.AddToShoppingList(
                key = manager.key?:"",
                name = name,
                id = id,
                n = n
            )
        },
            mapResponse = {Unit})
    }

    override suspend fun removeFromList(listId: Int, itemId: Int): Either<Failure, Unit> {
        return apiCall(call = {
            sobesApi.RemoveFromList(
                key = manager.key?:"",
                listId = listId,
                itemId = itemId
            )
        },
            mapResponse = {Unit})
    }

    override suspend fun crossItOff(id: Int): Either<Failure, Unit> {
        return apiCall(call = {
            sobesApi.CrossItOff(
                key = manager.key?:"",
                id = id
            )
        },
            mapResponse = {Unit})
    }

    override suspend fun getAllMyShopLists(): Either<Failure, AllShopListUi> {
        return apiCall(call = {
            sobesApi.GetAllMyShopLists(
                key = manager.key?:""
            )
        },
            mapResponse = { it.toUI()})
    }
    override suspend fun getShoppingList(id: Int): Either<Failure, ShoppingListUi> {
        return apiCall(call = {
            sobesApi.GetShoppingList(
                key = manager.key?:"",
                id = id
            )
        },
            mapResponse = {it.toUI()})
    }

}
