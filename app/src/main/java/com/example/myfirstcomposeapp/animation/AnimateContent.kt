package com.example.myfirstcomposeapp.animation // Asegúrate de que este sea el paquete correcto

import androidx.compose.animation.AnimatedContent
import androidx.compose.animation.ContentTransform
import androidx.compose.animation.fadeIn
import androidx.compose.animation.fadeOut
import androidx.compose.animation.scaleIn
import androidx.compose.animation.scaleOut
import androidx.compose.animation.slideInHorizontally
import androidx.compose.animation.slideOutHorizontally
import androidx.compose.animation.slideInVertically
import androidx.compose.animation.slideOutVertically
import androidx.compose.animation.togetherWith
import androidx.compose.animation.core.tween
import androidx.compose.foundation.background
import androidx.compose.foundation.border
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
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

// Definimos un enum para representar los diferentes tipos de animación que queremos probar
enum class AnimationType {
    FADE,
    SLIDE_HORIZONTAL,
    SLIDE_VERTICAL,
    SCALE,
    FADE_AND_SLIDE_VERTICAL,
    FADE_AND_SCALE,
    SLIDE_AND_SCALE_HORIZONTAL,
    NONE // Sin animación (cambio abrupto)
}

@Composable
fun AllAnimatedContentTransitionsExample(modifier: Modifier = Modifier) {
    // Estado para controlar qué tipo de animación se está mostrando actualmente
    var currentAnimationType by remember { mutableStateOf(AnimationType.FADE) }
    // Estado para cambiar el contenido dentro de AnimatedContent (ej. un número)
    var contentValue by remember { mutableStateOf(0) }

    Column(
        modifier = modifier
            .fillMaxSize()
            .padding(16.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        // Botón para cambiar el tipo de animación
        Button(onClick = {
            // Cicla a través de los tipos de animación
            val nextIndex = (currentAnimationType.ordinal + 1) % AnimationType.entries.size
            currentAnimationType = AnimationType.entries[nextIndex]
            // También cambiamos el valor del contenido para que la animación se dispare
            contentValue++
        }) {
            Text("Cambiar Animación (${currentAnimationType.name.replace("_", " ")})")
        }

        Spacer(Modifier.height(32.dp))

        // Botón para cambiar el contenido sin cambiar el tipo de animación
        Button(onClick = { contentValue++ }) {
            Text("Cambiar Contenido (Valor: $contentValue)")
        }

        Spacer(Modifier.height(32.dp))

        // AnimatedContent: El corazón de las animaciones
        AnimatedContent(
            targetState = contentValue, // El estado que AnimatedContent observará
            // Aquí definimos la especificación de la transición basada en el tipo de animación actual
            transitionSpec = {
                when (currentAnimationType) {
                    AnimationType.FADE -> fadeIn(tween(500)) togetherWith fadeOut(tween(500))
                    AnimationType.SLIDE_HORIZONTAL -> slideInHorizontally(tween(500)) { -it } togetherWith slideOutHorizontally(tween(500)) { it }
                    AnimationType.SLIDE_VERTICAL -> slideInVertically(tween(500)) { -it } togetherWith slideOutVertically(tween(500)) { it }
                    AnimationType.SCALE -> scaleIn(tween(500), initialScale = 0.5f) togetherWith scaleOut(tween(500), targetScale = 0.5f)
                    AnimationType.FADE_AND_SLIDE_VERTICAL -> (fadeIn(tween(500)) + slideInVertically(tween(500)) { it }) togetherWith (fadeOut(tween(500)) + slideOutVertically(tween(500)) { -it })
                    AnimationType.FADE_AND_SCALE -> (fadeIn(tween(500)) + scaleIn(tween(500), initialScale = 0.7f)) togetherWith (fadeOut(tween(500)) + scaleOut(tween(500), targetScale = 0.7f))
                    AnimationType.SLIDE_AND_SCALE_HORIZONTAL -> (slideInHorizontally(tween(500)) { -it } + scaleIn(tween(500), initialScale = 0.8f)) togetherWith (slideOutHorizontally(tween(500)) { it } + scaleOut(tween(500), targetScale = 0.8f))
                    AnimationType.NONE -> ContentTransform(targetContentEnter = fadeIn(tween(0)), initialContentExit = fadeOut(tween(0))) // Sin animación real (duración 0)
                }
            }, label = "AnimatedContentTransitions"
        ) { animatedContent -> // 'animatedContent' es el valor actual que se está animando
            // El contenido que se animará
            Box(
                modifier = Modifier
                    .size(200.dp)
                    .background(Color.LightGray.copy(alpha = 0.3f))
                    .border(2.dp, Color.DarkGray)
                    .padding(16.dp),
                contentAlignment = Alignment.Center
            ) {
                Column(horizontalAlignment = Alignment.CenterHorizontally) {
                    Text(
                        text = "Valor: $animatedContent",
                        fontSize = 30.sp,
                        color = Color.Black
                    )
                    Text(
                        text = "Tipo: ${currentAnimationType.name.replace("_", " ")}",
                        fontSize = 16.sp,
                        color = Color.Gray
                    )
                }
            }
        }
    }
}
