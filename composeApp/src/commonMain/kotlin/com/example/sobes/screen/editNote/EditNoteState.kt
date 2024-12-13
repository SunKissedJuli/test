package com.example.sobes.screen.editNote

import com.example.sobes.commons.Constantas.DEFAULT_BOOLEAN
import com.example.sobes.commons.Constantas.DEFAULT_STRING
import com.example.sobes.domain.modelsUI.ShoppingItemUi
import com.example.sobes.domain.modelsUI.ShoppingListUi

data class EditNoteState(
    val data: List<ShoppingItemUi>,
    val isAdding: Boolean,
    val newName: String,
    val newCount: Int,
    val id: Int,
){
    companion object{
        val InitState = EditNoteState(
            data = listOf(),
            isAdding = DEFAULT_BOOLEAN,
            newName = DEFAULT_STRING,
            newCount = 1,
            id = 0
        )
    }
}
