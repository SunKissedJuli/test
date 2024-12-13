package com.example.sobes.screen.allNotes

import com.example.sobes.domain.manager.AuthManager
import com.example.sobes.domain.repository.Repository
import com.example.sobes.platform.BaseScreenModel
import com.example.sobes.strings.SobesResourceStrings
import org.koin.core.component.inject
import org.orbitmvi.orbit.syntax.simple.blockingIntent
import org.orbitmvi.orbit.syntax.simple.intent
import org.orbitmvi.orbit.syntax.simple.reduce

internal class AllNotesViewModel: BaseScreenModel<AllNotesState, AllNotesEvent>(AllNotesState.InitState) {

    private val repository: Repository by inject()
    private val authManager: AuthManager by inject()

    fun loadData() = intent{
        launchOperation(
            operation = {
               repository.getAllMyShopLists()
            },
            success = { response ->
                reduceLocal { state.copy(shopList = response.shopList) }
            }
        )
    }

    fun updateIsAdding(isAdding: Boolean) = blockingIntent {
        reduce { state.copy(isAdding = isAdding) }
    }

    fun updateNewName(name: String) = blockingIntent {
        reduce { state.copy(newName = name) }
    }

    fun addNewNote(name: String) = intent{
        if(name.isNotEmpty()){
            launchOperation(
                operation = {
                    repository.createShoppingList(name)
                },
                success = { response ->
                    reduceLocal { state.copy(newId = response.listId) }
                    postSideEffectLocal(AllNotesEvent.AddNewNote)
                }
            )
        }
        else{
            reduce { state.copy(errorName = SobesResourceStrings.error_name) }
        }

    }


}