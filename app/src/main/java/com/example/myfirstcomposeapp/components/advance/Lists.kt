package com.example.myfirstcomposeapp.components.advance

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box // Importar Box para superponer elementos
import androidx.compose.foundation.layout.Column // Importar Column
import androidx.compose.foundation.layout.PaddingValues // Importar PaddingValues
import androidx.compose.foundation.layout.Row // Importar Row
import androidx.compose.foundation.layout.Spacer // Importar Spacer
import androidx.compose.foundation.layout.fillMaxSize // Para la preview y el Box principal
import androidx.compose.foundation.layout.fillMaxWidth // Para los ítems de la lista
import androidx.compose.foundation.layout.height // Importar Modifier.height
import androidx.compose.foundation.layout.padding

import androidx.compose.foundation.lazy.LazyColumn // Importar LazyColumn
import androidx.compose.foundation.lazy.LazyRow // Se mantiene si se usa en MyBasicList, sino se puede quitar
import androidx.compose.foundation.lazy.grid.GridCells // Importar GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid // Importar LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items // Importar items para LazyVerticalGrid
import androidx.compose.foundation.lazy.rememberLazyListState // ¡Importar rememberLazyListState! (para LazyColumn)
import androidx.compose.foundation.lazy.grid.rememberLazyGridState // Importar rememberLazyGridState (para LazyVerticalGrid)
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.material.icons.Icons // Importar Icons
import androidx.compose.material.icons.filled.ArrowUpward // Importar ArrowUpward
import androidx.compose.material3.Button // Importar Button
import androidx.compose.material3.FloatingActionButton // Importar FloatingActionButton
import androidx.compose.material3.Icon // Importar Icon
import androidx.compose.material3.Text // Importar Text
import androidx.compose.material3.TextButton // Importar TextButton
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue // Importar getValue
import androidx.compose.runtime.mutableStateListOf // ¡Importar mutableStateListOf!
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope // ¡Importar rememberCoroutineScope!
import androidx.compose.runtime.derivedStateOf // ¡Importar derivedStateOf!
import androidx.compose.ui.Alignment // Importar Alignment para posicionamiento del FAB
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color // Importar Color (androidx.compose.ui.graphics.Color)
import androidx.compose.ui.tooling.preview.Preview // Importar Preview
import androidx.compose.ui.unit.dp // Importar dp
import androidx.compose.ui.unit.sp // Importar sp
import com.example.myfirstcomposeapp.ui.theme.MyFirstComposeAPPTheme // Importa tu tema para la preview
import kotlinx.coroutines.launch // Importar launch para coroutines
// import java.util.Collections.addAll // Esta importación no es necesaria para mutableStateListOf.addAll
import kotlin.random.Random // Importar Random

@Composable
fun MyBasicList(modifier: Modifier = Modifier, onItemClik:(String) -> Unit) {
    val names: List<String> = listOf(
        "Juan", "Pedro", "Maria", "Isabel",
        "Juan", "Pedro", "Maria", "Isabel",
        "Juan", "Pedro", "Maria", "Isabel",
        "Juan", "Pedro", "Maria", "Isabel",
        "Juan", "Pedro", "Maria", "Isabel",
        "Juan", "Pedro", "Maria", "Isabel",
        "Juan", "Pedro", "Maria", "Isabel",
        "Juan", "Pedro", "Maria", "Isabel",
        "Juan", "Pedro", "Maria", "Isabel"
    )
    LazyColumn { // Usando LazyColumn aquí como en tu código
        items(names) {
            Text(it, modifier = Modifier
                .padding(24.dp)
                .clickable { onItemClik(it) })
        }
    }
}

@Composable
fun MyAdvanceList(modifier: Modifier = Modifier) {
    // CORRECCIÓN 1: Usar mutableStateListOf para una lista reactiva
    val items = remember { mutableStateListOf<String>().apply {
        addAll(List(100) { "Item numero $it" }) // Inicializar la lista con 100 elementos
    }}

    val listState = rememberLazyListState()
    val coroutineScope = rememberCoroutineScope()

    val showScrollToTopButton by remember {
        derivedStateOf {
            listState.firstVisibleItemIndex > 0 // El botón se muestra si no estamos en el primer ítem
        }
    }

    // CORRECCIÓN 4: Usar Box para superponer el LazyColumn y el FloatingActionButton
    Box(modifier = modifier.fillMaxSize()) {
        LazyColumn(
            modifier = Modifier.fillMaxSize(), // LazyColumn ocupa todo el espacio del Box
            state = listState // Asignar el estado de la lista al LazyColumn
        ) {
            item {
                // CORRECCIÓN: Contenido del Button dentro de sus llaves {}
                Button(onClick = {
                    // CORRECCIÓN: Simplemente añadir a la lista mutableStateListOf
                    items.add(0, "Nuevo Item Agregado") // Agrega un nuevo ítem al principio
                }, modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = 16.dp, vertical = 8.dp)) {
                    Text("Agregar Item") // Texto del botón
                }
            }

            itemsIndexed(items, key = { _, item -> item }) { index, item ->
                Row(
                    modifier = Modifier
                        .fillMaxWidth() // Asegura que la fila ocupe todo el ancho
                        .padding(horizontal = 16.dp, vertical = 8.dp) // Padding para cada fila
                        .height(80.dp), // Altura fija para forzar el scroll
                    verticalAlignment = Alignment.CenterVertically // Alinear verticalmente los elementos de la fila
                ) {
                    Text(item + " (índice: $index)", modifier = Modifier.weight(1f))
                    Spacer(modifier = Modifier.weight(0.1f))

                    TextButton(onClick = {
                        // CORRECCIÓN: Eliminar solo una vez y verificar el índice
                        if (items.size > index) {
                            items.removeAt(index) // Eliminar el ítem en el índice actual
                        }
                    }) {
                        Text("Eliminar")
                    }
                }
            }
        }

        // Bloque del FloatingActionButton
        if (showScrollToTopButton) { // Usar la variable showScrollToTopButton
            FloatingActionButton(
                onClick = {
                    coroutineScope.launch { // Usar el coroutineScope declarado
                        listState.scrollToItem(0) // Desplazarse al primer ítem (índice 0)
                    }
                },
                modifier = Modifier
                    .align(Alignment.BottomEnd) // Alinear el botón a la parte inferior derecha del Box
                    .padding(16.dp) // Añadir padding alrededor del botón
            ) {
                Icon(imageVector = Icons.Default.ArrowUpward, contentDescription = "Scroll to top")
            }
        }
    }
}

@Composable
fun MyGridList(modifier: Modifier = Modifier) {
    // CORRECCIÓN 1: Usar mutableStateListOf para una lista de Ints
    val numbers = remember {
        mutableStateListOf<Int>().apply {
            addAll(List(100) { Random.nextInt(1, 100) }) // Generar 100 números aleatorios
        }
    }

    val colors = listOf(
        Color.Red, Color.Green, Color.Blue, Color.Yellow,
        Color.Magenta, Color.Cyan, Color.Gray, Color.White
    )

    LazyVerticalGrid(
        columns = GridCells.Fixed(3), // 3 columnas fijas
        modifier = modifier
            .fillMaxSize()
            .padding(16.dp),
        contentPadding = PaddingValues(16.dp), // Padding alrededor del contenido de la cuadrícula
        // Los siguientes parámetros son opcionales. Si no los necesitas, puedes omitirlos.
        // verticalArrangement = Arrangement.spacedBy(8.dp),
        // horizontalArrangement = Arrangement.spacedBy(8.dp),
        // state = rememberLazyGridState(), // Si necesitas controlar el scroll programáticamente
        // reverseLayout = false,
        // flingBehavior = null,
        // userScrollEnabled = true,
    ) {
        // CORRECCIÓN 3 y 4: El bloque 'items' debe ir dentro de la lambda de 'content'
        items(numbers) { randomNumber -> // 'randomNumber' es cada Int de la lista 'numbers'
            Box(
                modifier = Modifier
                    .padding(4.dp) // Espacio alrededor de cada Box en la cuadrícula
                    .background(colors[randomNumber % colors.size]) // Usar módulo para ciclo de colores
                    .fillMaxSize(), // Ocupar el espacio disponible en la celda
                contentAlignment = Alignment.Center
            ) {
                Text(
                    text = randomNumber.toString(),
                    color = Color.White,
                    fontSize = 24.sp
                )
            }
        }
    }
}

// --- Previews para los Composables ---
@Preview(showBackground = true, name = "MyBasicList Preview")
@Composable
fun MyBasicListPreview() {
    MyFirstComposeAPPTheme {
        MyBasicList(onItemClik = { name -> println("Clic en: $name") })
    }
}

@Preview(showBackground = true, name = "MyAdvanceList Preview")
@Composable
fun MyAdvanceListPreview() {
    MyFirstComposeAPPTheme {
        MyAdvanceList()
    }
}

@Preview(showBackground = true, name = "MyGridList Preview")
@Composable
fun MyGridListPreview() {
    MyFirstComposeAPPTheme {
        MyGridList()
    }
}
