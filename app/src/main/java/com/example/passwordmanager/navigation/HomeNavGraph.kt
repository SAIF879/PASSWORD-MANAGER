package com.example.passwordmanager.navigation

import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import androidx.navigation.navigation
import com.example.passwordmanager.mainflow.home.ui.HomeScreen

fun NavGraphBuilder.homeNavGraph(navController: NavController){

    navigation(
        route = NavGraphs.HOME,
        startDestination = HomeScreens.HomeScreen.route
    ) {
        composable(route = HomeScreens.HomeScreen.route) {
            HomeScreen();
        }


    }

}
sealed class HomeScreens(val route:String){
    data object HomeScreen : HomeScreens(route = "home_screen")
}