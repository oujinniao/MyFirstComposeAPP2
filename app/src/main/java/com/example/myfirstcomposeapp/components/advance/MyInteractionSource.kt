package com.example.myfirstcomposeapp.components.advance

import androidx.compose.foundation.background // Para Modifier.background
import androidx.compose.foundation.clickable // Para Modifier.clickable
import androidx.compose.foundation.interaction.MutableInteractionSource // Para InteractionSource
import androidx.compose.foundation.interaction.collectIsPressedAsState // Para collectIsPressedAsState
import androidx.compose.foundation.layout.Box // Para Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize // Para Modifier.fillMaxSize en Preview
import androidx.compose.foundation.layout.size // Para Modifier.size
import androidx.compose.foundation.shape.CircleShape // Para CircleShape
import androidx.compose.material3.Button
import androidx.compose.material3.Text // Para Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment // Para Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip // Para Modifier.clip (si usas CircleShape con background)
import androidx.compose.ui.draw.shadow // Para Modifier.shadow
import androidx.compose.ui.graphics.Color // Para Color
import androidx.compose.ui.tooling.preview.Preview // Para Preview
import androidx.compose.ui.unit.dp // Para .dp
import com.example.myfirstcomposeapp.ui.theme.MyFirstComposeAPPTheme


@Composable

fun InteractionSourceExample(modifier: Modifier=Modifier) {
    val interactionSource:MutableInteractionSource = remember { MutableInteractionSource() }
    val isPressed:Boolean by interactionSource.collectIsPressedAsState()

    Box(
        modifier = Modifier
        .size(100.dp)
            .shadow(4.dp, shape = CircleShape)
            .background(if (isPressed) Color.Red else Color.Blue)
            .clickable(interactionSource = interactionSource, indication = null) {

            },
        contentAlignment = Alignment.Center

    ){
        Column {
            Button(onClick = { }, interactionSource = interactionSource) {Text(text="Click Me") }
            Text(text=if(isPressed) "Pressed" else "Not Pressed")
        }



    }



}