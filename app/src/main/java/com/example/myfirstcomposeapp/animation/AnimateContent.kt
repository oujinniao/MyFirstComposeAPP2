package com.example.myfirstcomposeapp.animation

import androidx.compose.animation.AnimatedContent
import androidx.compose.animation.ContentTransform
import androidx.compose.animation.fadeIn
import androidx.compose.animation.fadeOut
import androidx.compose.animation.slideInVertically
import androidx.compose.animation.scaleIn
import androidx.compose.animation.scaleOut
import androidx.compose.animation.togetherWith // Para combinar animaciones de entrada y salida
import androidx.compose.animation.core.tween
import androidx.compose.animation.slideOutVertically
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun MyAnimateContent(modifier: Modifier = Modifier) {
    var number by remember { mutableStateOf(0) }

    Column(
        modifier = modifier.fillMaxSize().padding(top = 50.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Row {
            Button(onClick = { number++ }) {
                Text("Incrementar")
            }
            Spacer(Modifier.padding(horizontal = 8.dp))
            Button(onClick = { number-- }) {
                Text("Decrementar")
            }
        }

        Spacer(Modifier.height(32.dp))

        AnimatedContent(
            targetState = number,
            modifier = Modifier.padding(top = 16.dp),
            transitionSpec = {
                // Ahora, 'targetState' e 'initialState' son propiedades directamente accesibles
                // desde el scope de AnimatedContentTransitionScope.
                if (targetState > initialState) { // Acceder a targetState e initialState directamente
                    (slideInVertically { height -> height } + fadeIn()).togetherWith(
                        slideOutVertically { height -> -height } + fadeOut()
                    )
                } else {
                    (slideInVertically { height -> -height } + fadeIn()).togetherWith(
                        slideOutVertically { height -> height } + fadeOut()
                    )
                }
            },
            label = "NumberAnimation"
        ) { animatedNumber ->
            Text(
                text = "El Número es: $animatedNumber",
                fontSize = 40.sp,
                modifier = Modifier.padding(top = 16.dp)
            )
        }
    }
}
