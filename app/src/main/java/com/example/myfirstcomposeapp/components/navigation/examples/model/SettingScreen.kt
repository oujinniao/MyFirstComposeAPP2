package com.example.myfirstcomposeapp.components.navigation.examples.model

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column

import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.sp

@Composable
fun SettingScreen(
    settingModel: SettingModel,
    navigateBack: () -> Unit,
    modifier: Modifier = Modifier) {

    Column(
        Modifier.fillMaxSize()
            .background(Color.Blue),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        Spacer(Modifier.weight(1f))
        Text(
            text = "Setting: id:${settingModel.id},darkMode:${settingModel.darckMode}", fontSize = 30.sp
        )
        Spacer(Modifier.weight(1f))
        Button(onClick = { }) {
            Text("Volver al inicio")
        }
        Spacer(Modifier.weight(1f))
    }
}

