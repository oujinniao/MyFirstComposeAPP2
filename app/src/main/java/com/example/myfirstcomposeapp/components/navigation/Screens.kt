package com.example.myfirstcomposeapp.components.navigation

import com.example.myfirstcomposeapp.components.navigation.examples.model.SettingModel
import kotlinx.serialization.Serializable

@Serializable
object Login

@Serializable
object Home

@Serializable
data class Detail(val id: String, val test: String )

@Serializable
data class Settings(val settingModel: SettingModel)

//@Serializable
//data class LoginScreen(val settingModel: SettingModel)