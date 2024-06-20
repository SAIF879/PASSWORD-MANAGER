package com.example.passwordmanager.commonComponents

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.size
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp

@Composable
fun PasswordManagerIcons(
    icon: Int,
    size: Int = 40,
    tint: Color? = null,
    modifier: Modifier = Modifier
) {
    Image(
        painter = painterResource(id = icon),
        contentDescription = null,
        modifier = modifier.size(size.dp),
        colorFilter = tint?.let { ColorFilter.tint(it) } // Applying color filter if tint color is provided
    )
}