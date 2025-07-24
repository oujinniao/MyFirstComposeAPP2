package com.example.myfirstcomposeapp.components.navigation.examples.types

import android.net.Uri
import android.os.Build
import androidx.navigation.NavType
import androidx.savedstate.SavedState
import com.example.myfirstcomposeapp.components.navigation.examples.model.SettingModel
import kotlinx.serialization.encodeToString
import kotlinx.serialization.json.Json

val settingsModelType = object : NavType<SettingModel>(isNullableAllowed = true) {
    override fun get(bundle: SavedState, key: String): SettingModel? {
       return if (bundle.VERSION.SDK_INT > Build.VERSION_CODES.TIRAMISU){
           bundle.getParcelable(key,SettingModel::class.java)
       }else{

           bundle.getParcelable(key)
       }
    }

    override fun parseValue(value: String): SettingModel {
        return Json.decodeFromString(value)
    }

    override fun put(bundle: SavedState, key: String, value: SettingModel) {
      bundle.putParcelable(key,value)
    }
    override fun serializableAsValue(value:SettingModel): String {
        return Uri.encode(Json.encodeToString(value))
    }

}