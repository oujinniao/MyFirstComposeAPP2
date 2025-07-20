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
import androidx.compose.ui.graphics.Color // ¡Importar Color correctamente!
import androidx.navigation.NavHostController // ¡Importar NavHostController!
import com.example.myfirstcomposeapp.components.navigation.Login

@Composable
fun HomeScreen(navController: NavHostController, modifier: Modifier = Modifier) { // ¡Recibimos navController!
    Column(modifier = modifier.fillMaxSize()
        .background(Color.Yellow), // Usar el Color de Compose
        horizontalAlignment = Alignment.CenterHorizontally){
        Spacer(modifier = Modifier.height(16.dp))
        Text(text = "HOME",fontSize = 30.sp)
        Spacer(modifier = Modifier.height(16.dp))
        Button(onClick = {
            // ¡Aquí navegamos de regreso a la pantalla anterior (Login)!
            navController.popBackStack()
        }) {
            Text(text = "Regresar a Login") // Cambiamos el texto del botón
        }
        Spacer(modifier = Modifier.height(16.dp))
    }
}