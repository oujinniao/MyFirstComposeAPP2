package com.example.myfirstcomposeapp.animation

import androidx.compose.animation.core.LinearEasing // Para una animación de velocidad constante
import androidx.compose.animation.core.RepeatMode // Para definir el modo de repetición
import androidx.compose.animation.core.animateFloat // Para animar valores flotantes
import androidx.compose.animation.core.infiniteRepeatable // Para animaciones que se repiten
import androidx.compose.animation.core.rememberInfiniteTransition // ¡Importar rememberInfiniteTransition!
import androidx.compose.animation.core.tween // Para controlar la duración
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue // Para delegar la propiedad de estado
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.graphicsLayer // Para aplicar escala y opacidad
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun PulsingBoxExample(modifier: Modifier = Modifier) {
    // 1. Crear la instancia de InfiniteTransition
    val infiniteTransition = rememberInfiniteTransition(label = "PulsingBoxTransition")

    // 2. Definir la animación de escala (Float)
    val animatedScale by infiniteTransition.animateFloat(
        initialValue = 1f, // Empieza en tamaño normal
        targetValue = 1.2f, // Pulsa hasta 1.2 veces su tamaño
        animationSpec = infiniteRepeatable( // Especificación para repetición infinita
            animation = tween(durationMillis = 1000, easing = LinearEasing), // Dura 1 segundo
            repeatMode = RepeatMode.Reverse // Va y viene (pulsa suavemente)
        ),
        label = "BoxScale"
    )

    // 3. Definir la animación de opacidad (Float)
    val animatedAlpha by infiniteTransition.animateFloat(
        initialValue = 1f, // Empieza totalmente opaco
        targetValue = 0.6f, // Pulsa hasta 60% de opacidad
        animationSpec = infiniteRepeatable(
            animation = tween(durationMillis = 1000, easing = LinearEasing), // Dura 1 segundo
            repeatMode = RepeatMode.Reverse // Va y viene (pulsa suavemente)
        ),
        label = "BoxAlpha"
    )

    Column(
        modifier = modifier.fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        Text(
            text = "Caja Pulsante",
            fontSize = 24.sp,
            modifier = Modifier.padding(bottom = 32.dp)
        )

        // El Box que aplicará las animaciones
        Box(
            modifier = Modifier
                .size(150.dp)
                .graphicsLayer(
                    scaleX = animatedScale, // Aplica la escala animada en X
                    scaleY = animatedScale, // Aplica la escala animada en Y
                    alpha = animatedAlpha // Aplica la opacidad animada
                )
                .background(Color.Green), // Color de fondo del Box
            contentAlignment = Alignment.Center
        ) {
            Text("¡Pulsando!", color = Color.White, fontSize = 20.sp)
        }
        Spacer(Modifier.height(32.dp))
        Text(
            text = "Observa cómo la caja cambia de tamaño y se desvanece suavemente.",
            fontSize = 14.sp,
            color = Color.Gray,
            modifier = Modifier.padding(horizontal = 16.dp)
        )
    }
}
