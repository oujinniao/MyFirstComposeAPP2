package com.example.myfirstcomposeapp.components.state // Tu paquete actual

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Menu
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton // ¡Importar IconButton!
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.tooling.preview.Preview // Para la preview
import com.example.myfirstcomposeapp.R // Asegúrate de que R esté correctamente importado
import com.example.myfirstcomposeapp.ui.theme.MyFirstComposeAPPTheme // Para la preview

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun MyTopAppBar(
    modifier: Modifier = Modifier,
    onMenuClick: () -> Unit // Esta función se llamará cuando se haga clic en el icono de menú
) {
    TopAppBar(
        title = { Text("My Top App Bar") },
        modifier = modifier, // Aplica el modifier al TopAppBar completo
        navigationIcon = {
            // ¡Aquí está la clave! Envuelve el Icono en un IconButton
            IconButton(onClick = onMenuClick) { // <-- Este onClick es el que abrirá el Drawer
                Icon(
                    Icons.Default.Menu,
                    contentDescription = "Menu"
                )
            }
        },
        actions = { // <-- Abre la lambda de 'actions'
            IconButton(onClick = { /* Lógica para el botón de acción derecho, o onMenuClick */ }) { // <-- Abre IconButton y su lambda 'onClick'
                Icon(
                    Icons.Default.Menu, // Puedes cambiar este icono si es para otra acción
                    contentDescription = "More options"
                )
            } // <-- ¡Cierra la lambda 'onClick' del IconButton y luego el paréntesis de IconButton!
        }, // <-- ¡Cierra la lambda 'actions'!
        colors = TopAppBarDefaults.topAppBarColors(
            containerColor = colorResource(id = R.color.teal_700),
            titleContentColor = colorResource(id = R.color.white),
            navigationIconContentColor = colorResource(id = R.color.black),
            actionIconContentColor = colorResource(id = R.color.purple_200)
        ),
        scrollBehavior = TopAppBarDefaults.enterAlwaysScrollBehavior()
    ) // <-- ¡Cierra el paréntesis de TopAppBar!
} // <-- ¡Cierra la función MyTopAppBar!

// --- Preview para MyTopAppBar ---
@Preview(showBackground = true, name = "MyTopAppBar Preview")
@Composable
fun MyTopAppBarPreview() {
    MyFirstComposeAPPTheme {
        MyTopAppBar(onMenuClick = {}) // En la preview, la lambda no hace nada
    }
}
