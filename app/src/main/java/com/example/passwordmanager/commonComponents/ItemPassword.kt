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
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.DeleteForever
import androidx.compose.material3.Icon
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.passwordmanager.R
import com.example.passwordmanager.room.model.PasswordDto
import com.example.passwordmanager.ui.theme.MatteBlack
import com.example.passwordmanager.ui.theme.MatteRed
import me.saket.swipe.SwipeAction
import me.saket.swipe.SwipeableActionsBox


@Composable
fun SwipeablePasswordCard(
    heading: String = "Google", placeholder: String = "*******",
    onDelete: () -> Unit,
    onClick: () -> Unit
) {
    val deleteAction = SwipeAction(
        onSwipe = { onDelete() },
        icon = {
            Icon(
                imageVector = Icons.Filled.DeleteForever,
                contentDescription = "Delete",
                tint = Color.White,
                modifier = Modifier.padding(20.dp)
            )
        },
        background = MatteRed
    )

    SwipeableActionsBox(endActions = listOf(deleteAction), swipeThreshold = 150.dp) {
        ItemPassword(heading , placeholder, onClick = onClick)
    }
}
@Preview
@Composable
fun ItemPassword(heading: String = "Google", placeholder: String = "*******" ,
                 onClick: () -> Unit = {}) {
    Box(
        modifier = Modifier
            .fillMaxWidth()
            .height(80.dp)
            .padding(10.dp)
            .clip(RoundedCornerShape(20.dp))
            .clickable(onClick = onClick)
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