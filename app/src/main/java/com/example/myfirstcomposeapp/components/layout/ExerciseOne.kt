package com.example.myfirstcomposeapp.components.layout

import android.widget.Space
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp

@Composable
fun ExerciseOne(modifier: Modifier = Modifier) {
    Column(modifier = modifier.fillMaxSize()) {
        Box(
            Modifier
                .weight(1f)
                .fillMaxWidth()
                .background(Color.Cyan)
                .padding(bottom = 20.dp),
            contentAlignment = Alignment.Center
        ) {
            Text("Holanda")
        }
        Spacer(Modifier.height(20.dp))
        Row(
            Modifier
                .weight(1f)
                .fillMaxWidth()
        ) {
            Box(modifier = Modifier
                .weight(1f)
                .fillMaxHeight()
                .background(Color.Red),
                contentAlignment = Alignment.Center
            ) {
                Text("Nihao")
            }
            Spacer(Modifier.width(20.dp))
            Box(modifier = Modifier
                .weight(1f)
                .fillMaxHeight()
                .background(Color.Green),
            contentAlignment = Alignment.Center
            ) {
                Text("mari mari")
            }
        }

        Box(
            Modifier
                .weight(1f)
                .fillMaxWidth()
                .background(Color.Magenta),
            contentAlignment = Alignment.BottomCenter
        ) {
            Text("Buongiorno")
        }
        Spacer(Modifier.height(20.dp))
    }
}








