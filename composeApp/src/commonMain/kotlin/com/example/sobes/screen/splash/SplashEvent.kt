package com.example.sobes.screen.splash

sealed class SplashEvent {

    object UserAuthorize: SplashEvent()

    object UserNotAuthorize: SplashEvent()

}