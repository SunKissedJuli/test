package com.example.sobes.screen.editNote

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.unit.dp
import cafe.adriel.voyager.core.model.rememberScreenModel
import cafe.adriel.voyager.core.screen.Screen
import cafe.adriel.voyager.navigator.LocalNavigator
import cafe.adriel.voyager.navigator.currentOrThrow
import com.example.sobes.components.CustomButton
import com.example.sobes.components.CustomCheckBox
import com.example.sobes.components.CustomCircularProgressIndicator
import com.example.sobes.components.CustomScaffold
import com.example.sobes.components.HeaderWithButtonBack
import com.example.sobes.components.LineTextField
import com.example.sobes.images.SobesResourceImages
import com.example.sobes.screen.allNotes.AllNotesEvent
import com.example.sobes.strings.SobesResourceStrings
import io.github.skeptick.libres.compose.painterResource

class EditNoteScreen(private val id: Int, private val name: String) : Screen {
    @Composable
    override fun Content() {
        val navigator = LocalNavigator.currentOrThrow
        val viewModel = rememberScreenModel { EditNoteViewModel() }
        val state by viewModel.stateFlow.collectAsState()

        LaunchedEffect(Unit){
            viewModel.loadData(id)
        }
        LaunchedEffect(viewModel) {
            viewModel.container.sideEffectFlow.collect() {
                when (it) {
                    is EditNoteEvent.RemoveNote -> {
                        navigator.pop()
                    }
                }
            }
        }

        CustomScaffold(
            topBar = {
                HeaderWithButtonBack(
                    onClick = {navigator.pop()},
                    text = name,
                    onRemoveClick = {viewModel.removeNote(id)}
                )
            }
        ) {

            if (viewModel.status.collectAsState().value && EditNoteState.InitState == state) {
                CustomCircularProgressIndicator()
            } else {
                LazyColumn(Modifier.padding(20.dp)) {
                    items(state.data) { note ->
                        Row(
                            Modifier.fillMaxWidth(),
                            verticalAlignment = Alignment.CenterVertically,
                            horizontalArrangement = Arrangement.SpaceBetween
                        ) {
                            Row(verticalAlignment = Alignment.CenterVertically){
                                CustomCheckBox(
                                    checked = note.isCrossed,
                                    onCheckedChange = {viewModel.crossItemOff(note.id)}
                                )

                                Text(
                                    text = "${note.created} ${note.name}",
                                    textAlign = TextAlign.Center,
                                    textDecoration = if (note.isCrossed) TextDecoration.LineThrough else TextDecoration.None
                                )
                            }

                            IconButton(
                                onClick = {viewModel.removeItem(listId = state.id, itemId = note.id)}
                            ){
                                Icon(
                                    painterResource(SobesResourceImages.icon_delete),
                                    tint = MaterialTheme.colorScheme.primary,
                                    contentDescription = "",
                                )
                            }
                        }
                    }
                    if (state.isAdding) {
                        item {
                            Row(
                                Modifier.fillMaxWidth().padding(bottom = 25.dp, top = 15.dp),
                                verticalAlignment = Alignment.CenterVertically
                            ) {
                                LineTextField(
                                    modifier = Modifier.width(60.dp),
                                    value = state.newCount.toString(),
                                    onValueChange = viewModel::updateNewCount,
                                    keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.NumberPassword)
                                )
                                Spacer(Modifier.width(15.dp))
                                LineTextField(
                                    modifier = Modifier.fillMaxWidth(),
                                    value = state.newName,
                                    onValueChange = viewModel::updateNewName,
                                    onEnter = { viewModel.addItem(state.newName, id, state.newCount) }
                                )
                            }
                        }
                    }
                    item {
                        CustomButton(
                            onClick = { if(state.isAdding) viewModel.addItem(state.newName, id, state.newCount) else viewModel.updateIsAdding(true) },
                            text = SobesResourceStrings.add_product,
                            modifier = Modifier.padding(top = 20.dp)
                        )
                    }
                }
            }
        }
    }
}