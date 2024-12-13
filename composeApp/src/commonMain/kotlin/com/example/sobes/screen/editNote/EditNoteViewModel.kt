package com.example.sobes.screen.editNote

import com.example.sobes.domain.manager.AuthManager
import com.example.sobes.domain.repository.Repository
import com.example.sobes.platform.BaseScreenModel
import org.koin.core.component.inject
import org.orbitmvi.orbit.syntax.simple.blockingIntent
import org.orbitmvi.orbit.syntax.simple.intent
import org.orbitmvi.orbit.syntax.simple.reduce


internal class EditNoteViewModel: BaseScreenModel<EditNoteState, EditNoteEvent>(EditNoteState.InitState) {

    private val repository: Repository by inject()
    private val authManager: AuthManager by inject()

    fun loadData(id: Int) = intent{
        launchOperation(
            operation = {
                repository.getShoppingList(id)
            },
            success = { response ->
                reduceLocal { state.copy(data = response.itemList, id = id) }
            },
            failure = {
                reduceLocal { state.copy(id = id) }
            }
        )
    }

    fun updateIsAdding(isAdding: Boolean) = blockingIntent {
        reduce { state.copy(isAdding = isAdding) }
    }

    fun updateNewName(name: String) = blockingIntent {
        reduce { state.copy(newName = name) }
    }

    fun updateNewCount(count: String) = blockingIntent {
        reduce { state.copy(newCount = count.toIntOrNull()?:1) }
    }

    fun addItem(name: String, id: Int, n: Int) = intent{
        launchOperation(
            operation = {
                repository.addToShoppingList(name = name, id = id, n = n)
            },
            success = { response ->
                reduceLocal { state.copy(isAdding = false) }
                loadData(id)
            }
        )
    }


    fun crossItemOff(itemId: Int) = intent{
        launchOperation(
            operation = {
                repository.crossItOff(itemId)
            },
            success = {
                loadData(state.id)
            }
        )
    }

    fun removeItem(itemId: Int, listId: Int) = intent{
        launchOperation(
            operation = {
                repository.removeFromList(itemId = itemId, listId = listId)
            },
            success = {
                loadData(state.id)
            }
        )
    }

    fun removeNote(listId: Int) = intent{
        launchOperation(
            operation = {
                repository.removeShoppingList(listId = listId)
            },
            success = {
                postSideEffectLocal(EditNoteEvent.RemoveNote)
            }
        )
    }
}