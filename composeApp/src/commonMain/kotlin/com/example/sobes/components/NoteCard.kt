package com.example.sobes.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.ExperimentalLayoutApi
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.unit.dp

@Composable
fun NoteCard(
    name: String,
    dataAdd: String,
    onClick: () -> Unit
){

    Surface(
        Modifier
            .fillMaxWidth()
            .height(100.dp)
            .padding(vertical = 7.dp, horizontal = 10.dp),
        shape = RoundedCornerShape(15.dp),
        shadowElevation = 5.dp) {

        CustomScaffold(
            modifier = Modifier
                .fillMaxSize()
                .clip(RoundedCornerShape(15.dp)),
            contentBackground = MaterialTheme.colorScheme.onTertiary,
            onClick = onClick,
            bottomBar = {
                Row(Modifier
                    .fillMaxWidth()
                    .background(MaterialTheme.colorScheme.onTertiary)
                    .padding(bottom = 10.dp, end = 10.dp),
                    verticalAlignment = Alignment.CenterVertically,
                    horizontalArrangement = Arrangement.End) {
                    Text(
                        text = dataAdd
                    )
                }
            }
        ){
            Column(Modifier.fillMaxSize().padding(10.dp)) {
                Text(
                    text = name
                )
            }
        }
    }
}
