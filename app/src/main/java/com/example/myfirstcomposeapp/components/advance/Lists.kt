package com.example.myfirstcomposeapp.components.advance

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column // Importar Column

import androidx.compose.foundation.layout.Row // Importar Row
import androidx.compose.foundation.layout.Spacer // Importar Spacer
import androidx.compose.foundation.layout.fillMaxSize // Para la preview
import androidx.compose.foundation.layout.fillMaxWidth // Para los ítems de la lista
import androidx.compose.foundation.layout.padding

import androidx.compose.foundation.lazy.LazyColumn // Importar LazyColumn
import androidx.compose.foundation.lazy.LazyRow // No se usa en MyAdvanceList, pero se mantiene si lo usas en MyBasicList
import androidx.compose.foundation.lazy.items // Importar items
import androidx.compose.foundation.lazy.itemsIndexed // Importar itemsIndexed
import androidx.compose.material3.Button // Importar Button
import androidx.compose.material3.Text // Importar Text
import androidx.compose.material3.TextButton // Importar TextButton
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateListOf // <-- ¡CORRECCIÓN 1: Usar mutableStateListOf!
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
// import androidx.compose.runtime.toMutableStateList // No es necesario si usas mutableStateListOf directamente
import androidx.compose.ui.Alignment // Para la preview
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview // Importar Preview
import androidx.compose.ui.unit.dp // Importar dp
import com.example.myfirstcomposeapp.ui.theme.MyFirstComposeAPPTheme
import androidx.compose.runtime.mutableStateListOf

@Composable
fun MyBasicList(modifier: Modifier = Modifier, onItemClik:(String) -> Unit) {
    val names:List<String> = listOf("Juan", "Pedro", "Maria", "Isabel",
        "Juan", "Pedro", "Maria", "Isabel",
        "Juan", "Pedro", "Maria", "Isabel",
        "Juan", "Pedro", "Maria", "Isabel",
        "Juan", "Pedro", "Maria", "Isabel",
        "Juan", "Pedro", "Maria", "Isabel",
        "Juan", "Pedro", "Maria", "Isabel",
        "Juan", "Pedro", "Maria", "Isabel",
        "Juan", "Pedro", "Maria", "Isabel")
        ////LazyColumn {
                    LazyRow {
            items(names) {
                Text(it, modifier=Modifier.padding(24.dp).clickable { onItemClik(it) })
            }

        }
}

@Composable
fun MyAdvanceList(modifier: Modifier = Modifier) {
    var items: List<String> by remember { mutableStateOf(List(100) { "Item numero $it" }) }

    LazyColumn {
        item {
            Button ({
                items= items.toMutableList().apply {
                    add(0, "Hola")}

                    }) {Text("Agregar Item")}
        }

        itemsIndexed(items,key={_,item->item}){index, item ->
            Row (
                modifier=Modifier
            ){
            Text(item + " indice : $index")
                Spacer(modifier = Modifier.weight(1f))
                TextButton({
                    items=items.toMutableList().apply {
                        removeAt(index)
                        removeAt(index)    }

                }) { Text("Eliminar") }
                Spacer(modifier = Modifier.padding(24.dp))
            }

        }
    }
    }


