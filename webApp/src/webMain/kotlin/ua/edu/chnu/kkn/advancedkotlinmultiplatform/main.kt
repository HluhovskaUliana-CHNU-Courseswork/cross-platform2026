package ua.edu.chnu.kkn.advancedkotlinmultiplatform

import androidx.compose.ui.ExperimentalComposeUiApi
import androidx.compose.ui.window.ComposeViewport
import ua.edu.chnu.kkn.advancedkotlinmultiplatform.di.initKoin
import ua.edu.chnu.kkn.advancedkotlinmultiplatform.presentation.App

@OptIn(ExperimentalComposeUiApi::class)
fun main() {
    initKoin { printLogger() }
    ComposeViewport {
        App()
    }
}