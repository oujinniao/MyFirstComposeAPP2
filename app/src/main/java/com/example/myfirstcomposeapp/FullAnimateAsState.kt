package com.example.myfirstcomposeapp

import androidx.compose.animation.animateColorAsState
import androidx.compose.animation.core.animateDpAsState
import androidx.compose.animation.core.animateFloatAsState // Importar animateFloatAsState
import androidx.compose.animation.core.animateOffsetAsState
import androidx.compose.animation.core.tween // Opcional: para controlar la duración de la animación
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.offset
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
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.graphicsLayer // Importar graphicsLayer para aplicar opacidad, rotación, escala
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp


@Composable
fun FullAnimatedAsState() {
    var isSelected: Boolean by remember { mutableStateOf(false) }
    val animatedColor: Color by animateColorAsState(
        targetValue = if (isSelected) Color.Red else Color.Blue
    )
    val animatedSize: Dp by animateDpAsState(
        targetValue = if (isSelected) 200.dp else 150.dp
    )
    val animatedOffset: Offset by animateOffsetAsState(
        targetValue = if (isSelected) Offset(0f, 100f)
        else Offset(0f, 0f)
    )
    val animatedRotation: Float by animateFloatAsState(
        targetValue = if (isSelected) 360f else 0f
    )
    val animatedOpacity: Float by animateFloatAsState(
        targetValue = if (isSelected) 0.5f else 1f
    )
    val animatedScale: Float by animateFloatAsState(
        targetValue = if (isSelected) 2f else 1f
    )
    val animatedTranslationX: Float by animateFloatAsState(
        targetValue = if (isSelected) 100f else 0f
    )
    val animatedTranslationY: Float by animateFloatAsState(
        targetValue = if (isSelected) 100f else 0f
    )
    val animatedFloat: Float by animateFloatAsState(
        targetValue = if (isSelected) 1.5f else 0f
    )

    Column(
        modifier = Modifier.fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Spacer(Modifier.height(50.dp))
        Button(onClick = { isSelected = !isSelected }) {
            Text("Cambiar Color")
        }
        Text("Float: %.2f".format(animatedFloat))

        Spacer(Modifier.height(50.dp))
        Box(
            modifier = Modifier
                .size(animatedSize) // Aplicar el tamaño animado
                .offset(x = animatedOffset.x.dp, y = animatedOffset.y.dp) // Aplicar el offset animado
                .graphicsLayer( // ¡¡¡Aplicar las animaciones de Float aquí!!!
                    rotationZ = animatedRotation,
                    alpha = animatedOpacity,
                    scaleX = animatedScale,
                    scaleY = animatedScale, // Aplicar la misma escala en X e Y
                    translationX = animatedTranslationX,
                    translationY = animatedTranslationY
                )
                .background(animatedColor) // Aplicar el color animado
        )
    }
}
