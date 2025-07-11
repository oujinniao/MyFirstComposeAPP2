package com.example.myfirstcomposeapp.scaffold

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add // Icono de añadir
import androidx.compose.material.icons.filled.Menu // Icono de menú
import androidx.compose.material3.ExperimentalMaterial3Api // Para TopAppBar y Scaffold
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold // Importa Scaffold
import androidx.compose.material3.SnackbarHost
import androidx.compose.material3.SnackbarHostState
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar // Importa TopAppBar
import androidx.compose.material3.TopAppBarDefaults // Para colores de TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import kotlinx.coroutines.launch // Para corrutinas si usas Snackbar

@OptIn(ExperimentalMaterial3Api::class) // Anotación necesaria para TopAppBar y Scaffold
@Composable
fun MyScaffoldScreen() {
    val snackbarHostState = remember { SnackbarHostState() }
    val scope = rememberCoroutineScope() // Necesario para lanzar corrutinas (para Snackbar)

    Scaffold(
        // 1. Barra superior (TopAppBar)
        topBar = {
            TopAppBar(
                title = { Text("Mi Aplicación con Scaffold") },
                colors = TopAppBarDefaults.topAppBarColors(
                    containerColor = MaterialTheme.colorScheme.primaryContainer,
                    titleContentColor = MaterialTheme.colorScheme.primary,
                ),
                navigationIcon = { // Icono de navegación (ej. para abrir un drawer)
                    IconButton(onClick = { /* Acción para abrir el drawer */ }) {
                        Icon(Icons.Filled.Menu, contentDescription = "Menú")
                    }
                },
                actions = { // Acciones a la derecha
                    IconButton(onClick = { /* Acción de búsqueda */ }) {
                        Icon(Icons.Filled.Add, contentDescription = "Añadir")
                    }
                }
            )
        },
        // 2. Botón de acción flotante (FAB)
        floatingActionButton = {
            FloatingActionButton(onClick = {
                scope.launch { // Usar corrutina para mostrar Snackbar
                    snackbarHostState.showSnackbar("¡FAB clickeado!")
                }
            }) {
                Icon(Icons.Filled.Add, "Añadir elemento")
            }
        },
        // 3. Host para Snackbar
        snackbarHost = {
            SnackbarHost(snackbarHostState)
        },
        // 4. Contenido principal de la pantalla
        content = { innerPadding -> // El 'innerPadding' es CRUCIAL. Scaffold lo proporciona.
            Column(
                modifier = Modifier
                    .fillMaxSize()
                    // Aplicar el padding proporcionado por Scaffold.
                    // Esto evita que el contenido se solape con la topBar o bottomBar.
                    .padding(innerPadding)
                    .padding(16.dp) // Puedes añadir padding adicional a tu contenido si quieres
            ) {
                Text(text = "Bienvenido a mi pantalla construida con Scaffold.")
                Text(text = "El contenido principal va aquí.")
                Text(text = "Scaffold se encarga de la disposición de la barra superior, FAB, etc.")
            }
        }
    )
}


@Preview(showBackground = true, widthDp = 360, heightDp = 640)
@Composable
fun MyScaffoldScreenPreview() {
    MaterialTheme { // O tu tema personalizado
        Surface(modifier = Modifier.fillMaxSize()) {
            MyScaffoldScreen()
        }
    }
}