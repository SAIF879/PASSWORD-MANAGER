package com.example.passwordmanager.commonComponents

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.passwordmanager.R
import com.example.passwordmanager.ui.theme.MatteBlack
import com.example.passwordmanager.ui.theme.MatteBlue
import com.example.passwordmanager.ui.theme.MatteRed

@Composable
fun NewAccountButton(
    text: String ="Add New Account",
    horizontalPadding: Int = 15,
    verticalPadding: Int=10,
    isEnabled: Boolean = true,
    modifier: Modifier = Modifier,
    height : Int = 72,
    onClick: () -> Unit = {}
) {
    Button(
        onClick = { onClick.invoke() },
        modifier = modifier
            .fillMaxWidth()
            .height(height.dp)
            .padding(horizontalPadding.dp, verticalPadding.dp),


        colors = ButtonDefaults.buttonColors(containerColor = MatteBlack  ,
            disabledContainerColor = Color.Transparent,  ),
        shape = RoundedCornerShape(10.dp),
        enabled = isEnabled
    ) {

        if (isEnabled){
            PasswordManagerTexts.TextAsBoldHeader(text = text , size = 16)
        }
    }
}


@Composable
fun InputButton(
    text: String ,
    horizontalPadding: Int = 15,
    verticalPadding: Int=10,
    isEnabled: Boolean = true,
    modifier: Modifier = Modifier,
    width : Int = 154,
    height: Int=60,
    color: Color,
    onClick: () -> Unit = {}
) {
    Button(
        onClick = { onClick.invoke() },
        modifier = modifier
            .width(width.dp)
            .height(height.dp)
            .padding(horizontalPadding.dp, verticalPadding.dp),


        colors = ButtonDefaults.buttonColors(containerColor = color  ,
            disabledContainerColor = Color.Transparent,  ),
        shape = RoundedCornerShape(16.dp),
        enabled = isEnabled
    ) {

        if (isEnabled){
            PasswordManagerTexts.TextAsBoldHeader(text = text , size = 16)
        }
    }
}


@Composable
fun NewPasswordButton(
    modifier: Modifier=Modifier,
    onClick:   () -> Unit = {}
) {
    Button(onClick = { onClick.invoke() }, modifier = modifier
        .width(70.dp)
        .height(70.dp) , colors = ButtonDefaults.buttonColors(
        containerColor = MatteBlue
    ) ,
        shape = RoundedCornerShape(10.dp)
    ) {

        PasswordManagerIcons(icon = R.drawable.ic_add , size = 50 , tint = Color.White )
    }
}



@Preview
@Composable
fun PreviewButtons(){
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
            NewAccountButton();
            InputButton("Edit" , color = MatteBlack);
            InputButton("Delete" , color = MatteRed);
            NewPasswordButton();

        }

    }
}
