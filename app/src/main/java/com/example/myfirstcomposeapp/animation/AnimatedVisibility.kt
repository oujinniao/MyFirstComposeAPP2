package com.example.myfirstcomposeapp.animation

import android.widget.Space
import androidx.compose.animation.AnimatedVisibility
import androidx.compose.animation.scaleIn
import androidx.compose.animation.scaleOut
import androidx.compose.animation.shrinkVertically
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp

@Composable
fun  MyAnimatedVisibility(modifier: Modifier = Modifier) {
    var showView: Boolean by remember { mutableStateOf(true) }
    Spacer(Modifier.height(50.dp))
    Column(
        modifier = modifier.fillMaxSize().background(Color.Yellow),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Spacer(Modifier.height(50.dp))
        Button(onClick = { showView = !showView }) {
            Text("Mostrar/Ocultar")

            Spacer(Modifier.height(50.dp))
            AnimatedVisibility (showView, enter= scaleIn(), exit = scaleOut()) {
                Box(
                    modifier = Modifier
                        .fillMaxSize()
                        .height(150.dp)
                        .background(Color.Yellow)
                )
            }
        }
    }
}




