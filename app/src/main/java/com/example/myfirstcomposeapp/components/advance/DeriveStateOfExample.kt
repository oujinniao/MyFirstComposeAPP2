package com.example.myfirstcomposeapp.components.advance


import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.derivedStateOf // Importar derivedStateOf
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.mutableStateOf // Para String
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.myfirstcomposeapp.ui.theme.MyFirstComposeAPPTheme

@Composable
fun DerivedStateOfExample() {
    // Estado base: un contador
    var counter by remember { mutableIntStateOf(0) }

    // Estado derivado SIN derivedStateOf (para comparación mental)
    // var isEvenSimple = (counter % 2 == 0)

    // Estado derivado CON derivedStateOf
    // isEven solo se "notificará" como cambiado si el resultado de (counter % 2 == 0) cambia.
    // Es decir, solo cuando counter pase de par a impar, o de impar a par.
    val isEven by remember {
        derivedStateOf { counter % 2 == 0 } // <-- ¡Aquí está derivedStateOf!
    }

    // Otro estado para demostrar que otros cambios no afectan la recomposición de isEven
    var someOtherText by remember { mutableStateOf("Hola") }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        // Mostrar el contador
        Text(text = "Contador: $counter", fontSize = 24.sp)
        Spacer(modifier = Modifier.height(8.dp))

        // Mostrar si el número es par o impar, usando el estado derivado
        Text(
            text = if (isEven) "El número es PAR" else "El número es IMPAR",
            fontSize = 20.sp
        )
        Spacer(modifier = Modifier.height(16.dp))

        // Botón para incrementar el contador
        Button(onClick = { counter++ }) {
            Text("Incrementar Contador")
        }
        Spacer(modifier = Modifier.height(8.dp))

        // Botón para cambiar otro texto (no afecta directamente a 'isEven')
        Button(onClick = { someOtherText = if (someOtherText == "Hola") "Adiós" else "Hola" }) {
            Text("Cambiar Otro Texto: $someOtherText")
        }

        // En un caso real, si tuvieras un Composable muy pesado que solo dependiera de 'isEven',
        // derivedStateOf evitaría que se recompusiera cada vez que 'counter' cambiara
        // (si 'isEven' no cambiara de valor).
    }
}

@Preview(showBackground = true, name = "DerivedStateOf Example Preview")
@Composable
fun DerivedStateOfExamplePreview() {
    MyFirstComposeAPPTheme {
        DerivedStateOfExample()
    }
}
