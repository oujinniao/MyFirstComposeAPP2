package com.example.myfirstcomposeapp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold // Importar Scaffold
import androidx.compose.material3.SnackbarHost // Importar SnackbarHost
import androidx.compose.material3.SnackbarHostState // Importar SnackbarHostState
import androidx.compose.material3.Surface
import androidx.compose.runtime.remember // Importar remember
import androidx.compose.runtime.rememberCoroutineScope // Importar rememberCoroutineScope
import androidx.compose.ui.Modifier
import com.example.myfirstcomposeapp.ui.theme.MyFirstComposeAPPTheme
import com.example.myfirstcomposeapp.components.advance.LazyColumnExample // Importar LazyColumnExample
import com.example.myfirstcomposeapp.components.advance.ListItemData // Importar ListItemData
import com.example.myfirstcomposeapp.components.advance.MyAdvanceList
import kotlinx.coroutines.launch // Importar launch para coroutines

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContent {
            MyFirstComposeAPPTheme {
                // Estado y Scope para el Snackbar
                val snackbarHostState = remember { SnackbarHostState() }
                val scope = rememberCoroutineScope()

                Scaffold(
                    modifier = Modifier.fillMaxSize(),
                    snackbarHost = { SnackbarHost(hostState = snackbarHostState) } // Colocar el SnackbarHost
                ) { innerPadding -> // Recibir el padding del Scaffold
                    Surface(
                        modifier = Modifier
                            .fillMaxSize()
                            .padding(innerPadding), // Aplicar el padding al Surface
                        color = MaterialTheme.colorScheme.background
                    ) {
                        // Llamar a LazyColumnExample y pasarle la lambda onItemClick
                        MyAdvanceList()
                           // onItemClick = { clickedItem: ListItemData ->
                                // Cuando se haga clic en un ítem, mostrar un Snackbar
                                //scope.launch {
                                   // snackbarHostState.showSnackbar("Clic en: ${clickedItem.title}")
                                }
                            }

                    }
                }
            }
        }
