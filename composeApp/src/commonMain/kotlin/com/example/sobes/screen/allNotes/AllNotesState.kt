package com.example.sobes.screen.allNotes

import com.example.sobes.commons.Constantas.DEFAULT_BOOLEAN
import com.example.sobes.commons.Constantas.DEFAULT_STRING
import com.example.sobes.domain.modelsUI.ShopUi

data class AllNotesState(
    val shopList: List<ShopUi>,
    val newName: String,
    val errorName: String,
    val isAdding: Boolean,
    val newId: Int
){
    companion object{
        val InitState = AllNotesState(
            shopList = listOf(),
            newName = DEFAULT_STRING,
            isAdding = DEFAULT_BOOLEAN,
            errorName = DEFAULT_STRING,
            newId = 0
        )
    }
}
