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
import androidx.compose.ui.graphics.Color

@Composable
fun DetailScreen(id: String, navigateBack: () -> Unit, modifier: Modifier = Modifier){
    Column(
        modifier=modifier
            .fillMaxSize()
        .background(Color.Yellow),
        horizontalAlignment = Alignment.CenterHorizontally
    ){
    Spacer(modifier = Modifier.weight(1f))
        Text(text = "Detail Screen:$id",fontSize = 30.sp)
        Spacer(modifier = Modifier.weight(1f))
        Button(onClick = navigateBack){
            Text(text = "Regresar")
        }
        Spacer(modifier = Modifier.weight(1f))
    }


}
