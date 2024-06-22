package com.example.passwordmanager.mainflow.home.ui

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import com.example.passwordmanager.commonComponents.*
import com.example.passwordmanager.mainflow.home.util.HomeViewModel
import com.example.passwordmanager.room.model.PasswordDto
import com.example.passwordmanager.ui.theme.BackGroundColor
import com.example.passwordmanager.ui.theme.MatteBlack


@Composable
fun HomeScreen(homeViewModel: HomeViewModel = hiltViewModel()) {
    val context = LocalContext.current
    var showSheet by remember { mutableStateOf(false) }
    var showEditSheet by remember { mutableStateOf(false) }
    var selectedPassword by remember { mutableStateOf<PasswordDto?>(null) }

    val passwords by homeViewModel.passwords.collectAsState()
    if (showSheet) {
        BottomSheet(
            passwordViewModel = homeViewModel,
            context= context,
            onDismiss = { showSheet = false },
        )
    }

    selectedPassword?.let { password ->
        if (showEditSheet) {
            EditPassWordBottomSheet(
                onDismiss = { showEditSheet = false },
                passwordDto = password,
                onDelete = {
                    homeViewModel.deletePassword(password)
                    showEditSheet = false
                },
                onUpdate = { updatedPassword ->
                    homeViewModel.updatePassword(updatedPassword)
                    showEditSheet = false
                },
                context = context
            )
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
            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .weight(0.8f)
            ) {
                PasswordManagerTexts.TextAsBoldHeader(
                    text = "Password Manager",
                    color = MatteBlack,
                    size = 18,
                    modifier = Modifier.padding(10.dp)
                )
                Spacer(modifier = Modifier.size(5.dp))
                HorizontalDivider()
                Spacer(modifier = Modifier.size(30.dp))
                LazyColumn(modifier = Modifier.fillMaxSize()) {
                    items(passwords) { item ->
                    ItemPassword(heading = item.accountName, placeholder ="******" ){
                        selectedPassword = item
                        showEditSheet = true
                    }
                    }
                }
            }
            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .wrapContentHeight()
                    .padding(10.dp)
            ) {
                Row(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.End
                ) {
                    NewPasswordButton {
                        showSheet = true
                    }
                }
            }
        }
    }
}

