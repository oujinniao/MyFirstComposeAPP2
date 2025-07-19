package com.example.myfirstcomposeapp.components.advance

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable // Importar Modifier.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.myfirstcomposeapp.ui.theme.MyFirstComposeAPPTheme

// Definir una clase de datos para representar cada elemento de la lista
data class ListItemData(val id: Int, val title: String, val description: String)

/**
 * Composable que demuestra el uso de LazyColumn para mostrar una lista larga de elementos.
 * Ahora incluye un parámetro onItemClick para manejar clics en los ítems.
 */
@Composable
fun LazyColumnExample(
    modifier: Modifier = Modifier,
    onItemClick: (ListItemData) -> Unit = {} // <-- ¡Aquí definimos onItemClick!
    // Le damos un valor por defecto para que sea opcional si no se usa.
) {
    val items = (1..1000).map { i ->
        ListItemData(id = i, title = "Título del Ítem $i", description = "Esta es la descripción detallada del ítem número $i. Lorem ipsum dolor sit amet.")
    }

    LazyColumn(
        modifier = modifier.fillMaxSize(),
        contentPadding = PaddingValues(horizontal = 16.dp, vertical = 8.dp)
    ) {
        items(items) { itemData ->
            Card(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(vertical = 4.dp)
                    .clickable { onItemClick(itemData) }, // <-- ¡Aquí llamamos a onItemClick!
                // Cuando la Card es clicada, ejecuta la lambda onItemClick
                // y le pasa el 'itemData' de este ítem.
                colors = CardDefaults.cardColors(
                    containerColor = MaterialTheme.colorScheme.surfaceVariant
                ),
                elevation = CardDefaults.cardElevation(defaultElevation = 2.dp)
            ) {
                Column(
                    modifier = Modifier.padding(16.dp)
                ) {
                    Text(
                        text = itemData.title,
                        fontSize = 20.sp,
                        color = MaterialTheme.colorScheme.onSurfaceVariant
                    )
                    Spacer(modifier = Modifier.height(4.dp))
                    Text(
                        text = itemData.description,
                        fontSize = 14.sp,
                        color = MaterialTheme.colorScheme.onSurfaceVariant.copy(alpha = 0.7f)
                    )
                }
            }
        }
    }
}

// --- Preview para LazyColumnExample ---
@Preview(showBackground = true, name = "LazyColumn Example Preview")
@Composable
fun LazyColumnExamplePreview() {
    MyFirstComposeAPPTheme {
        // En la Preview, podemos proporcionar una lambda vacía o una que imprima un mensaje
        LazyColumnExample(onItemClick = { clickedItem ->
            println("Preview: Clic en el ítem: ${clickedItem.title}")
        })
    }
}
