package com.example.sobes.screen.root

import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider
import cafe.adriel.voyager.navigator.CurrentScreen
import cafe.adriel.voyager.navigator.Navigator
import com.example.sobes.screen.splash.SplashScreen
import com.example.sobes.theme.KronaTheme

@Composable
fun Root(){
    KronaTheme {
        Navigator(SplashScreen()) {
            CompositionLocalProvider(RootNavigator provides it,) {
                CurrentScreen()
            }
        }
    }
}