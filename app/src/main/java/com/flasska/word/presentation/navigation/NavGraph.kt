package com.flasska.word.presentation.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.flasska.word.presentation.mainscreen.DrawerMainScreen

@Composable
internal fun NavGraph() {
    val navController = rememberNavController()

    NavHost(
        navController = navController,
        startDestination = NavScreen.MainScreen.route
    ) {
        composable(NavScreen.MainScreen.route) {
            DrawerMainScreen()
        }
    }
}