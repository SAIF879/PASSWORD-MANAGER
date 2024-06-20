package com.example.passwordmanager.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost

@Composable
fun RootNavGraph(navHostController: NavHostController) {
    NavHost(
        navController = navHostController,
        route = NavGraphs.ROOT,
        startDestination = NavGraphs.SPLASH
    ) {
        splashNavGraph(navHostController)
        homeNavGraph(navHostController)
    }
}

object NavGraphs {
    const val ROOT = "root"
    const val SPLASH = "splash"
    const val HOME = "home"
}