package com.example.myfirstcomposeapp.components.navigation

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.myfirstcomposeapp.components.navigation.examples.HomeScreen
import com.example.myfirstcomposeapp.components.navigation.examples.LoginScreen
import com.example.myfirstcomposeapp.components.navigation.Home // Importar objeto Home
import com.example.myfirstcomposeapp.components.navigation.Login // Importar objeto Login

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
            HomeScreen(navController = navController)
        }
    }
}
