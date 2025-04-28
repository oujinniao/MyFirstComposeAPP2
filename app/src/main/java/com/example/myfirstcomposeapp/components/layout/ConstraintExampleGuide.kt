package com.example.myfirstcomposeapp.components.layout

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.size
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.focus.FocusRequester.Companion.createRefs
import androidx.compose.ui.graphics.Color.Companion.Cyan
import androidx.compose.ui.graphics.Color.Companion.Green
import androidx.compose.ui.graphics.Color.Companion.Red
import androidx.compose.ui.graphics.Color.Companion.Yellow

import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.constraintlayout.compose.ChainStyle
import androidx.constraintlayout.compose.ConstraintLayout
import com.example.myfirstcomposeapp.login.Greeting
import com.example.myfirstcomposeapp.ui.theme.MyFirstComposeAPPTheme



@Preview
@Composable
fun ConstraintChain(modifier: Modifier=Modifier) {
    ConstraintLayout(modifier = modifier.fillMaxSize()) {
        val (boxRed, boxCyan, boxYellow) = createRefs()

        Box(Modifier.size(100.dp).background(Red).constrainAs(boxRed) {
            start.linkTo(parent.start)
            end.linkTo(parent.end)
            top.linkTo(parent.top)
            bottom.linkTo(boxYellow.top)

        })

        Box(Modifier.size(100.dp).background(Yellow).constrainAs(boxYellow) {
            start.linkTo(parent.start)
            end.linkTo(parent.end)
            top.linkTo(boxRed.bottom)
            bottom.linkTo(boxCyan.top)


        })
        Box(modifier = Modifier.size(100.dp).background(Cyan).constrainAs(boxCyan) {
            start.linkTo(parent.start)
            end.linkTo(parent.end)
            top.linkTo(boxYellow.bottom)
            bottom.linkTo(parent.bottom)
        })
        createVerticalChain(boxRed, boxYellow, boxCyan, chainStyle = ChainStyle.SpreadInside)
    }
}

