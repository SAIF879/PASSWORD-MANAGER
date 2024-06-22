package com.example.passwordmanager.commonComponents


import android.content.Context
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.BottomSheetDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.ModalBottomSheet
import androidx.compose.material3.rememberModalBottomSheetState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import com.example.passwordmanager.mainflow.home.util.HomeViewModel
import com.example.passwordmanager.room.model.PasswordDto
import com.example.passwordmanager.utils.extentions.showToast
import com.example.passwordmanager.utils.utilityFunctions.validateInputs


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun BottomSheet( passwordViewModel: HomeViewModel , context : Context,onDismiss: () -> Unit) {
    val modalBottomSheetState = rememberModalBottomSheetState()
    var accountName = remember { mutableStateOf("") }
    var userCredential = remember { mutableStateOf("") }
    var password = remember { mutableStateOf("") }


    ModalBottomSheet(
        onDismissRequest = { onDismiss() },
        sheetState = modalBottomSheetState,
        dragHandle = { BottomSheetDefaults.DragHandle() },
        containerColor = Color.White,
        scrimColor = Color.Black.copy(alpha = .5f),
    ) {
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .height(400.dp)
        ) {
            Column(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(16.dp)
            ) {
                GenerateInputBox(
                    detailText = accountName,
                    placeHolder = "Account Name")
                GenerateInputBox(
                    detailText = userCredential,
                    placeHolder = "Username/ Email")
                GenerateInputBox(
                    detailText = password,
                    placeHolder = "Password" ,
                    showIcon = true)

                Spacer(modifier = Modifier.height(16.dp))

                NewAccountButton {
                    val errors = validateInputs(accountName.value, userCredential.value, password.value)

                    if (errors.isEmpty()) {
                        val newPassword = PasswordDto(
                            accountName = accountName.value,
                            userCredential = userCredential.value,
                            password = password.value
                        )
                        passwordViewModel.addPassword(newPassword)
                        onDismiss() // Close the bottom sheet after adding
                    } else {
                        errors.forEach { context.showToast( it) }
                    }
                }
            }
        }
    }
}
