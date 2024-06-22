package com.example.passwordmanager.commonComponents

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
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
import androidx.compose.ui.unit.dp
import com.example.passwordmanager.R
import com.example.passwordmanager.ui.theme.MatteBlack


@Composable
fun ItemPassword(heading: String  , placeholder: String  ,
                 onClick: () -> Unit = {}) {
    Box(
        modifier = Modifier
            .fillMaxWidth()
            .height(80.dp)
            .padding(10.dp)
            .clip(RoundedCornerShape(25.dp))
            .clickable(onClick = onClick)
            .background(Color.White),
        contentAlignment = Alignment.Center,

        ) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding( 10.dp),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            Row(verticalAlignment = Alignment.CenterVertically) {
                PasswordManagerTexts.TextAsBoldHeader(
                    text = heading,
                    color = MatteBlack,
                    size = 20,
                    modifier = Modifier.align(Alignment.CenterVertically))
                Spacer(modifier = Modifier.size(20.dp))
                PasswordManagerTexts.TextAsBoldHeader(
                    text = placeholder,
                    color = Color.Gray,
                    size = 15,
                    modifier = Modifier.align(Alignment.CenterVertically)
                )
            }
            PasswordManagerIcons(icon = R.drawable.ic_arrow_right, size = 20)
        }
    }
}