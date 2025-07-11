package com.example.myfirstcomposeapp.scaffold

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.Done
import androidx.compose.material.icons.filled.List
import androidx.compose.material.icons.filled.Menu
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.NavigationBar // Importa NavigationBar
import androidx.compose.material3.NavigationBarItem // Importa NavigationBarItem
import androidx.compose.material3.Scaffold
import androidx.compose.material3.SnackbarHost
import androidx.compose.material3.SnackbarHostState
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import kotlinx.coroutines.launch

@OptIn(ExperimentalMaterial3Api::class) // Necesario para Scaffold y TopAppBar
@Composable
fun MyTasksScreen() {
    // Estados para la Snackbar y para la selección de la NavigationBar
    val snackbarHostState = remember { SnackbarHostState() }
    val scope = rememberCoroutineScope()
    var selectedTab by remember { mutableStateOf(0) } // 0 para Pendientes, 1 para Completadas

    Scaffold(
        // 1. Barra Superior
        topBar = {
            TopAppBar(
                title = { Text("Mis Tareas") },
                colors = TopAppBarDefaults.topAppBarColors(
                    containerColor = MaterialTheme.colorScheme.primaryContainer,
                    titleContentColor = MaterialTheme.colorScheme.primary,
                ),
                navigationIcon = {
                    IconButton(onClick = { /* Acción para abrir un drawer (menú lateral) */ }) {
                        Icon(Icons.Filled.Menu, contentDescription = "Menú Principal")
                    }
                }
            )
        },
        // 2. Barra Inferior de Navegación
        bottomBar = {
            NavigationBar {
                NavigationBarItem(
                    icon = { Icon(Icons.Filled.List, contentDescription = "Tareas Pendientes") },
                    label = { Text("Pendientes") },
                    selected = selectedTab == 0,
                    onClick = { selectedTab = 0 }
                )
                NavigationBarItem(
                    icon = { Icon(Icons.Filled.Done, contentDescription = "Tareas Completadas") },
                    label = { Text("Completadas") },
                    selected = selectedTab == 1,
                    onClick = { selectedTab = 1 }
                )
            }
        },
        // 3. Botón de Acción Flotante
        floatingActionButton = {
            FloatingActionButton(onClick = {
                scope.launch {
                    snackbarHostState.showSnackbar("¡Añadir nueva tarea!")
                }
            }) {
                Icon(Icons.Filled.Add, "Añadir tarea")
            }
        },
        // 4. Host para Snackbar (para mostrar mensajes temporales)
        snackbarHost = {
            SnackbarHost(snackbarHostState)
        },
        // 5. Contenido Principal de la Pantalla
        content = { innerPadding ->
            // El innerPadding es CRUCIAL. Asegura que el contenido no se solape
            // con la topBar ni la bottomBar.
            Column(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(innerPadding) // Aplica el padding de Scaffold aquí
                    .padding(horizontal = 16.dp) // Puedes añadir padding adicional a tu contenido
            ) {
                // Aquí iría la lógica para mostrar las tareas pendientes o completadas
                if (selectedTab == 0) {
                    Text(text = "Mostrando tareas PENDIENTES...", style = MaterialTheme.typography.headlineMedium)
                    // Aquí podrías listar tus tareas pendientes
                } else {
                    Text(text = "Mostrando tareas COMPLETADAS...", style = MaterialTheme.typography.headlineMedium)
                    // Aquí podrías listar tus tareas completadas
                }
                Text(text = "Usa la barra de navegación inferior para cambiar de vista.")
            }
        }
    )
}


@Preview(showBackground = true, widthDp = 360, heightDp = 700)
@Composable
fun MyTasksScreenPreview() {
    MaterialTheme { // Usamos MaterialTheme, pero tú usarías tu tema personalizado (MyFirstComposeAPPTheme)
        Surface(modifier = Modifier.fillMaxSize(), color = MaterialTheme.colorScheme.background) {
            MyTasksScreen()
        }
    }
}