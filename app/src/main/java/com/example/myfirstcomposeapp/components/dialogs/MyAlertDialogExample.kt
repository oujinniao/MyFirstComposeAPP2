package com.example.myfirstcomposeapp.components.dialogs

import androidx.compose.material3.AlertDialog
import androidx.compose.material3.Text
import androidx.compose.material3.Button
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.getValue
import androidx.compose.runtime.setValue
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.Modifier
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.ui.Alignment
import com.example.myfirstcomposeapp.ui.theme.MyFirstComposeAPPTheme // Importa tu tema

@Composable
fun MyAlertDialogExample() {
    // 1. Estado para controlar si el diálogo se muestra o no
    var showDialog by remember { mutableStateOf(false) }

    Column(
        modifier = Modifier.fillMaxSize().wrapContentSize(Alignment.Center),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        // Un botón para abrir el diálogo
        Button(onClick = { showDialog = true }) {
            Text("Mostrar Diálogo")
        }
    }

    // 2. Si 'showDialog' es true, entonces se muestra el AlertDialog
    if (showDialog) {
        AlertDialog(
            onDismissRequest = {
                // Se llama cuando el usuario intenta cerrar el diálogo tocando fuera
                // o presionando el botón de atrás.
                // Aquí lo ocultamos.
                showDialog = false
            },
            title = { Text("Título del Diálogo") },
            text = { Text("Este es un mensaje importante para el usuario.") },
            confirmButton = {
                Button(onClick = {
                    // Lógica cuando el usuario confirma
                    showDialog = false // Ocultar el diálogo
                    println("Acción confirmada")
                }) {
                    Text("Aceptar")
                }
            },
            dismissButton = {
                Button(onClick = {
                    // Lógica cuando el usuario cancela
                    showDialog = false // Ocultar el diálogo
                    println("Acción cancelada")
                }) {
                    Text("Cancelar")
                }
            }
        )
    }
}

@Preview(showBackground = true, name = "AlertDialog Preview")
@Composable
fun AlertDialogPreview() {
    MyFirstComposeAPPTheme {
        MyAlertDialogExample()
    }
}
