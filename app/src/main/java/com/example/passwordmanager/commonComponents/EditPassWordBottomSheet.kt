package com.example.passwordmanager.commonComponents

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.BottomSheetDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.ModalBottomSheet
import androidx.compose.material3.rememberModalBottomSheetState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import com.example.passwordmanager.mainflow.home.util.HomeViewModel
import com.example.passwordmanager.ui.theme.MatteBlack
import com.example.passwordmanager.ui.theme.MatteRed

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun EditPassWordBottomSheet(onDismiss: () -> Unit, passwordViewModel: HomeViewModel) {
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


                GenerateFillUpBox(detailText = accountName, placeHolder = "Account Name")
                GenerateFillUpBox(detailText = userCredential, placeHolder = "Username/ Email")
//                GenerateFillUpBox(detailText = password, placeHolder = "Password")
                GenerateFillUpBox(detailText = password, placeHolder ="Password" )

                Spacer(modifier = Modifier.height(16.dp))


                Row(modifier = Modifier.fillMaxWidth() ,
                    verticalAlignment = Alignment.CenterVertically ,
                    horizontalArrangement = Arrangement.SpaceAround) {

                    InputButton(text = "Edit", color = MatteBlack  ){

                    }
                    InputButton(text = "Delete", color = MatteRed ){

                    }

                }
            }
        }
    }
}