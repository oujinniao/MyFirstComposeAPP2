package com.example.myfirstcomposeapp.components.layout

import android.graphics.drawable.Icon
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.FilledTonalButton
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.FloatingActionButtonDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.runtime.internal.enableLiveLiterals
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextRange
import androidx.compose.ui.unit.dp
import com.example.myfirstcomposeapp.R
import kotlin.enums.enumEntries

@Composable
fun MyButtons(modifier: Modifier) {
    Column(modifier = modifier) {
        Button(
            onClick = { },
            enabled = true,
            shape = RoundedCornerShape(25.dp),
            border = BorderStroke(2.dp, Color.Magenta),
            colors = ButtonDefaults.buttonColors(
                contentColor = Color.Red,
                containerColor = Color.White,
                disabledContentColor = Color.Yellow,
                disabledContainerColor = Color.Green
                //con estos 4 colores podemos personalizar cada componente del boton
            )


        ) {
            Text("PINCHA AQUï", color = Color.Black)
        }
        OutlinedButton(
            onClick = { },
            enabled = true,
            shape = RoundedCornerShape(25.dp),
            border = BorderStroke(2.dp, Color.Magenta),
            colors = ButtonDefaults.buttonColors(
                contentColor = Color.Red,
                containerColor = Color.White,
                disabledContentColor = Color.Yellow,
                disabledContainerColor = Color.Green
                //con estos 4 colores podemos personalizar cada componente del boton
            )
        ) {

            Text("PINCHA AQUI")

        }

        OutlinedButton(
            onClick = { },
            enabled = true,
            shape = RoundedCornerShape(25.dp),
            border = BorderStroke(2.dp, Color.LightGray),
            colors = ButtonDefaults.buttonColors(
                containerColor = Color.Blue,
                contentColor = Color.White,
                disabledContainerColor = Color.Green,
                disabledContentColor = Color.Yellow,
            )

        ) {
            Text("kkKKKKKK")
        }
            TextButton(onClick =  { }){
                Text("Valparaiso", color = Color.White)
            }
        FilledTonalButton(onClick =  { }){}
        Button(onClick = { }){}
        }
    }


@Composable
fun MyButtonExample(modifier: Modifier=Modifier) {
    FloatingActionButton(onClick = { }, shape = CircleShape,
        containerColor = Color.Red,
        contentColor = Color.White,
        elevation = FloatingActionButtonDefaults.elevation(defaultElevation = 12.dp)) {
    Icon(painter = painterResource(id = R.drawable.baseline_add_24),
        contentDescription = null)


    }
}
