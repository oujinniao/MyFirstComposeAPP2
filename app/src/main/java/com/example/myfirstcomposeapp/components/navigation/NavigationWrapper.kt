package com.example.myfirstcomposeapp.components.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.toRoute // Importar toRoute
import com.example.myfirstcomposeapp.components.navigation.examples.DetailScreen
import com.example.myfirstcomposeapp.components.navigation.examples.HomeScreen
import com.example.myfirstcomposeapp.components.navigation.examples.LoginScreen
import com.example.myfirstcomposeapp.components.navigation.examples.model.SettingModel
import com.example.myfirstcomposeapp.components.navigation.examples.model.SettingScreen

@Composable
fun NavigationWrapper() {
    val navController: NavHostController = rememberNavController()
    NavHost(navController = navController, startDestination = Login) { // startDestination es el objeto Login

        composable<Login> {
            LoginScreen(navController = navController)
        }

        composable<Home> {
            HomeScreen(
                navigateBack = { navController.popBackStack() },
                navigateToDetail = { id -> navController.navigate(Detail(id = id)) } // Aquí se llama a la ruta Detail
            )
        }

        // ¡¡¡Asegúrate de que este composable<Detail> sea un HIJO DIRECTO del NavHost!!!
        composable<Detail> { navBackStackEntry ->
            val detail: Detail = navBackStackEntry.toRoute()
            DetailScreen(
                id = detail.id,
                navigateToSettings = { settingModel -> navController.navigate(Settings(settingModel)) },
                navigateBack = { navController.popBackStack() }
            )
        }

        // ¡¡¡Asegúrate de que este composable<Settings> sea un HIJO DIRECTO del NavHost!!!
        composable<Settings> { navBackStackEntry ->
            val setting: Settings = navBackStackEntry.toRoute<Settings>()
            SettingScreen(
                settingModel = setting.settingModel,
                navigateBack = { navController.popBackStack() }
            )
        }
    }
}
