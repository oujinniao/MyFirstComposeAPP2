package com.example.myfirstcomposeapp.components.navigation

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.toRoute // Importar toRoute
import com.example.myfirstcomposeapp.components.navigation.examples.HomeScreen
import com.example.myfirstcomposeapp.components.navigation.examples.LoginScreen
import com.example.myfirstcomposeapp.components.navigation.examples.DetailScreen

@Composable
fun NavigationWrapper() {
    val navController: NavHostController = rememberNavController()
    NavHost(navController = navController, startDestination = Login) {
        composable<Login> {
            // ¡Pasamos el navController a LoginScreen!
            LoginScreen(navController = navController)
        }
        composable<Home> {
            // ¡Pasamos el navController a HomeScreen!
            HomeScreen(
                navigateBack = { navController.popBackStack() },
                navigateToDetail = { navController.navigate(Detail(id = it)) })

            composable<Detail> { navBackStackEntry ->
                var detail: Detail = navBackStackEntry.toRoute<Detail>()

                DetailScreen(id=detail.id,// ¡Pasamos el id a DetailScreen!
                    navigateBack = { navController.popBackStack() })//
            }
        }
    }
}
