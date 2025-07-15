package com.example.myfirstcomposeapp.components.cards

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp

@Composable
fun MiTarjetaDeEjemplo() {
    Card(
        shape = RoundedCornerShape(16.dp),//esquinas redondeadas
        elevation = CardDefaults.cardElevation(defaultElevation = 4.dp),//sombra)
        colors = CardDefaults.cardColors(
            containerColor = Color.White,
        ), modifier = Modifier.fillMaxWidth(),
        ) {//aqui va el contenido de la tarjeta

        Column (modifier = Modifier.padding(16.dp)){
            Spacer(Modifier.height(4.dp))
            Text(text = "Título de la tarjeta")
            Text(text = "Contenido de la tarjeta")
            Text(text = "Más contenido")
            Spacer(Modifier.height(4.dp))
            Text(text = "esta es una descripcion corta de lo que hay en la tarjeta")

        }


    }
}
