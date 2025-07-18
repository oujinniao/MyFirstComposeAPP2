import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.material3.Button
import androidx.compose.material3.Checkbox
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.derivedStateOf // ¡Importar derivedStateOf!
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateListOf // Para una lista mutable
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
// 1. Clase de datos para representar un ítem de la lista
data class ChecklistItem(val id: Int, var name: String, var checked: Boolean)

@Composable
fun ChecklistExampleWithDerivedState(modifier: Modifier = Modifier) {
    // 2. Estado para la lista de ítems. Usamos mutableStateListOf para que Compose observe los cambios en la lista.
    val items = remember {
        mutableStateListOf(
            ChecklistItem(1, "Comprar leche", false),
            ChecklistItem(2, "Hacer ejercicio", false),
            ChecklistItem(3, "Leer un libro", false)
        )
    }

    // 3. Estado derivado: ¿Están todos los ítems marcados?
    // 'allItemsChecked' solo se "notificará" como cambiado si el resultado de
    // items.all { it.checked } realmente cambia de true a false o viceversa.
    // Si se cambia el nombre de un ítem, o si se marca un ítem pero aún quedan sin marcar,
    // el valor de 'allItemsChecked' no cambiará, y por lo tanto, no se recompone el texto.
    val allItemsChecked by remember {
        derivedStateOf {
            items.isNotEmpty() && items.all { it.checked }
        }
    }

    Column(
        modifier = modifier
            .fillMaxSize()
            .padding(16.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        // Título
        Text(text = "Lista de Tareas", fontSize = 24.sp, modifier = Modifier.padding(bottom = 16.dp))

        // 4. Mostrar la lista de ítems usando LazyColumn (eficiente para listas grandes)
        LazyColumn(
            modifier = Modifier.weight(1f) // Ocupa el espacio restante
        ) {
            itemsIndexed(items) { index, item ->
                ChecklistItemRow(item = item) { isChecked ->
                    // Cuando se marca/desmarca un ítem, actualizamos el estado de la lista.
                    // ¡Importante! Para que mutableStateListOf detecte el cambio,
                    // debemos modificar el objeto en la lista o reemplazarlo.
                    items[index] = item.copy(checked = isChecked)
                }
            }
        }

        Spacer(modifier = Modifier.height(16.dp))

        // 5. Mostrar el estado derivado
        Text(
            text = if (allItemsChecked) "¡Todas las tareas completas!" else "Aún quedan tareas...",
            fontSize = 18.sp,
            color = if (allItemsChecked) Color.Green else Color.Red
        )

        Spacer(modifier = Modifier.height(16.dp))

        // 6. Botones de acción
        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceAround
        ) {
            Button(onClick = {
                // Añadir un nuevo ítem
                val newId = (items.lastOrNull()?.id ?: 0) + 1
                items.add(ChecklistItem(newId, "Nueva tarea $newId", false))
            }) {
                Text("Añadir Tarea")
            }

            Button(onClick = {
                // Marcar/Desmarcar todas las tareas
                val areAllCurrentlyChecked = items.all { it.checked }
                items.forEachIndexed { index, item ->
                    items[index] = item.copy(checked = !areAllCurrentlyChecked)
                }
            }) {
                Text(if (allItemsChecked) "Desmarcar Todas" else "Marcar Todas")
            }
        }
    }
}

@Composable
fun ChecklistItemRow(item: ChecklistItem, onCheckedChange: (Boolean) -> Unit) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(vertical = 8.dp),
        verticalAlignment = Alignment.CenterVertically
    ) {
        Checkbox(
            checked = item.checked,
            onCheckedChange = onCheckedChange
        )
        Text(text = item.name, fontSize = 16.sp)
    }
}

