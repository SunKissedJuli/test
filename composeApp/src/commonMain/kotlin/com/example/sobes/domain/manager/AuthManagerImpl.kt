package com.example.sobes.domain.manager

import com.russhwolf.settings.Settings
import org.koin.core.component.KoinComponent
import org.koin.core.component.inject

class AuthManagerImpl: AuthManager, KoinComponent {

    private val settings by inject<Settings>()

    override var key: String?
        get() = if (settings.getString(KEY).isBlank()) null else settings.getString(KEY, "")
        set(value){
            settings.putString(KEY, value.orEmpty())
        }


    companion object{
        private const val KEY = "KEY"
    }
}