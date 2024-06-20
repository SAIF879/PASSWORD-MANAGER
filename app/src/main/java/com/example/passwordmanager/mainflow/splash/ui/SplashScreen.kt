package com.example.passwordmanager.mainflow.splash.ui

import android.content.Context
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.wrapContentWidth
import androidx.compose.runtime.Composable
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.example.passwordmanager.commonComponents.PasswordManagerTexts
import com.example.passwordmanager.navigation.NavGraphs
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch



@Composable
fun Splashscreen(navController: NavController,) {
    val coroutineScope = rememberCoroutineScope()
    val context = LocalContext.current

    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.Black),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Row(
            modifier = Modifier.wrapContentWidth(),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.Start
        ) {
            PasswordManagerTexts.TextAsBoldHeader(text = "Password Manager")
        }
    }

    splashNavigation(coroutineScope = coroutineScope, navController = navController , context)


}

fun splashNavigation(coroutineScope: CoroutineScope, navController: NavController,
                     context: Context){
    coroutineScope.launch {
        delay(2000)
        navController.navigate(NavGraphs.HOME){
            popUpTo(NavGraphs.SPLASH){
                inclusive = true
            }
        }
    }
}