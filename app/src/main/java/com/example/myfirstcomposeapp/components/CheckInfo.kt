package com.example.myfirstcomposeapp.components

data class CheckInfo(
    val title: String,
                     val selected: Boolean=false,
                     var onCheckedChange: (Boolean) -> Unit)
