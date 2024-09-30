package com.flasska.word.presentation.mainscreen.components

import androidx.activity.ComponentActivity
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.toArgb
import androidx.compose.ui.platform.LocalContext
import com.flasska.word.presentation.theme.Violet

@Composable
fun SettingColorToStatusBar() {
    (LocalContext.current as ComponentActivity).window.apply {
        statusBarColor = Violet.toArgb()
    }
}