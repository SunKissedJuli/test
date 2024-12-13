package com.example.sobes.screen.allNotes

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.BasicAlertDialog
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import cafe.adriel.voyager.core.model.rememberScreenModel
import cafe.adriel.voyager.core.screen.Screen
import cafe.adriel.voyager.navigator.LocalNavigator
import cafe.adriel.voyager.navigator.currentOrThrow
import com.example.sobes.components.CustomButton
import com.example.sobes.components.CustomCircularProgressIndicator
import com.example.sobes.components.CustomScaffold
import com.example.sobes.components.HeaderOneWord
import com.example.sobes.components.NoteCard
import com.example.sobes.components.RoundedTextField
import com.example.sobes.screen.editNote.EditNoteScreen
import com.example.sobes.screen.mainTab.MainTabScreen
import com.example.sobes.screen.splash.SplashEvent
import com.example.sobes.screen.welcome.WelcomeScreen
import com.example.sobes.strings.SobesResourceStrings

class AllNotesScreen : Screen {
    @Composable
    override fun Content() {
        val navigator = LocalNavigator.currentOrThrow
        val viewModel = rememberScreenModel { AllNotesViewModel() }
        val state by viewModel.stateFlow.collectAsState()

        LaunchedEffect(Unit){
            viewModel.loadData()
        }

        LaunchedEffect(viewModel) {
            viewModel.container.sideEffectFlow.collect() {
                when (it) {
                    is AllNotesEvent.AddNewNote -> {
                        navigator.push(EditNoteScreen(state.newId, state.newName))
                        viewModel.updateNewName("")
                        viewModel.updateIsAdding(false)
                    }
                }
            }
        }

        Box(Modifier.fillMaxSize()){

            if(state.isAdding){
                NewNote(
                    value = state.newName,
                    error = state.errorName,
                    onClick = {viewModel.addNewNote(state.newName)},
                    onDismissRequest = {viewModel.updateIsAdding(false)},
                    onChangeValue = viewModel::updateNewName
                )
            }

            CustomScaffold(
                topBar = {
                    HeaderOneWord(SobesResourceStrings.main_header)
                }
            ) {

                if(viewModel.status.collectAsState().value && AllNotesState.InitState==state){
                    CustomCircularProgressIndicator()
                } else {
                    LazyColumn {
                        items(state.shopList) { item ->
                            NoteCard(
                                name = item.name,
                                dataAdd = item.created,
                                onClick = { navigator.push(EditNoteScreen(item.id, item.name)) }
                            )
                        }
                    }
                }
            }

            Box(
                modifier = Modifier
                    .align(Alignment.BottomEnd)
                    .padding(bottom = 20.dp, end = 20.dp)
                    .size(40.dp)
                    .clip(CircleShape)
                    .background(MaterialTheme.colorScheme.primary, CircleShape)
                    .clickable { viewModel.updateIsAdding(true) }
            ){
                Text(
                    text = "+",
                    fontWeight = FontWeight.Bold,
                    fontSize = 20.sp,
                    color = MaterialTheme.colorScheme.background,
                    modifier = Modifier.align(Alignment.Center)
                )
            }
        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
private fun NewNote(
    value: String,
    error: String,
    onChangeValue:(String)->Unit,
    onDismissRequest: ()-> Unit,
    onClick: ()-> Unit
){
    BasicAlertDialog(
        onDismissRequest = onDismissRequest,
        modifier = Modifier.clip(RoundedCornerShape(15.dp))
            .background(MaterialTheme.colorScheme.background)
    ) {

        Column(
            Modifier
                .fillMaxWidth()
                .padding(20.dp),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            RoundedTextField(
                value = value,
                errorMessage = error,
                onValueChange = onChangeValue,
                placeholder = SobesResourceStrings.new_name
            )
            Spacer(Modifier.height(20.dp))
            CustomButton(
                onClick = onClick,
                text = SobesResourceStrings.add
            )
        }
    }
}