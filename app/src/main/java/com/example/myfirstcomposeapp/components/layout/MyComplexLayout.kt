package com.example.myfirstcomposeapp.components.layout

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp

@Composable
fun MyComplexLayout(modifier: Modifier = Modifier) {
    Column(modifier = modifier.fillMaxSize()) {
        Box(
            modifier = Modifier
                .weight(1f)
                .fillMaxWidth()
                .background(Color.Red),
            contentAlignment = Alignment.Center
        ) {
            Text(text = "Hello")
        }
        Row {}

        Box(
            modifier = Modifier
                .weight(1f)
                .fillMaxWidth()
                .background(Color.Blue),
            contentAlignment = Alignment.Center
        ) {
            Text("Helou")
            Row {
                Box(
                    modifier = Modifier
                        .weight(1f)
                        .height(125.dp)
                        .background(Color.Green),
                    contentAlignment = Alignment.Center

                ) {
                    Text(text = "Gudmorning")
                }
                Row {
                    Box(
                        modifier = Modifier
                            .weight(1f)
                            .height(275.dp)
                            .background(Color.Cyan),
                        contentAlignment = Alignment.Center
                    ) {
                        Text(text = "Buongiorno")
                    }
                }
                Row {
                    Box(
                        modifier = Modifier
                            .weight(1f)
                            .fillMaxWidth()
                            .background(Color.Yellow),
                        contentAlignment = Alignment.Center
                    ) {
                        Text(text = "Ni Hao")
                    }
                }
            }
        }
    }
}




