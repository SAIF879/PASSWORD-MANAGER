package com.example.passwordmanager.commonComponents


import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.WindowInsets
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.material3.BottomSheetDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.ModalBottomSheet
import androidx.compose.material3.rememberModalBottomSheetState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import com.example.passwordmanager.ui.theme.ContainerColor


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun BottomSheet(onDismiss: () -> Unit) {
    val modalBottomSheetState = rememberModalBottomSheetState()
    var accountName = remember {
        mutableStateOf("")
    }
    var userCredential = remember {
        mutableStateOf("")
    }
    var password = remember {
        mutableStateOf("")
    }

    ModalBottomSheet(
        onDismissRequest = { onDismiss() },
        sheetState = modalBottomSheetState,
        dragHandle = { BottomSheetDefaults.DragHandle() },
        containerColor = Color.White,
        scrimColor = Color.Black.copy(alpha = .5f),


    ) {
     Box(modifier = Modifier
         .fillMaxWidth()
         .height(400.dp)){
         Column(modifier = Modifier
             .fillMaxSize()
             .padding(10.dp)) {

             GenerateFillUpBox(detailText = accountName, placeHolder ="Account Name" )
             GenerateFillUpBox(detailText = userCredential, placeHolder ="Username/ Email")
             GenerateFillUpBox(detailText = password, placeHolder ="Password" )
             NewAccountButton{

             }


         }
     }
    }
}