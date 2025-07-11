
package com.example.myfirstcomposeapp // Asegúrate de que tu paquete sea el correcto

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.Done
import androidx.compose.material.icons.filled.ExitToApp // Importar para Cerrar Sesión
import androidx.compose.material.icons.filled.List
import androidx.compose.material.icons.filled.Menu
import androidx.compose.material.icons.filled.Person // Importar para Mi Perfil
import androidx.compose.material.icons.filled.Settings // Importar para Configuración
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.ModalDrawerSheet // Importar para el contenido del Drawer
import androidx.compose.material3.ModalNavigationDrawer // Importar el Drawer principal
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.NavigationDrawerItem // Importar para los ítems del Drawer
import androidx.compose.material3.Scaffold
import androidx.compose.material3.SnackbarHost
import androidx.compose.material3.SnackbarHostState
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.material3.rememberDrawerState // Importar para el estado del Drawer
import androidx.compose.material3.DrawerValue // Importar DrawerValue para el estado inicial
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

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun MyTasksScreenWithDrawer() {
    val snackbarHostState = remember { SnackbarHostState() }
    val scope = rememberCoroutineScope()
    var selectedTab by remember { mutableStateOf(0) } // 0 para Pendientes, 1 para Completadas

    // 1. Estado del Cajón de Navegación
    val drawerState = rememberDrawerState(initialValue = DrawerValue.Closed) // El cajón inicia cerrado

    // 2. ModalNavigationDrawer como contenedor principal
    ModalNavigationDrawer(
        drawerState = drawerState,
        // 3. Contenido del Cajón (lo que se ve cuando se abre)
        drawerContent = {
            ModalDrawerSheet { // ModalDrawerSheet es un buen contenedor para los ítems del drawer
                // Encabezado del cajón (opcional)
                Text("Menú de la Aplicación", modifier = Modifier.padding(16.dp))
                Spacer(Modifier.height(8.dp))

                // Ítems de navegación dentro del cajón
                NavigationDrawerItem(
                    label = { Text("Mi Perfil") },
                    icon = { Icon(Icons.Filled.Person, contentDescription = "Perfil") },
                    selected = false, // Los ítems del drawer no suelen tener estado de selección como las BottomBar
                    onClick = {
                        scope.launch { drawerState.close() } // Cierra el cajón al hacer clic
                        scope.launch { snackbarHostState.showSnackbar("Ir a Perfil") }
                        // Aquí iría la navegación real (ej. navController.navigate("profile"))
                    }
                )
                NavigationDrawerItem(
                    label = { Text("Configuración") },
                    icon = { Icon(Icons.Filled.Settings, contentDescription = "Configuración") },
                    selected = false,
                    onClick = {
                        scope.launch { drawerState.close() }
                        scope.launch { snackbarHostState.showSnackbar("Ir a Configuración") }
                    }
                )
                // Un separador para agrupar ítems
                Spacer(Modifier.height(16.dp))
                NavigationDrawerItem(
                    label = { Text("Cerrar Sesión") },
                    icon = { Icon(Icons.Filled.ExitToApp, contentDescription = "Cerrar Sesión") },
                    selected = false,
                    onClick = {
                        scope.launch { drawerState.close() }
                        scope.launch { snackbarHostState.showSnackbar("Cerrando sesión...") }
                    }
                )
            }
        }
    ) {
        // 4. Scaffold dentro del ModalNavigationDrawer
        Scaffold(
            topBar = {
                TopAppBar(
                    title = { Text("Mis Tareas con Cajón") },
                    colors = TopAppBarDefaults.topAppBarColors(
                        containerColor = MaterialTheme.colorScheme.primaryContainer,
                        titleContentColor = MaterialTheme.colorScheme.primary,
                    ),
                    navigationIcon = {
                        // Este botón ABRIRÁ el cajón
                        IconButton(onClick = { scope.launch { drawerState.open() } }) {
                            Icon(Icons.Filled.Menu, contentDescription = "Abrir Cajón de Navegación")
                        }
                    }
                )
            },
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
            floatingActionButton = {
                FloatingActionButton(onClick = {
                    scope.launch {
                        snackbarHostState.showSnackbar("¡Añadir nueva tarea!")
                    }
                }) {
                    Icon(Icons.Filled.Add, "Añadir tarea")
                }
            },
            snackbarHost = {
                SnackbarHost(snackbarHostState)
            },
            content = { innerPadding ->
                Column(
                    modifier = Modifier
                        .fillMaxSize()
                        .padding(innerPadding)
                        .padding(horizontal = 16.dp)
                ) {
                    if (selectedTab == 0) {
                        Text(text = "Mostrando tareas PENDIENTES...", style = MaterialTheme.typography.headlineMedium)
                        Text(text = "Desliza desde el borde izquierdo o toca el ícono de menú para abrir el cajón.")
                    } else {
                        Text(text = "Mostrando tareas COMPLETADAS...", style = MaterialTheme.typography.headlineMedium)
                    }
                }
            }
        )
    }
}


@Preview(showBackground = true, widthDp = 360, heightDp = 700)
@Composable
fun MyTasksScreenWithDrawerPreview() {
    MaterialTheme { // O tu tema personalizado
        Surface(modifier = Modifier.fillMaxSize(), color = MaterialTheme.colorScheme.background) {
            MyTasksScreenWithDrawer()
        }
    }
}