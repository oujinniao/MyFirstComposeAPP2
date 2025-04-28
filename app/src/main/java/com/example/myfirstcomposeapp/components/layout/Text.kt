package com.example.myfirstcomposeapp.components.layout

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontStyle.Companion.Italic
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.font.FontWeight.Companion.Black
import androidx.compose.ui.text.font.FontWeight.Companion.Bold
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.sp


@Composable

fun MyTexts(modifier: Modifier) {
    Column(modifier = modifier) {

        Text("KKN", modifier = modifier)
        Text(text = "kkn azul", color = Color.DarkGray)
        Text(text = "kkn rojo", color = Color.Red)
        Text(text = "kkn verde", color = Color.Green)
        Text(text = "kkn amarillo", color = Color.Yellow)
        Text(text = "kkn magenta", color = Color.Magenta)
        Text(text = "kkn cyan", color = Color.Cyan)
        Text(text = "kkn blanco", color = Color.White)
        Text(text = "kkn negro", fontStyle = Italic)
        Text(text = "kkn", fontSize = 50.sp)
        Text("fontstilos", fontStyle = FontStyle.Italic)
        Text("tipos de letras", fontStyle = FontStyle.Normal)
        Text("FontWeight", fontWeight = Bold)
        Text("kkn", fontWeight = Bold)
        Text("kkn", fontWeight = Black)
        Text("kkn", fontWeight = Black)
        Text("kkn", fontWeight = Black)
        Text("kkn", fontWeight = Black)
        Text("kkn", fontWeight = Black)
        Text(
            "fontFamyli",
            fontWeight = FontWeight.Normal,
            fontStyle = FontStyle.Italic,
            fontSize = 45.sp
        )
Text("letter spacing", letterSpacing = 10.sp, fontSize = 30.sp, fontWeight = FontWeight.Bold)
Text("text decoration", textDecoration = TextDecoration.Underline, color= Color.Blue)
Text("text decoretion",
    textDecoration = TextDecoration.Underline + TextDecoration.LineThrough)

        Text(
    "alineacion mmmmmmmmmmmmmmmmhhhhhhmmmmmmmmmmmmmmmmmmmmmmmm",
    textAlign = TextAlign.Start, fontSize = 40.sp,
    modifier=Modifier.fillMaxWidth().background(Color.Green),
            maxLines = 1,
            overflow = TextOverflow.Ellipsis

)
    }
}
