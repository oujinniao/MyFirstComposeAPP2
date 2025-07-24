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
import com.example.myfirstcomposeapp.components.navigation.examples.model.SettingModel

@Composable
fun DetailScreen(
    id: String,
    navigateToSettings: (SettingModel) -> Unit,
    navigateBack: () -> Unit,
    modifier: Modifier = Modifier
){
    var settingModel= SettingModel("Oujiniao",true)

    Column(
        modifier = modifier
            .fillMaxSize()
            .background(Color.Blue), // Color diferente para distinguirla
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center // Centrar el contenido verticalmente
    ){
        Spacer(modifier = Modifier.weight(1f))
        Text(text = "DETAIL: $id",fontSize = 30.sp) // Muestra el ID recibido
        Spacer(modifier = Modifier.weight(1f))
        Button(onClick = {navigateToSettings(settingModel)}){
            Text(text = "Ir a Ajustes")
        }
        Spacer(modifier = Modifier.weight(1f))
    }
}
