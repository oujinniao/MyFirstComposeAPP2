package com.example.myfirstcomposeapp.components.advance

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil.compose.AsyncImage // ¡Importante: para cargar imágenes desde URL!
import com.example.myfirstcomposeapp.ui.theme.MyFirstComposeAPPTheme


@Composable
fun ProductGridExample(modifier: Modifier = Modifier) {
    // 2. Generar datos de prueba (simulando una respuesta de API)
    val products = remember {
        mutableStateListOf<Product>().apply {
            addAll(List(50) { i -> // Creamos 50 productos de ejemplo
                Product(
                    id = "prod_$i",
                    imageUrl = "https://placehold.co/200x200/FF0000/FFFFFF?text=Producto+$i", // URL de imagen de prueba
                    name = "Producto Genérico $i",
                    price = (10.0 + i * 0.5) // Precio de ejemplo
                )
            })
        }
    }

    // 3. Usar LazyVerticalGrid para mostrar los productos
    LazyVerticalGrid(
        columns = GridCells.Fixed(2), // 2 columnas fijas para los productos
        modifier = modifier
            .fillMaxSize()
            .padding(8.dp),
        contentPadding = PaddingValues(8.dp), // Padding alrededor del contenido de la cuadrícula
        verticalArrangement = Arrangement.spacedBy(8.dp), // Espacio vertical entre filas
        horizontalArrangement = Arrangement.spacedBy(8.dp) // Espacio horizontal entre columnas
    ) {
        // 'items' para iterar sobre la lista de productos
        items(products, key = { it.id }) { product -> // Usamos el 'id' del producto como clave única
            // 4. Composable para cada ítem de producto (una Card)
            ProductCard(product = product)
        }
    }
}

/**
 * Composable individual para mostrar los detalles de un producto en una Card.
 */
@Composable
fun ProductCard(product: Product, modifier: Modifier = Modifier) {
    Card(
        modifier = modifier.fillMaxWidth(), // La Card ocupa todo el ancho disponible en su celda
        colors = CardDefaults.cardColors(
            containerColor = MaterialTheme.colorScheme.surfaceVariant
        ),
        elevation = CardDefaults.cardElevation(defaultElevation = 4.dp)
    ) {
        Column(
            modifier = Modifier.padding(8.dp),
            horizontalAlignment = Alignment.CenterHorizontally // Centrar contenido horizontalmente
        ) {
            // 5. Cargar la imagen desde la URL usando AsyncImage de Coil
            AsyncImage(
                model = product.imageUrl, // La URL de la imagen
                contentDescription = "Imagen de ${product.name}", // Descripción para accesibilidad
                contentScale = ContentScale.Crop, // Escalar la imagen para que llene el espacio
                modifier = Modifier
                    .fillMaxWidth()
                    .aspectRatio(1f) // Hace que la imagen sea cuadrada (1:1 relación de aspecto)
                    .background(Color.LightGray) // Color de fondo mientras carga o si falla
            )
            Text(
                text = product.name,
                fontSize = 16.sp,
                color = MaterialTheme.colorScheme.onSurfaceVariant,
                modifier = Modifier.padding(top = 8.dp)
            )
            Text(
                text = "$${product.price}",
                fontSize = 14.sp,
                color = MaterialTheme.colorScheme.primary,
                modifier = Modifier.padding(bottom = 4.dp)
            )
        }
    }
}

// --- Preview para ProductGridExample ---
@Preview(showBackground = true, name = "ProductGridExample Preview")
@Composable
fun ProductGridExamplePreview() {
    MyFirstComposeAPPTheme {
        ProductGridExample()
    }
}


