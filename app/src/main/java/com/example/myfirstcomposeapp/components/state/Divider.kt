package com.example.myfirstcomposeapp.components.state

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.height
import androidx.compose.material3.BadgedBox
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Text
import androidx.compose.material3.VerticalDivider
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Color.Companion.Red
import androidx.compose.ui.unit.dp

@Composable
fun MyDivider(modifier: Modifier = Modifier) {
    Column (modifier=modifier)  {
        Text(text = "Hola semana conconina")
        HorizontalDivider(

            thickness = 33.dp, color=Red,
        )
        //VerticalDivider()
        Text(text = "Hola semana conconina")

        Row (modifier=modifier.height(150.dp)){
            Text(text = "Hola semana conconina")
            VerticalDivider(thickness = 10.dp, color = Color.Green)
            Text(text = "Hola semana conconina")

        }


    }
     }