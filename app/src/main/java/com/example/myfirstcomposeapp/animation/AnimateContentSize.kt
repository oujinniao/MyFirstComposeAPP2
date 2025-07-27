package com.example.myfirstcomposeapp.animation

import androidx.compose.animation.animateContentSize
import androidx.compose.animation.core.animateDpAsState // Importar animateDpAsState
import androidx.compose.animation.core.tween // Opcional: para controlar la duración
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height // ¡¡¡Asegúrate de que esta importación esté aquí!!!
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier // ¡¡¡Asegúrate de que esta importación esté aquí!!!
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp // ¡¡¡Asegúrate de que esta importación esté aquí!!!

@Composable
fun MyContentSizeAnimated(modifier: Modifier = Modifier) {
    var expanded by remember { mutableStateOf(false) }

    // Aquí animamos la altura!
    val animatedHeight by animateDpAsState(
        targetValue = if (expanded) 400.dp else 250.dp,
        animationSpec = tween(durationMillis = 500), // Animación de 0.5 segundos
        label = "BoxHeightAnimation"
    )

    Column(
        modifier = modifier.fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center

    ) {

        Box(
            Modifier
                .fillMaxWidth()
                .height(animatedHeight)
                .background(Color.Blue)
                .animateContentSize()
                .clickable { expanded = !expanded }

        ) {
            Text("Luiizi", color = Color.White)
        }
    }
}
