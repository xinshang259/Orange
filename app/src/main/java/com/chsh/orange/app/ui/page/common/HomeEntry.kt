package com.chsh.orange.app.ui.page.common

import androidx.compose.runtime.*
import com.chsh.orange.app.ui.page.splash.SplashPage

@Composable
fun HomeEntry() {
    var isSplash by remember { mutableStateOf(true) }
    if (isSplash) {
        SplashPage {
            isSplash = false
        }
    } else {

    }
}