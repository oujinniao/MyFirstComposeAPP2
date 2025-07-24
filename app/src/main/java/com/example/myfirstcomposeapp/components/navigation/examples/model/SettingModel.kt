package com.example.myfirstcomposeapp.components.navigation.examples.model

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize
import kotlinx.serialization.Serializable

@Serializable
@Parcelize
data class SettingModel(val id:String,val darckMode:Boolean):Parcelable
