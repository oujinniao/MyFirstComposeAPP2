package com.example.myfirstcomposeapp.components.navigation

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier // Mantener si se usa en algún Composable anidado
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.toRoute // Importar toRoute
import com.example.myfirstcomposeapp.components.navigation.examples.DetailScreen
import com.example.myfirstcomposeapp.components.navigation.examples.HomeScreen
import com.example.myfirstcomposeapp.components.navigation.examples.LoginScreen

@Composable
fun NavigationWrapper() {
    val navController: NavHostController = rememberNavController()
    NavHost(navController = navController, startDestination = Login) {
        composable<Login> {
            // LoginScreen ahora recibe navController directamente
            LoginScreen(navController = navController)
        }
        composable<Home> {
            // HomeScreen ahora recibe las lambdas para navegar
            HomeScreen(
                navigateBack = { navController.popBackStack() },
                navigateToDetail = { id -> navController.navigate(Detail(id = id)) }
            )
        }
        // ¡¡¡CORRECCIÓN CLAVE: SINTAXIS CORRECTA PARA composable<Detail>!!!
        composable<Detail> { navBackStackEntry -> // Esto es una función, no una anotación
            val detail: Detail = navBackStackEntry.toRoute()
            DetailScreen(
                id = detail.id,
                navigateBack = { navController.popBackStack() } // Pasar la lambda para regresar
            )
        }
    }
}
