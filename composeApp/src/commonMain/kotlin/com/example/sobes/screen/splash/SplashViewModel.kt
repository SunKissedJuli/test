package com.example.sobes.screen.splash

import com.example.sobes.domain.manager.AuthManager
import com.example.sobes.domain.repository.Repository
import com.example.sobes.platform.BaseScreenModel
import org.koin.core.component.inject
import org.orbitmvi.orbit.syntax.simple.intent
import org.orbitmvi.orbit.syntax.simple.postSideEffect

internal class SplashViewModel: BaseScreenModel<Unit, SplashEvent>(Unit) {

    private val repository: Repository by inject()
    private val authManager: AuthManager by inject()

    fun isAutorize() = intent{
        if(authManager.key.isNullOrEmpty()){
            getNewKey()
        }
        else{
            postSideEffect(SplashEvent.UserAuthorize)
        }
    }

    private fun getNewKey() = intent{
        launchOperation(
            operation = {
                repository.createTestKey()
            },
            success = { response ->
                authManager.key = response
                postSideEffectLocal(SplashEvent.UserAuthorize)
            }
        )
    }
}