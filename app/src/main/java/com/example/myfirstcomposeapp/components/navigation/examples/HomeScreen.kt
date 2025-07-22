package com.example.myfirstcomposeapp.components.navigation.examples

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement // Importar Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding // Importar padding
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.material3.TextField // Importar TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf // Importar mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.graphics.Color // ¡Importar Color correctamente!
// Ya no necesitamos NavHostController aquí si usamos lambdas para la navegación
// import androidx.navigation.NavHostController
// Ya no necesitamos Login aquí
// import com.example.myfirstcomposeapp.components.navigation.Login

@Composable
fun HomeScreen(
    navigateBack: () -> Unit, // Callback para navegar hacia atrás
    navigateToDetail: (String) -> Unit, // Callback para navegar a detalles, pasando un String
    modifier: Modifier = Modifier // Mantener el modificador para flexibilidad
) {
    var text by remember { mutableStateOf("") } // Declarar el estado para el TextField

    Column(
        modifier = modifier // Usar el modificador del parámetro
            .fillMaxSize()
            .background(Color.Yellow),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center // Centrar el contenido verticalmente
    ) {
        Spacer(Modifier.weight(1f)) // Espaciador para empujar contenido

        Text(text = "HOME", fontSize = 30.sp)

        Spacer(Modifier.weight(1f)) // Espaciador

        Row(
            modifier = Modifier
                .fillMaxWidth() // ¡Asegurar que la fila ocupe todo el ancho!
                .padding(horizontal = 16.dp), // Padding para la fila del TextField y Button
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.spacedBy(8.dp) // Espacio entre TextField y Button
        ) {
            TextField(
                value = text,
                onValueChange = { text = it },
                label = { Text("Introduce un texto") }, // Etiqueta para el TextField
                modifier = Modifier.weight(1f) // TextField ocupa el espacio restante
            )
            Button(onClick = { navigateToDetail(text) }) {
                Text("Detalle")
            }
        }

        Spacer(Modifier.weight(1f)) // Espaciador

        Button(onClick = { navigateBack() }) {
            Text("Regresar")
        }

        Spacer(Modifier.weight(1f)) // Espaciador
    }
}
