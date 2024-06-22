package com.example.passwordmanager.commonComponents

import android.content.Context
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.BottomSheetDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.ModalBottomSheet
import androidx.compose.material3.rememberModalBottomSheetState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import com.example.passwordmanager.room.model.PasswordDto
import com.example.passwordmanager.ui.theme.MatteBlack
import com.example.passwordmanager.ui.theme.MatteBlue
import com.example.passwordmanager.ui.theme.MatteRed
import com.example.passwordmanager.utils.extentions.showToast
import com.example.passwordmanager.utils.utilityFunctions.validateInputs

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun EditPassWordBottomSheet(
    context : Context,
    passwordDto: PasswordDto,
    onDelete: () -> Unit = {},
    onDismiss: () -> Unit,
    onUpdate: (PasswordDto) -> Unit
) {
    val modalBottomSheetState = rememberModalBottomSheetState()
    var accountName = remember { mutableStateOf(passwordDto.accountName) }
    var userCredential = remember { mutableStateOf(passwordDto.userCredential) }
    var password = remember { mutableStateOf(passwordDto.password) }
    var isEnabled by remember { mutableStateOf(false) }

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
                .height(450.dp)
        ) {
            Column(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(16.dp)
            ) {
                Row(modifier = Modifier.fillMaxWidth() .padding(20.dp, 10.dp),) {
                    PasswordManagerTexts.
                    TextAsBoldHeader(text = "Account Details" , 
                        color = MatteBlue , 
                        size = 22)
                }
                Spacer(modifier = Modifier.size(20.dp))
                GenerateInputBox(detailText = accountName,
                    placeHolder = "Account Name",
                    enabled = isEnabled)
                GenerateInputBox(detailText = userCredential,
                    placeHolder = "Username/ Email",
                    enabled = isEnabled)
                GenerateInputBox(detailText = password,
                    placeHolder = "Password",
                    enabled = isEnabled ,
                    showIcon = true)

                Spacer(modifier = Modifier.height(16.dp))

                Row(
                    modifier = Modifier.fillMaxWidth(),
                    verticalAlignment = Alignment.CenterVertically,
                    horizontalArrangement = Arrangement.SpaceAround
                ) {
                    if (!isEnabled) {
                        InputButton(text = "Edit", color = MatteBlack) {
                            isEnabled = true
                        }
                    } else {
                        InputButton(text = "Save", color = MatteBlack) {
                            val errors = validateInputs(accountName.value,
                                userCredential.value, password.value)
                            if (errors.isEmpty()){
                                onUpdate(PasswordDto(accountName.value,
                                    userCredential.value,
                                    password.value))
                                isEnabled = false
                            }
                            else {
                                errors.forEach { context.showToast( it) }
                            }

                        }
                    }

                    InputButton(text = "Delete", color = MatteRed) {
                        onDelete.invoke()
                    }
                }
            }
        }
    }
}
