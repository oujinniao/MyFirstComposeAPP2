package com.example.myfirstcomposeapp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize // Importar fillMaxSize
import androidx.compose.material3.MaterialTheme // Importar MaterialTheme
import androidx.compose.material3.Surface // Importar Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable // Importar Composable
import androidx.compose.ui.Modifier // Importar Modifier
import androidx.compose.ui.text.input.KeyboardType.Companion.Text
import androidx.compose.ui.tooling.preview.Preview // Importar Preview para la previsualización

import com.example.myfirstcomposeapp.animation.MyAnimatedVisibility
import com.example.myfirstcomposeapp.ui.theme.MyFirstComposeAPPTheme // Importa tu tema
import com.example.myfirstcomposeapp.components.navigation.NavigationWrapper // ¡Importar NavigationWrapper!

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContent {
            MyFirstComposeAPPTheme {
                // Surface es un contenedor básico que aplica el tema de Material Design
                Surface(
                    modifier = Modifier.fillMaxSize(), // Ocupa toda la pantalla
                    color = MaterialTheme.colorScheme.background // Usa el color de fondo del tema
                ) {
                    // ¡Aquí es donde llamas a tu Composable principal de navegación!
                    //NavigationWrapper()
                    //MyAnimatedVisibility()
                    //ColorAnimationExample()
                    FullAnimatedAsState()
                }
            }
        }
    }
}

// --- Preview para MainActivity (Opcional) ---
@Preview(showBackground = true, name = "MainActivity Preview")
@Composable
fun MainActivityPreview() {
    MyFirstComposeAPPTheme {
        // En la Preview, puedes simular el contenido que esperas ver
        // o simplemente llamar a un Composable básico para verificar que el tema funciona.
        Surface(
            modifier = Modifier.fillMaxSize(),
            color = MaterialTheme.colorScheme.background
        ) {
            Text("MainActivity Preview: NavigationWrapper will go here")
        }
    }
}
