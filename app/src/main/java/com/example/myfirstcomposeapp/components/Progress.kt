package com.example.myfirstcomposeapp.components

import android.util.Log.e
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Button
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.LinearProgressIndicator
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.airbnb.lottie.LottieComposition
import com.airbnb.lottie.compose.LottieAnimation
import com.airbnb.lottie.compose.LottieCompositionSpec
import com.airbnb.lottie.compose.rememberLottieComposition
import com.example.myfirstcomposeapp.R


@Preview
@Composable
fun Progress(modifier: Modifier = Modifier){
    var progress : Float by remember { mutableStateOf(0.1f) }

    Column(modifier = modifier.fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        CircularProgressIndicator(
            progress={progress},
            Modifier.size(140.dp),
            color= Color.Blue,
            strokeWidth = 8.dp,
            trackColor = Color.LightGray,
            strokeCap = androidx.compose.ui.graphics.StrokeCap.Round)
         Spacer(Modifier.height(24.dp)
         )

        LinearProgressIndicator(
            Modifier.height(16.dp),
            color = Color.Blue,
            trackColor = Color.LightGray,
            strokeCap = androidx.compose.ui.graphics.StrokeCap.Round
        )
        Row(Modifier.padding(10.dp)) {
            Button(onClick ={progress+=0.1f}) { Text("<-" )}
            Spacer(Modifier.width(24.dp))
            Button(onClick = {progress-=0.1f}) { Text( "->" )}

        }




    }
}
//LinearProgressndicator dibuja un progreso como una barra horizontal
//CircularProgressIndicator dibuja un progreso como un circulo

@Composable
fun ProgressAnimation(modifier:Modifier=Modifier) {
    val composition: LottieComposition?
            by rememberLottieComposition(LottieCompositionSpec.RawRes(R.raw.animation2))
    Column(
        modifier = modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {

        LottieAnimation(composition = composition,iterations = Int.MAX_VALUE)
    }
}
//Usamos Lottie para animaciones de carga, del sitio:https://lottiefiles.com/search?trigger_action=download&finish_login=true&cb_payload=eyJsb2dpbk1ldGhvZCI6InNvY2lhbCIsInByb3ZpZGVyIjoiZ29vZ2xlIiwibWV0YWRhdGEiOiJ7XCJyZWRpcmVjdFVybFwiOlwiL2ZyZWUtYW5pbWF0aW9uL2J1cmdlci1oYW1idXJnZXItZmFzdC1mb29kLXJlc3RhdXJhbnQtOW9QdGlneWJOTj90cmlnZ2VyX2FjdGlvbj1kb3dubG9hZFwiLFwiZXh0ZXJuYWxSZWRpcmVjdFwiOmZhbHNlfSJ9&q=burger&category=animations