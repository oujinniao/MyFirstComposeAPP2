package com.example.myfirstcomposeapp.components.navigation.examples

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
import androidx.navigation.NavHostController // ¡Importar NavHostController!
import com.example.myfirstcomposeapp.components.navigation.Home // ¡Importar objeto Home!

@Composable
fun LoginScreen(navController: NavHostController, modifier: Modifier =Modifier) { // ¡Recibimos navController!
    Column(modifier = modifier.fillMaxSize(), horizontalAlignment = Alignment.CenterHorizontally){
        Spacer(modifier = Modifier.height(16.dp))
        Text(text = "Login Screen",fontSize = 30.sp)
        Spacer(modifier = Modifier.height(16.dp))
        Button(onClick = {
            // ¡Aquí navegamos a la pantalla Home!
            navController.navigate(Home)
        }) {
            Text(text = "Ir a Home") // Cambiamos el texto del botón
        }
        Spacer(modifier = Modifier.height(16.dp))
    }
}