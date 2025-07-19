package com.example.myfirstcomposeapp


import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold // Importar Scaffold
import androidx.compose.material3.SnackbarHost // Importar SnackbarHost
import androidx.compose.material3.SnackbarHostState // Importar SnackbarHostState
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.remember // Importar remember
import androidx.compose.runtime.rememberCoroutineScope // Importar rememberCoroutineScope
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import com.example.myfirstcomposeapp.ui.theme.MyFirstComposeAPPTheme
import com.example.myfirstcomposeapp.components.advance.LazyColumnExample // Importar LazyColumnExample
import com.example.myfirstcomposeapp.components.advance.ListItemData // Importar ListItemData
import com.example.myfirstcomposeapp.components.advance.MyAdvanceList
import com.example.myfirstcomposeapp.components.advance.MyGridList
import com.example.myfirstcomposeapp.components.advance.MyHorizontalGridList
import com.example.myfirstcomposeapp.components.advance.ProductGridExample

import kotlinx.coroutines.launch // Importar launch para coroutines
import kotlin.random.Random

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
                        //MyBasicList{}

                        //MyAdvanceList()
                        //MyGridList()
                        //MyHorizontalGridList()
                        ProductGridExample()


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
