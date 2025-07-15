package com.example.myfirstcomposeapp.components.cards

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp


@Composable
fun MyCard(modifier: Modifier = Modifier){
    Card(modifier= modifier
        .fillMaxWidth()
        .padding(horizontal = 16.dp),
        shape = MaterialTheme.shapes.extraLarge,
        border = BorderStroke(5.dp, Color.Green),
        elevation = CardDefaults.cardElevation(defaultElevation = 20.dp),
        colors = CardDefaults.cardColors(containerColor = Color.Green)

        ) {
        Row(verticalAlignment = Alignment.CenterVertically){
            Box(
            modifier=Modifier
                .padding(16.dp)
                .size(75.dp)
                .clip(CircleShape)
                .background(Color.Blue))
            Column {
                Text(text = "Hola")
                Text(text = "Hola")
            }

        }
    }
}