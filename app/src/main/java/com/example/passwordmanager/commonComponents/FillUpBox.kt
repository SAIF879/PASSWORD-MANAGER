package com.example.passwordmanager.commonComponents

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.OutlinedTextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.unit.dp
import com.example.passwordmanager.ui.theme.MatteGray


@Composable
fun GenerateInputBox(
    detailText: MutableState<String>,
    placeHolder: String,
    enabled: Boolean = true,
) {
    OutlinedTextField(
        value = detailText.value,
        label = { PasswordManagerTexts.TextAsDefault(text = placeHolder ,
            color = MatteGray) },
        onValueChange = {
            detailText.value = it
        },
        modifier = Modifier
            .fillMaxWidth()
            .height(80.dp)
            .padding(20.dp, 10.dp),
        enabled = enabled,
        shape = RoundedCornerShape(16.dp),
        colors = OutlinedTextFieldDefaults.colors(
            focusedBorderColor = MatteGray,
            unfocusedBorderColor = MatteGray,
            disabledBorderColor = Color.Transparent,
            focusedLabelColor = MatteGray,
        ),
        singleLine = true ,
        keyboardOptions = KeyboardOptions(
            keyboardType = KeyboardType.Text,
            imeAction = ImeAction.Next // Use Next as the IME action
        ),

    )
}
