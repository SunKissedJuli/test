package com.example.sobes.screen.splash

import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import cafe.adriel.voyager.core.model.rememberScreenModel
import cafe.adriel.voyager.core.screen.Screen
import cafe.adriel.voyager.navigator.LocalNavigator
import cafe.adriel.voyager.navigator.currentOrThrow
import com.example.sobes.components.CustomCircularProgressIndicator
import com.example.sobes.screen.mainTab.MainTabScreen
import com.example.sobes.screen.welcome.WelcomeScreen

class SplashScreen : Screen {
    @Composable
    override fun Content() {
        val viewModel = rememberScreenModel { SplashViewModel() }
        val navigator = LocalNavigator.currentOrThrow

        LaunchedEffect(Unit){
            viewModel.isAutorize()
        }

        LaunchedEffect(viewModel) {
            viewModel.container.sideEffectFlow.collect() {
                when (it) {
                    is SplashEvent.UserAuthorize -> {
                        navigator.replace(MainTabScreen())
                    }
                    is SplashEvent.UserNotAuthorize ->{
                        navigator.push(WelcomeScreen())
                    }
                }
            }
        }

        CustomCircularProgressIndicator()

    }
}
