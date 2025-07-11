package com.example.myfirstcomposeapp.components.layout

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.DropdownMenuItem // Importar DropdownMenuItem
import androidx.compose.material3.ExperimentalMaterial3Api // Necesaria para ExposedDropdownMenuBox
import androidx.compose.material3.ExposedDropdownMenuBox // Importar ExposedDropdownMenuBox
import androidx.compose.material3.ExposedDropdownMenuDefaults // Importar para los iconos por defecto
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface

@OptIn(ExperimentalMaterial3Api::class) // Etiqueta para indicar que ExposedDropdownMenuBox es experimental
@Composable
fun CountrySelectorDropdown(modifier: Modifier = Modifier) {
    val countries = listOf("Chile", "Argentina", "Perú", "Colombia", "México", "España")
    var expanded by remember { mutableStateOf(false) } // Controla si el menú está abierto o cerrado
    var selectedText by remember { mutableStateOf(countries[0]) } // Opción seleccionada

    Column(modifier = modifier.padding(16.dp)) {
        ExposedDropdownMenuBox(
            expanded = expanded,
            onExpandedChange = { expanded = !expanded }, // Al hacer clic en el TextField, cambia el estado
        ) {
            TextField(
                value = selectedText,
                onValueChange = {}, // No permitimos editar directamente, solo seleccionar
                readOnly = true, // Para que el usuario solo pueda seleccionar de la lista
                label = { Text("Selecciona un País") },
                trailingIcon = { ExposedDropdownMenuDefaults.TrailingIcon(expanded = expanded) }, // Icono de flecha
                modifier = Modifier
                    .menuAnchor() // Es crucial para anclar el menú al TextField
                    .fillMaxWidth()
            )

            ExposedDropdownMenu(
                expanded = expanded,
                onDismissRequest = { expanded = false }, // Cuando se toca fuera del menú, se cierra
            ) {
                // Iteramos sobre nuestra lista de países para crear un DropdownMenuItem para cada uno
                countries.forEach { country ->
                    DropdownMenuItem(
                        text = { Text(country) }, // El texto que se mostrará en el ítem
                        onClick = {
                            selectedText = country // Actualiza la opción seleccionada
                            expanded = false // Cierra el menú después de la selección
                        },
                        // Puedes añadir un icono si quieres:
                        // leadingIcon = { Icon(Icons.Default.LocationOn, contentDescription = null) }
                    )
                }
            }
        }
    }
}



/// Previsualización

//```kotlin
@Preview(showBackground = true, widthDp = 320)
@Composable
fun CountrySelectorDropdownPreview() {
    MaterialTheme {
        Surface {
            CountrySelectorDropdown()
        }
    }
}