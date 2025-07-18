package com.example.myfirstcomposeapp.components.advance


import androidx.compose.foundation.background // Importar para Modifier.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column // Importar Column
import androidx.compose.foundation.layout.Spacer // Importar Spacer
import androidx.compose.foundation.layout.fillMaxSize // Importar Modifier.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height // Importar Modifier.height
import androidx.compose.foundation.layout.padding // Importar Modifier.padding
import androidx.compose.foundation.text.KeyboardOptions // Para opciones de teclado en TextField
import androidx.compose.material3.Button // Importar Button
import androidx.compose.material3.Text // Importar Text
import androidx.compose.material3.TextField // Importar TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.derivedStateOf // Importar derivedStateOf
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment // Importar Alignment si se usa en Column
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color // Importar Color
import androidx.compose.ui.text.input.KeyboardType // Para opciones de teclado
import androidx.compose.ui.tooling.preview.Preview // Para la preview
import androidx.compose.ui.unit.dp // Importar dp
import com.example.myfirstcomposeapp.ui.theme.MyFirstComposeAPPTheme // Importa tu tema para la preview

@Composable
fun MyDerivedStateOf(modifier: Modifier = Modifier) {
    var email: String by remember { mutableStateOf("") }
    var password: String by remember { mutableStateOf("") }

    // CORRECCIÓN 1: Usar derivedStateOf correctamente
    val isFormValid by remember {
        derivedStateOf {
            email.contains("@") && password.length >= 6 // Usar >= 6 para "más de 6 caracteres" o simplemente > 5
        }
    }

    // CORRECCIÓN 2: El contenido de Column va dentro de sus llaves {}
    Column(
        modifier = modifier // Usar el modifier pasado a la función
            .fillMaxSize() // CORRECCIÓN 4: fillMaxSize importado
            .background(Color.LightGray) // CORRECCIÓN 3: Color importado, fondo claro para ver TextField
            .padding(16.dp), // Añadir padding para que los elementos no estén pegados
        horizontalAlignment = Alignment.CenterHorizontally, // Centrar elementos horizontalmente
        verticalArrangement = Arrangement.Center // Centrar elementos verticalmente
    ) {
        TextField(
            value = email,
            onValueChange = { email = it },
            label = { Text("Email") }, // Añadir una etiqueta
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Email), // Teclado de email
            modifier = Modifier.fillMaxWidth() // Ocupar todo el ancho disponible
        )
        Spacer(modifier = Modifier.height(8.dp)) // CORRECCIÓN 6: Spacer, height, dp importados
        TextField(
            value = password,
            onValueChange = { password = it },
            label = { Text("Password") }, // Añadir una etiqueta
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Password), // Teclado de contraseña
            modifier = Modifier.fillMaxWidth()
        )
        Spacer(modifier = Modifier.height(16.dp)) // Más espacio antes del botón

        Button(
            onClick = {
                // Lógica al enviar el formulario (solo si es válido)
                if (isFormValid) {
                    println("Formulario enviado: Email=$email, Password=$password")
                    // Aquí podrías navegar, mostrar un mensaje de éxito, etc.
                } else {
                    println("Formulario inválido. Revisa email y contraseña.")
                }
            },
            enabled = isFormValid, // El botón solo estará habilitado si el formulario es válido
            modifier = Modifier.fillMaxWidth()
        ) { // CORRECCIÓN 7: Button importado
            Text(text = "Submit") // CORRECCIÓN 8: Text importado
        }
    } // Cierre correcto de Column
} // Cierre correcto de la función Composable

// --- Preview para MyDerivedStateOf ---
@Preview(showBackground = true, name = "MyDerivedStateOf Preview")
@Composable
fun MyDerivedStateOfPreview() {
    MyFirstComposeAPPTheme {
        MyDerivedStateOf()
    }
}





