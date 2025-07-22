package com.example.myfirstcomposeapp.components.navigation.examples

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.graphics.Color // Importar Color
import androidx.compose.foundation.layout.Arrangement // Importar Arrangement

@Composable
fun DetailScreen(id: String, navigateBack: () -> Unit, modifier: Modifier = Modifier){ // ¡Recibe id y navigateBack!
    Column(
        modifier = modifier
            .fillMaxSize()
            .background(Color.Blue), // Color diferente para distinguirla
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center // Centrar el contenido verticalmente
    ){
        Spacer(modifier = Modifier.weight(1f))
        Text(text = "Detail Screen: $id",fontSize = 30.sp) // Muestra el ID recibido
        Spacer(modifier = Modifier.weight(1f))
        Button(onClick = navigateBack){ // ¡Usa la lambda para regresar!
            Text(text = "Regresar")
        }
        Spacer(modifier = Modifier.weight(1f))
    }
}
