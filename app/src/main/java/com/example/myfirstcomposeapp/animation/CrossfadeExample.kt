package com.example.myfirstcomposeapp.animation

import androidx.compose.animation.Crossfade // Importar Crossfade
import androidx.compose.animation.core.tween // Para personalizar la duración
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
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
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.foundation.layout.Spacer

// Definimos un enum para representar los diferentes estados de contenido
enum class ContentState {
    VIEW_A,
    VIEW_B
}

@Composable
fun CrossfadeExample(modifier: Modifier = Modifier) {
    var currentContentState by remember { mutableStateOf(ContentState.VIEW_A) }

    Column(
        modifier = modifier.fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        Button(onClick = {
            // Alternar entre los estados
            currentContentState = if (currentContentState == ContentState.VIEW_A) {
                ContentState.VIEW_B
            } else {
                ContentState.VIEW_A
            }
        }) {
            Text("Cambiar Vista")
        }

        // Espacio para separar el botón del contenido animado
        Spacer(Modifier.size(32.dp))

        // Usamos Crossfade para animar la transición entre las vistas
        Crossfade(
            targetState = currentContentState,
            animationSpec = tween(durationMillis = 1000), // Animación de 1 segundo
            label = "ContentCrossfade"
        ) { targetState -> // 'targetState' es el valor actual del estado que se está animando
            when (targetState) {
                ContentState.VIEW_A -> {
                    Box(
                        modifier = Modifier
                            .size(200.dp)
                            .background(Color.Green)
                            .padding(16.dp),
                        contentAlignment = Alignment.Center
                    ) {
                        Text("Vista A", fontSize = 24.sp, color = Color.White)
                    }
                }
                ContentState.VIEW_B -> {
                    Box(
                        modifier = Modifier
                            .size(200.dp)
                            .background(Color.Magenta)
                            .padding(16.dp),
                        contentAlignment = Alignment.Center
                    ) {
                        Text("Vista B", fontSize = 24.sp, color = Color.White)
                    }
                }
            }
        }
    }
}