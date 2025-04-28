package com.example.myfirstcomposeapp.components.layout
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.size
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color


import androidx.compose.ui.unit.dp
import androidx.constraintlayout.compose.ConstraintLayout


@Composable

fun MyBasicConstraintLayout(modifier: Modifier = Modifier) {
    ConstraintLayout(modifier = modifier.fillMaxSize()) {
        val (boxCyan, boxDarkGray, boxBlack, boxMagenta, boxGreen, boxYellow, boxGray, boxRed, boxBlue) = createRefs()

        Box(Modifier.size(150.dp).background(Color.Cyan).constrainAs(boxCyan) {


        })
        Box(Modifier.size(150.dp).background(Color.DarkGray).constrainAs(boxDarkGray) {



        })
        Box(Modifier.size(150.dp).background(Color.Black).constrainAs(boxBlack) {


        })
        Box(Modifier.size(150.dp).background(Color.Magenta).constrainAs(boxMagenta) {


        })

        Box(Modifier.size(200.dp).background(Color.Green).constrainAs(boxGreen) {



        })
        Box(Modifier.size(200.dp).background(Color.Yellow).constrainAs(boxYellow) {
    })
        Box(Modifier.size(200.dp).background(Color.Gray).constrainAs(boxGray) {
        })
        Box(Modifier.size(200.dp).background(Color.Red).constrainAs(boxRed) {
        })
        Box(Modifier.size(200.dp).background(Color.Blue).constrainAs(boxBlue) {
           bottom.linkTo(parent.bottom)

        })

        }
}