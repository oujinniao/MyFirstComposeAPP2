package com.example.myfirstcomposeapp.components

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.HomeMax
import androidx.compose.material3.Icon
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.NavigationBarItemDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.tooling.preview.Preview

import com.example.myfirstcomposeapp.components.model.NavItem
import com.example.myfirstcomposeapp.ui.theme.MyFirstComposeAPPTheme

@Composable

fun MyNavigationBar(modifier: Modifier = Modifier) {
    val itemList:List<NavItem> = listOf(
     NavItem(name = "Home", Icons.Default.Home),
        NavItem(name = "Favorito",Icons.Default.Home),
        NavItem(name = "Profile", Icons.Default.HomeMax)

    )
    //selectedIndex se utiliza para saber que item esta seleccionado
    var selectedIndex by rememberSaveable { mutableIntStateOf(0) }
    NavigationBar(modifier = modifier) {
        // Usamos 'index' para obtener la posición de cada 'item' en la lista
        itemList.forEachIndexed { index, item ->
            NavigationBarItem(
                // 'selected' es TRUE si el 'selectedIndex' actual coincide con el 'index' de este ítem
                selected = selectedIndex == index,
                // Cuando se hace clic, actualizamos 'selectedIndex' al 'index' de este ítem
                onClick = { selectedIndex = index },
                // Icono del NavItem actual
                icon = { Icon(imageVector = item.icon, contentDescription = item.name) },
                // Texto del NavItem actual
                label = { Text(item.name) },
                alwaysShowLabel = false, // Puedes cambiar a 'true' si quieres que el texto siempre se vea
                colors = NavigationBarItemDefaults.colors(
                    selectedIconColor = Color.Red,
                    selectedTextColor = Color.Blue,
                    indicatorColor = Color.Green,
                    unselectedIconColor = Color.Gray, // Color para los no seleccionados
                    unselectedTextColor = Color.Gray  // Color para los no seleccionados
                )
            ) // <-- ¡Aquí cierra el NavigationBarItem!
        }
    }
}

// --- Preview para MyNavigationBar ---
@Preview(showBackground = true, name = "MyNavigationBar Preview")
@Composable
fun MyNavigationBarPreview() {
    MyFirstComposeAPPTheme {
        MyNavigationBar()
    }
}


