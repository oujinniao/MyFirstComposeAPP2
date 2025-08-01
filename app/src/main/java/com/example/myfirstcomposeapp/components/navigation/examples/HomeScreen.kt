package com.example.myfirstcomposeapp.components.navigation.examples

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.graphics.Color // ¡Importar Color correctamente!
import androidx.navigation.NavHostController // ¡Importar NavHostController!
import com.example.myfirstcomposeapp.components.navigation.Login

@Composable
fun HomeScreen(
    navigateBack: () -> Unit,
    navigateToDetail:(String)->Unit
) {
var text:String by remember { mutableStateOf("") }
    Column(
        modifier = Modifier
         .fillMaxSize()
        .background(Color.Yellow),
    horizontalAlignment = Alignment.CenterHorizontally
    ){
        Spacer(Modifier.weight(1f))
        Text(text = "HOME", fontSize = 30.sp)
        Spacer(Modifier.weight(1f))

        Row {
            TextField(
                value = text, onValueChange = { text = it },
                modifier=Modifier.weight(1f)
            )
            Button(onClick = {navigateToDetail(text)}) { Text("Detail") }
        }
        Spacer(Modifier.weight(1f))
        Button(onClick = {navigateBack() }) {
            Text("regresar")
        }
        Spacer(Modifier.weight(1f))
    }
}






