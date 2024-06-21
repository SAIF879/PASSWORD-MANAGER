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
import com.example.passwordmanager.ui.theme.BackGroundColor
import com.example.passwordmanager.ui.theme.MatteBlack
import com.example.passwordmanager.utils.extentions.showToast
import kotlinx.coroutines.launch

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun HomeScreen(passwordViewModel: HomeViewModel = hiltViewModel()) {
    val context = LocalContext.current
    var showSheet by remember { mutableStateOf(false) }
    var showEditSheet by remember { mutableStateOf(false) }

    if (showSheet) {
        BottomSheet(
            onDismiss = { showSheet = false },
            passwordViewModel = passwordViewModel
        )
    }

    if (showEditSheet) {
        EditPassWordBottomSheet(onDismiss = { showEditSheet = false },
            passwordViewModel = passwordViewModel)
    }

    val passwords by passwordViewModel.passwords.collectAsState()

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
                PasswordManagerTexts.TextAsBoldHeader(
                    text = "Password Manager",
                    color = MatteBlack,
                    size = 18,
                    modifier = Modifier.padding(10.dp)
                )
                Spacer(modifier = Modifier.size(5.dp))
                HorizontalDivider()
                LazyColumn(modifier = Modifier.fillMaxSize()) {
                    items(passwords) { item ->
                        SwipeablePasswordCard( heading = item.accountName ,
                            placeholder = "******",
                            onDelete = { passwordViewModel.deletePassword(item)} ,
                            onClick = {showEditSheet = true})
                    }
                }
            }
            Column(modifier = Modifier
                .fillMaxWidth()
                .weight(0.1f)
                .padding(10.dp)) {
                Row(modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.End) {
                    NewPasswordButton {
                        showSheet = true
                    }
                }
            }
        }
    }
}
