package com.flasska.word.presentation.navigation

internal sealed class NavScreen(val route: String) {
    data object MainScreen: NavScreen("main_screen")
}