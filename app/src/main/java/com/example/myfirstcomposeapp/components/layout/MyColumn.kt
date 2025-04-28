package com.example.myfirstcomposeapp.components.layout

import androidx.compose.ui.graphics.Color

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier

import androidx.compose.ui.tooling.preview.Preview


@Preview(showBackground = true)
@Composable
fun MyColumn(modifier: Modifier = Modifier) {
    Column (
        modifier = modifier.fillMaxSize().verticalScroll(rememberScrollState()),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ){

        Text("Hello1", modifier = Modifier.background(Color.Red))
        Text("Hello2", modifier = Modifier.background(Color.Blue))
        Text("Hello3", modifier = Modifier.background(Color.Yellow))
        Text("Hello4", modifier = Modifier.background(Color.Black))
        Text("Hello5", modifier = Modifier.background(Color.Red))
        Text("Hello6", modifier = Modifier.background(Color.Yellow))
        Text("Hello1", modifier = Modifier.background(Color.Red))
        Text("Hello2", modifier = Modifier.background(Color.Blue))
        Text("Hello3", modifier = Modifier.background(Color.Yellow))
        Text("Hello4", modifier = Modifier.background(Color.Black))
        Text("Hello5", modifier = Modifier.background(Color.Red))
        Text("Hello6", modifier = Modifier.background(Color.Yellow))
        Text("Hello1", modifier = Modifier.background(Color.Red))
        Text("Hello2", modifier = Modifier.background(Color.Blue))
        Text("Hello3", modifier = Modifier.background(Color.Yellow))
        Text("Hello4", modifier = Modifier.background(Color.Black))
        Text("Hello5", modifier = Modifier.background(Color.Red))
        Text("Hello6", modifier = Modifier.background(Color.Yellow))
        Text("Hello1", modifier = Modifier.background(Color.Red))
        Text("Hello2", modifier = Modifier.background(Color.Blue))
        Text("Hello3", modifier = Modifier.background(Color.Yellow))
        Text("Hello4", modifier = Modifier.background(Color.Black))
        Text("Hello5", modifier = Modifier.background(Color.Red))
        Text("Hello6", modifier = Modifier.background(Color.Yellow))
        Text("Hello1", modifier = Modifier.background(Color.Red))
        Text("Hello2", modifier = Modifier.background(Color.Blue))
        Text("Hello3", modifier = Modifier.background(Color.Yellow))
        Text("Hello4", modifier = Modifier.background(Color.Black))
        Text("Hello5", modifier = Modifier.background(Color.Red))
        Text("Hello6", modifier = Modifier.background(Color.Yellow))
        Text("Hello1", modifier = Modifier.background(Color.Red))
        Text("Hello2", modifier = Modifier.background(Color.Blue))
        Text("Hello3", modifier = Modifier.background(Color.Yellow))
        Text("Hello4", modifier = Modifier.background(Color.Black))
        Text("Hello5", modifier = Modifier.background(Color.Red))
        Text("Hello6", modifier = Modifier.background(Color.Yellow))
    }

}
