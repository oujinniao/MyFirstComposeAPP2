package com.example.myfirstcomposeapp.components.advance



import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.interaction.DragInteraction // Importar DragInteraction
import androidx.compose.foundation.interaction.HoverInteraction // Importar HoverInteraction
import androidx.compose.foundation.interaction.MutableInteractionSource // Importar MutableInteractionSource
import androidx.compose.foundation.interaction.PressInteraction // Importar PressInteraction
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.ripple.rememberRipple // Importar rememberRipple para el efecto de onda
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.myfirstcomposeapp.ui.theme.MyFirstComposeAPPTheme

@Composable
fun MyInteractiveButton(modifier: Modifier = Modifier) {
    // 1. Crear el "sensor" de interacciones
    val interactionSource = remember { MutableInteractionSource() }

    // Estados para saber qué tipo de interacción está ocurriendo
    var isPressed by remember { mutableStateOf(false) }
    var isHovered by remember { mutableStateOf(false) }
    var isDragged by remember { mutableStateOf(false) }
    var currentInteractionFeedback by remember { mutableStateOf("Ninguna interacción") }

    // 2. Escuchar lo que dice el "sensor" dentro de un LaunchedEffect
    // LaunchedEffect es importante para observar flujos de datos asíncronos como las interacciones.
    LaunchedEffect(interactionSource) {
        interactionSource.interactions.collect { interaction ->
            when (interaction) {
                is PressInteraction.Press -> {
                    isPressed = true
                    currentInteractionFeedback = "Presionando..."
                }
                is PressInteraction.Release -> {
                    isPressed = false
                    currentInteractionFeedback = "Soltado"
                }
                is PressInteraction.Cancel -> {
                    isPressed = false
                    currentInteractionFeedback = "Presión cancelada"
                }
                is HoverInteraction.Enter -> {
                    isHovered = true
                    currentInteractionFeedback = "Ratón encima (Hover)"
                }
                is HoverInteraction.Exit -> {
                    isHovered = false
                    currentInteractionFeedback = "Ratón fuera (Hover)"
                }
                is DragInteraction.Start -> {
                    isDragged = true
                    currentInteractionFeedback = "Arrastrando (Drag Start)"
                }
                is DragInteraction.Stop -> {
                    isDragged = false
                    currentInteractionFeedback = "Arrastre terminado (Drag Stop)"
                }
                is DragInteraction.Cancel -> {
                    isDragged = false
                    currentInteractionFeedback = "Arrastre cancelado (Drag Cancel)"
                }
            }
        }
    }

    // Definir el color de fondo del botón basado en las interacciones
    val buttonColor = when {
        isPressed -> Color.DarkGray // Más oscuro si está presionado
        isHovered -> Color.LightGray // Más claro si el ratón está encima
        isDragged -> Color.Magenta // Un color diferente si está siendo arrastrado
        else -> Color.Blue // Color normal
    }

    Column(
        modifier = modifier.padding(16.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        Button(
            onClick = { /* Lógica cuando se hace clic */ println("Botón clicado!") },
            // 3. Conectar el "sensor" al botón
            interactionSource = interactionSource,
            // 4. Habilitar el efecto de onda (Ripple)
            // Si no especificas 'indication', el Button de Material3 ya tiene ripple por defecto.
            // Si usas Modifier.clickable, puedes usar rememberRipple()
            // indication = rememberRipple(bounded = true, color = Color.Cyan), // Ejemplo de ripple personalizado
            modifier = Modifier
                .size(150.dp)
                .background(buttonColor, shape = RoundedCornerShape(8.dp))
            // Para que el Button use el interactionSource para sus propios efectos internos
            // (como el ripple por defecto), ya lo pasaste en el constructor del Button.
            // Si quisieras un clickable personalizado sin el Button, sería así:
            // .clickable(
            //     interactionSource = interactionSource,
            //     indication = rememberRipple(), // Habilitar ripple
            //     onClick = { println("Clic desde Modifier.clickable") }
            // )
        ) {
            Text("Interactivo")
        }

        Spacer(modifier = Modifier.height(16.dp))

        // 5. Feedback visual: Mostrar el estado actual de la interacción
        Text(
            text = "Estado: $currentInteractionFeedback",
            color = Color.Black // Asegúrate de que el texto sea visible
        )
    }
}

// --- Preview para MyInteractiveButton ---
@Preview(showBackground = true, name = "MyInteractiveButton Preview")
@Composable
fun MyInteractiveButtonPreview() {
    MyFirstComposeAPPTheme {
        Box(
            modifier = Modifier.fillMaxSize().background(Color.White), // Fondo blanco para ver el texto
            contentAlignment = Alignment.Center
        ) {
            MyInteractiveButton()
        }
    }
}
