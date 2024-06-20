package com.example.passwordmanager.navigation

import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import androidx.navigation.navigation
import com.example.passwordmanager.mainflow.splash.ui.Splashscreen

fun NavGraphBuilder.splashNavGraph(navController: NavController){

    navigation(
        route = NavGraphs.SPLASH,
        startDestination = SplashScreens.SplashScreen.route
    ) {
        composable(route = SplashScreens.SplashScreen.route) {
            Splashscreen(navController = navController)
        }


    }

}
sealed class SplashScreens(val route:String){
    data object SplashScreen : SplashScreens(route = "splash_screen")
}