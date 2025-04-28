package com.example.myfirstcomposeapp.components.state

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

@Composable
fun MyState(modifier: Modifier){
    var number by rememberSaveable {mutableStateOf (0)}
    Column(modifier = modifier) {
        Text("Pulsar: $number", modifier = modifier.clickable { number += 1 })
        Text("Pulsar: ", modifier = modifier.clickable { number +=1 })
        Text("Pulsar: $number", modifier = modifier.clickable { number +=1 })
        Text("Pulsar: ", modifier = modifier.clickable { number +=1 })
        Text("Pulsar: $number", modifier = modifier.clickable { number +=1 })

    }

}

//Ejercicio de recomponer las vistas o actualizacion de las vistas
//con el comando "rememberSaveable" se guarda el estado de la vista
//usando el operador "by" se obtiene el valor de la variable