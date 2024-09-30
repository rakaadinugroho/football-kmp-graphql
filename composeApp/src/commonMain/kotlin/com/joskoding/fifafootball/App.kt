package com.joskoding.fifafootball

import FIFATheme
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import org.jetbrains.compose.ui.tooling.preview.Preview
import moe.tlaster.precompose.PreComposeApp
import org.koin.compose.KoinContext

@Composable
@Preview
fun App() {
    FIFATheme {
        KoinContext {
            PreComposeApp {
                Surface (
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colors.surface
                ) { Nav()  }
            }
        }
    }
}