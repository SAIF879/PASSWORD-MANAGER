package com.example.passwordmanager.mainflow.home.ui

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.wrapContentWidth
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.rememberModalBottomSheetState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.dp
import com.example.passwordmanager.commonComponents.BottomSheet
import com.example.passwordmanager.commonComponents.ItemPassword
import com.example.passwordmanager.commonComponents.NewAccountButton
import com.example.passwordmanager.commonComponents.NewPasswordButton
import com.example.passwordmanager.commonComponents.PasswordManagerTexts
import com.example.passwordmanager.ui.theme.BackGroundColor
import com.example.passwordmanager.ui.theme.MatteBlack
import com.example.passwordmanager.utils.extentions.showToast


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun HomeScreen(){
    val context = LocalContext.current
    var showSheet by remember { mutableStateOf(false) }

    if (showSheet) {
        BottomSheet() {
            showSheet = false
        }
    }
    Column(
            modifier = Modifier
                .fillMaxSize()
                .background(BackGroundColor),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Column(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(10.dp),
                horizontalAlignment = Alignment.CenterHorizontally,
            ) {
                Spacer(modifier = Modifier.size(30.dp))
                Column(modifier = Modifier
                    .fillMaxWidth()
                    .weight(0.8f)) {
                    PasswordManagerTexts.TextAsBoldHeader(text = "Password Manager" , 
                        color = MatteBlack, size = 18 , modifier = Modifier.padding(10.dp) )
                    Spacer(modifier = Modifier.size(5.dp))
                    HorizontalDivider()
                    LazyColumn(modifier = Modifier.fillMaxSize()) {
                        items(passwordItems) { item ->
                            ItemPassword(heading = item.heading, placeholder = item.placeholder)
                        }
                    }
                }
                Column(modifier = Modifier
                    .fillMaxWidth()
                    .weight(0.1f)
                    .padding(10.dp)) {
                    Row(modifier = Modifier.fillMaxWidth() , horizontalArrangement = Arrangement.End) {
                        NewPasswordButton{
                                showSheet = true

                        }
                    }
                }

            }
        }

}
data class PasswordItem(val heading: String, val placeholder: String)
val passwordItems = listOf(
    PasswordItem("Google", "*******"),
    PasswordItem("Facebook", "********"),
    PasswordItem("Twitter", "*********"),
    PasswordItem("LinkedIn", "**********")
)
