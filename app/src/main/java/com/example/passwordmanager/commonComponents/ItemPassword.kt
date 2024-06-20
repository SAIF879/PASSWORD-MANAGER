package com.example.passwordmanager.commonComponents

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.passwordmanager.R
import com.example.passwordmanager.ui.theme.MatteBlack

@Preview
@Composable
fun ItemPassword(heading: String = "Google", placeholder: String = "*******") {
    Box(
        modifier = Modifier
            .fillMaxWidth()
            .height(80.dp)
            .padding(10.dp)
            .clip(RoundedCornerShape(20.dp))
            .background(Color.White),
        contentAlignment = Alignment.Center,

        ) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 10.dp),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            Row {
                PasswordManagerTexts.TextAsBoldHeader(
                    text = heading,
                    color = MatteBlack,
                    size = 20)
                Spacer(modifier = Modifier.size(10.dp))
                PasswordManagerTexts.TextAsBoldHeader(
                    text = placeholder,
                    color = Color.Gray,
                    size = 20,
                    modifier = Modifier.align(Alignment.CenterVertically)
                )
            }
            PasswordManagerIcons(icon = R.drawable.ic_arrow_right, size = 20)
        }
    }
}