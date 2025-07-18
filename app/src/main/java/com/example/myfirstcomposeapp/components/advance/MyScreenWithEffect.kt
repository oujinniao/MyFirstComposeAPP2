package com.example.myfirstcomposeapp.components.advance

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.Scaffold
import androidx.compose.material3.SnackbarHost
import androidx.compose.material3.SnackbarHostState // Importar SnackbarHostState
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect // Importar LaunchedEffect
import androidx.compose.runtime.remember // Importar remember
import androidx.compose.runtime.rememberCoroutineScope // Importar rememberCoroutineScope
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.myfirstcomposeapp.ui.theme.MyFirstComposeAPPTheme // Importa tu tema
import kotlinx.coroutines.launch
import kotlinx.coroutines.time.delay
import java.time.Duration
import kotlin.time.Duration.Companion.milliseconds
import kotlin.time.Duration.Companion.seconds

@Composable
fun MyScreenWithEffect(modifier: Modifier = Modifier) {
    val snackbarHostState = remember { SnackbarHostState() } // Estado para el Snackbar
    val scope = rememberCoroutineScope() // CoroutineScope para lanzar tareas si es necesario

    Scaffold(
        snackbarHost = { SnackbarHost(hostState = snackbarHostState) } // Mostrar el SnackbarHost
    ) { innerPadding ->
        Box(
            modifier = modifier
                .fillMaxSize()
                .padding(innerPadding), // Aplicar el padding del Scaffold
            contentAlignment = Alignment.Center
        ) {
            Column(horizontalAlignment = Alignment.CenterHorizontally) {
                Text("Bienvenido a mi pantalla!")
                Button(onClick = {
                    scope.launch {
                        snackbarHostState.showSnackbar("Botón presionado!")
                    }
                }) {
                    Text("Presiona aquí")
                }
            }
        }
    }

    // ¡Aquí usamos LaunchedEffect!
    // Se lanzará una vez cuando MyScreenWithEffect entre en la composición.
    // La clave 'Unit' significa que solo se ejecutará una vez y no se relanzará
    // a menos que el Composable sea removido y re-añadido a la composición.
    LaunchedEffect(Unit) { // <-- La clave 'Unit' significa que se ejecuta una vez al inicio
        // Esta es la "Tarea Especial": mostrar un Snackbar
        snackbarHostState.showSnackbar(
            message = "¡Bienvenido a la pantalla!",
            actionLabel = "OK"
        )
              delay(Duration.ofSeconds(2))
    }
}

@Preview(showBackground = true, name = "MyScreenWithEffect Preview")
@Composable
fun MyScreenWithEffectPreview() {
    MyFirstComposeAPPTheme {
        MyScreenWithEffect()
    }
}

