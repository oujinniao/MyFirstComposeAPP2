package com.example.myfirstcomposeapp.components.advance

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxHeight // Para que ocupe toda la altura disponible
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width // Para dar un ancho fijo a los elementos de la cuadrícula horizontal
import androidx.compose.foundation.lazy.grid.GridCells // Importar GridCells
import androidx.compose.foundation.lazy.grid.LazyHorizontalGrid // ¡Importar LazyHorizontalGrid!
import androidx.compose.foundation.lazy.grid.items // Importar items para LazyHorizontalGrid
import androidx.compose.material3.Text // Importar Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember // Importar remember
import androidx.compose.runtime.mutableStateListOf // Importar mutableStateListOf
import androidx.compose.ui.Alignment // Importar Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color // Importar Color
import androidx.compose.ui.tooling.preview.Preview // Importar Preview
import androidx.compose.ui.unit.dp // Importar dp
import androidx.compose.ui.unit.sp // Importar sp
import com.example.myfirstcomposeapp.ui.theme.MyFirstComposeAPPTheme // Importa tu tema
import kotlin.random.Random // Importar Random

@Composable
fun MyHorizontalGridList(modifier: Modifier = Modifier) {
    // Generar una lista de 100 números aleatorios para la cuadrícula
    val numbers = remember {
        mutableStateListOf<Int>().apply {
            addAll(List(100) { Random.nextInt(1, 100) }) // Generar 100 números aleatorios
        }
    }

    // Definir una lista de colores para que los elementos de la cuadrícula tengan diferentes fondos
    val colors = listOf(
        Color.Red, Color.Green, Color.Blue, Color.Yellow,
        Color.Magenta, Color.Cyan, Color.Gray, Color.White
    )

    // Usar LazyHorizontalGrid para mostrar los elementos en una cuadrícula desplazable horizontalmente
    LazyHorizontalGrid(
        // Definir 3 filas fijas. También podrías usar GridCells.Adaptive(120.dp) para filas adaptables.
        rows = GridCells.Fixed(3), // ¡Aquí definimos el número de filas!
        modifier = modifier
            .fillMaxSize() // La cuadrícula ocupa todo el espacio disponible
            .padding(16.dp), // Padding alrededor de la cuadrícula
        contentPadding = PaddingValues(16.dp), // Padding interno para el contenido de la cuadrícula
        // Puedes añadir espaciado entre las celdas si lo deseas:
        // verticalArrangement = Arrangement.spacedBy(8.dp),
        // horizontalArrangement = Arrangement.spacedBy(8.dp),
    ) {
        // La función 'items' dentro de LazyHorizontalGrid se encarga de componer cada elemento
        // 'numbers' es la lista de datos, 'randomNumber' es cada elemento individual de la lista
        items(numbers) { randomNumber ->
            // Cada elemento de la cuadrícula es un Box
            Box(
                modifier = Modifier
                    .padding(4.dp) // Pequeño padding alrededor de cada Box para separarlos visualmente
                    .background(colors[randomNumber % colors.size]) // Asigna un color de fondo basado en el número
                    .fillMaxHeight() // El Box ocupa toda la altura disponible dentro de su celda de la cuadrícula
                    .width(80.dp), // ¡Aquí le damos un ancho fijo para que se vea el desplazamiento horizontal!
                contentAlignment = Alignment.Center // Centra el contenido (el Text) dentro del Box
            ) {
                // Muestra el número aleatorio como texto
                Text(
                    text = randomNumber.toString(),
                    color = Color.White, // Color del texto
                    fontSize = 24.sp // Tamaño del texto
                )
            }
        }
    }
}

// --- Preview para MyHorizontalGridList ---
@Preview(showBackground = true, name = "MyHorizontalGridList Preview")
@Composable
fun MyHorizontalGridListPreview() {
    MyFirstComposeAPPTheme {
        MyHorizontalGridList()
    }
}
