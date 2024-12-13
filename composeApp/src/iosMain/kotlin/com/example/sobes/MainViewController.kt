package com.example.sobes

import androidx.compose.ui.window.ComposeUIViewController
import com.example.sobes.di.KoinInjector
import com.example.sobes.screen.root.Root

fun MainViewController() = ComposeUIViewController {
    KoinInjector.koinApp
    Root()
}

