package com.example.sobes.components

import androidx.compose.foundation.background
import androidx.compose.foundation.gestures.detectTapGestures
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.input.pointer.pointerInput
import androidx.compose.ui.platform.LocalFocusManager

@Composable
fun CustomScaffold(
    modifier: Modifier = Modifier,
    topBar: @Composable (() -> Unit)? = null,
    bottomBar: @Composable (() -> Unit)? = null,
    contentBackground: Color = MaterialTheme.colorScheme.background,
    containerColor: Color = MaterialTheme.colorScheme.background,
    contentColor: Color = MaterialTheme.colorScheme.onSecondary,
    onClick: () -> Unit = {},
    content: @Composable () -> Unit,
) {
    val localFocusManager = LocalFocusManager.current

    Scaffold(
        containerColor = containerColor,
        contentColor = contentColor,
        modifier = modifier.pointerInput(Unit) {
            detectTapGestures(onTap = {
                localFocusManager.clearFocus()
                onClick()
            })
        },
        topBar = {
            Box(modifier = Modifier.fillMaxWidth()) {
                topBar?.let { it() }
            }
        },
        bottomBar = {
            Box(modifier = Modifier.fillMaxWidth()) {
                bottomBar?.let { it() }
            }
        },
        content = {
            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .background(contentBackground)
                    .padding(
                        top = it.calculateTopPadding(),
                        bottom = it.calculateBottomPadding()
                    )
            ) {
                content()
            }
        }
    )
}