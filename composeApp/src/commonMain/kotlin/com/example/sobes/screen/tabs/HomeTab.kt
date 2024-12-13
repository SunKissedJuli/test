package com.example.sobes.screen.tabs

import androidx.compose.runtime.Composable
import cafe.adriel.voyager.navigator.Navigator
import cafe.adriel.voyager.navigator.tab.Tab
import cafe.adriel.voyager.navigator.tab.TabOptions
import com.example.sobes.images.SobesResourceImages
import com.example.sobes.screen.allNotes.AllNotesScreen
import com.example.sobes.strings.SobesResourceStrings
import io.github.skeptick.libres.compose.painterResource

object HomeTab: Tab {

    @Composable
    override fun Content() {
        Navigator(AllNotesScreen())
    }

    override val options: TabOptions
        @Composable
        get() = TabOptions(
            index = 1u,
            title = SobesResourceStrings.app_name,
            icon = painterResource(SobesResourceImages.icon_home)
        )
}