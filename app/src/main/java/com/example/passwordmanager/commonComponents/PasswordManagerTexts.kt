package com.example.passwordmanager.commonComponents

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Color.Companion.White
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.sp

object PasswordManagerTexts{


    @Composable
    fun TextAsBoldHeader(text: String, color: Color = White, size : Int = 32, maxLines: Int = 1){
        Text(text = text, style = TextStyle(
            fontFamily = FontFamily.Monospace,
            fontSize = size.sp,
            color = color
        ) , textAlign = TextAlign.Center , maxLines = maxLines)
    }

    @Composable
    fun TextAsSans(text:String, color: Color = White, fontSize: Int = 15 ){
        Text(text = text, style = TextStyle(
            fontFamily = FontFamily.SansSerif,
            fontSize = fontSize.sp,
            color = color
        ) , textAlign = TextAlign.Center ,)
    }

    @Composable
    fun TextAsDefault(text: String, color: Color = Color.Black, fontSize: Int= 12) {
        Text(
            text = text, style = TextStyle(
                fontFamily =FontFamily.Default,
                fontSize = fontSize.sp,
                color = color
            ), textAlign = TextAlign.Start, maxLines = 1
        )
    }



}

@Preview
@Composable
fun TextsPreview() {
    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.Black)
    ) {
        Column(
            modifier = Modifier.fillMaxSize(),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            PasswordManagerTexts.TextAsBoldHeader(text = "bold header")
            PasswordManagerTexts.TextAsDefault(text = "hint" , color = White)
            PasswordManagerTexts.TextAsSans(text = "sans text")
        }

    }
}