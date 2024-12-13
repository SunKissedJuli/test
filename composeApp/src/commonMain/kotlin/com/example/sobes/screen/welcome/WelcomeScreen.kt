package com.example.sobes.screen.welcome

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import cafe.adriel.voyager.core.model.rememberScreenModel
import cafe.adriel.voyager.core.screen.Screen
import cafe.adriel.voyager.navigator.LocalNavigator
import cafe.adriel.voyager.navigator.currentOrThrow
import com.example.sobes.components.CustomButton
import com.example.sobes.components.CustomScaffold
import com.example.sobes.components.CustomSplitClickableText
import com.example.sobes.images.SobesResourceImages
import com.example.sobes.screen.mainTab.MainTabScreen
import com.example.sobes.strings.SobesResourceStrings
import io.github.skeptick.libres.compose.painterResource

class WelcomeScreen : Screen {
    @Composable
    override fun Content() {
        val navigator = LocalNavigator.currentOrThrow
        val viewModel = rememberScreenModel { WelcomeViewModel() }

        Box(Modifier.fillMaxSize()){
            Image(
                painterResource(SobesResourceImages.background_welcome),
                contentDescription = "",
                modifier = Modifier.fillMaxWidth().align(Alignment.TopCenter),
                contentScale = ContentScale.FillWidth
            )

        }

        CustomScaffold(
            bottomBar = {

                Column(Modifier.fillMaxWidth().padding(bottom = 20.dp),
                    horizontalAlignment = Alignment.CenterHorizontally) {
                    CustomSplitClickableText(
                        text = SobesResourceStrings.empty,
                        onClick = {}
                    )
                }
            },
            containerColor = Color.Transparent,
            contentBackground = Color.Transparent
        ) {
            Box(
                Modifier
                    .fillMaxSize()
                    .verticalScroll(rememberScrollState())
            ) {

                Box(Modifier.align(Alignment.Center)){
                    Column(Modifier,
                        verticalArrangement = Arrangement.Center,
                        horizontalAlignment = Alignment.CenterHorizontally
                    ) {
                        Surface(
                            Modifier
                                .fillMaxWidth(0.65f),
                            shape = CircleShape,
                            shadowElevation = 5.dp) {
                            Image(
                                painterResource(SobesResourceImages.logo_light),
                                contentDescription = "",
                                modifier = Modifier.fillMaxWidth(),
                                contentScale = ContentScale.FillWidth
                            )
                        }

                        Spacer(Modifier.height(15.dp))
                        Text(
                            text = SobesResourceStrings.app_name,
                            fontSize = 40.sp,
                            fontWeight = FontWeight.Bold
                        )
                        Spacer(Modifier.height(30.dp))

                        CustomButton(
                            onClick = {},
                            text = SobesResourceStrings.sign_in,
                            Modifier.fillMaxWidth(0.3f)
                        )
                    }
                }

            }
        }
    }
}