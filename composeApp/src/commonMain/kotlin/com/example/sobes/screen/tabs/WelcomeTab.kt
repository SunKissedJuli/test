package com.example.sobes.screen.tabs

import androidx.compose.runtime.Composable
import cafe.adriel.voyager.navigator.Navigator
import cafe.adriel.voyager.navigator.tab.Tab
import cafe.adriel.voyager.navigator.tab.TabOptions
import com.example.sobes.images.SobesResourceImages
import com.example.sobes.screen.allNotes.AllNotesScreen
import com.example.sobes.screen.welcome.WelcomeScreen
import com.example.sobes.strings.SobesResourceStrings
import io.github.skeptick.libres.compose.painterResource

object WelcomeTab: Tab {

    @Composable
    override fun Content() {
        Navigator(WelcomeScreen())
    }

    override val options: TabOptions
        @Composable
        get() = TabOptions(
            index = 1u,
            title = SobesResourceStrings.main_header,
            icon = painterResource(SobesResourceImages.icon_home)
        )
}