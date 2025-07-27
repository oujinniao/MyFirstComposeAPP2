package com.example.myfirstcomposeapp.animation

import androidx.compose.animation.core.LinearEasing
import androidx.compose.animation.core.RepeatMode
import androidx.compose.animation.core.animateFloat
import androidx.compose.animation.core.infiniteRepeatable
import androidx.compose.animation.core.rememberInfiniteTransition
import androidx.compose.animation.core.tween
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.graphicsLayer
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun ControllablePulsingBoxExample(modifier: Modifier = Modifier) {
    // Estado para controlar si la animación está activa o no
    var isAnimationActive by remember { mutableStateOf(true) }

    Column(
        modifier = modifier.fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        Button(onClick = {
            // Alternar el estado de la animación
            isAnimationActive = !isAnimationActive
        }) {
            Text(if (isAnimationActive) "Detener Animación" else "Iniciar Animación")
        }

        Spacer(Modifier.height(32.dp))

        // ¡¡¡Control Condicional de la Composición!!!
        // Solo si isAnimationActive es true, el Composable PulsingBox se compondrá
        if (isAnimationActive) {
            PulsingBox() // Llamamos a un Composable separado que contiene la InfiniteTransition
        } else {
            // Cuando la animación está detenida, mostramos un Box estático
            Box(
                modifier = Modifier
                    .size(150.dp)
                    .background(Color.Gray.copy(alpha = 0.5f)), // Color gris para indicar que está inactivo
                contentAlignment = Alignment.Center
            ) {
                Text("Inactivo", color = Color.White, fontSize = 20.sp)
            }
        }

        Spacer(Modifier.height(32.dp))
        Text(
            text = "Haz clic en el botón para iniciar/detener la pulsación.",
            fontSize = 14.sp,
            color = Color.Gray,
            modifier = Modifier.padding(horizontal = 16.dp)
        )
    }
}

// Composable separado que contiene la lógica de la InfiniteTransition
// Esto es una buena práctica para que el control condicional sea más limpio
@Composable
fun PulsingBox(modifier: Modifier = Modifier) {
    // 1. Crear la instancia de InfiniteTransition
    val infiniteTransition = rememberInfiniteTransition(label = "PulsingBoxTransition")

    // 2. Definir la animación de escala (Float)
    val animatedScale by infiniteTransition.animateFloat(
        initialValue = 1f,
        targetValue = 1.2f,
        animationSpec = infiniteRepeatable(
            animation = tween(durationMillis = 1000, easing = LinearEasing),
            repeatMode = RepeatMode.Reverse
        ),
        label = "BoxScale"
    )

    // 3. Definir la animación de opacidad (Float)
    val animatedAlpha by infiniteTransition.animateFloat(
        initialValue = 1f,
        targetValue = 0.6f,
        animationSpec = infiniteRepeatable(
            animation = tween(durationMillis = 1000, easing = LinearEasing),
            repeatMode = RepeatMode.Reverse
        ),
        label = "BoxAlpha"
    )

    Box(
        modifier = modifier
            .size(150.dp)
            .graphicsLayer(
                scaleX = animatedScale,
                scaleY = animatedScale,
                alpha = animatedAlpha
            )
            .background(Color.Green),
        contentAlignment = Alignment.Center
    ) {
        Text("¡Pulsando!", color = Color.White, fontSize = 20.sp)
    }
}