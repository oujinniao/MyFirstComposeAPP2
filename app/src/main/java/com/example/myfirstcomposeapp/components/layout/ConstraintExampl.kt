package com.example.myfirstcomposeapp.components.layout

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.size
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.focus.FocusRequester.Companion.createRefs
import androidx.compose.ui.graphics.Color


import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.constraintlayout.compose.ChainStyle
import androidx.constraintlayout.compose.ConstraintLayout



@Composable
fun ConstraintExample1() {
    ConstraintLayout(modifier = Modifier.fillMaxSize()) {

        val (boxRed, boxBlue, boxYellow, boxMagenta, boxGreen) = createRefs()

        Box(modifier = Modifier.size(125.dp).background(Color.Green).constrainAs(boxGreen) {
            top.linkTo(parent.top)
            start.linkTo(parent.start)
            end.linkTo(parent.end)
            bottom.linkTo(parent.bottom)
        })
        Box(modifier = Modifier.size(125.dp).background(Color.Red).constrainAs(boxRed) {
            top.linkTo(boxGreen.bottom)
            start.linkTo(boxGreen.end)
        })
        Box(modifier = Modifier.size(125.dp).background(Color.Blue).constrainAs(boxBlue) {
            bottom.linkTo(boxGreen.top)
            end.linkTo(boxGreen.start)

        })
        Box(modifier = Modifier.size(125.dp).background(Color.Yellow).constrainAs(boxYellow) {

            bottom.linkTo(boxGreen.top)
            start.linkTo(boxGreen.end)


        })
        Box(modifier = Modifier.size(125.dp).background(Color.Magenta).constrainAs(boxMagenta) {
            top.linkTo(boxGreen.bottom)
            end.linkTo(boxGreen.start)


        })


    }
}
//Utiliza ConstarinAs para asignar un identificador a cada componente
//Las restricciones(Top, bottom, start, end)  estan vinculadas al Constraintlayout parent(padre)



//fun ConstraintExampleGuide() {
  //  ConstraintLayout(modifier = Modifier.fillMaxSize()) {
    //    val boxRed = createRef()
      //  val topGuide = createGuidelineFromTop(0.1f)
        //val startGuide = createGuidelineFromStart(0.25f)

        //Box(modifier = Modifier
          //  .size(125.dp)
            //.background(Color.Red)
            //.constrainAs(boxRed) {
            //top.linkTo(topGuide)
            //start.linkTo(startGuide)
        //})
        //}

    //}

@Composable
fun ConstraintBarrier() {
    ConstraintLayout(modifier = Modifier.fillMaxSize()) {
        val (boxRed, boxGreen, boxYellow) = createRefs()
        val barrier = createEndBarrier(boxRed, boxGreen)

Box(modifier = Modifier
    .size(25.dp)
    .background(Color.Green)
    .constrainAs(boxGreen) {
       start.linkTo(parent.start, margin = 16.dp)
})

        Box(modifier = Modifier
            .size(235.dp)
            .background(Color.Red)
            .constrainAs(boxRed) {
                top.linkTo(boxGreen.bottom)
                start.linkTo(parent.start, margin = 32.dp)
            })
            Box(Modifier.size(50.dp)
                .background(Color.Yellow)
                .constrainAs(boxYellow){
                    start.linkTo(barrier)
                    })
            }
}

//barrier es una barrera que se utiliza para crear restricciones entre componentes

@Preview
@Composable
fun ConstraintChainExample(){
    ConstraintLayout(modifier = Modifier.fillMaxSize()) {
        val (boxRed, boxGreen, boxYellow) = createRefs()

        Box(modifier=Modifier
            .size(75.dp)
            .background(Color.Green)
            .constrainAs(boxGreen) {
                start.linkTo(parent.start)
                end.linkTo(boxRed.start)

            })
        Box(modifier=Modifier
            .size(75.dp)
            .background(Color.Red)
            .constrainAs(boxRed){
                start.linkTo(boxGreen.end)
                end.linkTo(boxYellow.start)
            })
        Box(modifier=Modifier
            .size(75.dp)
            .background(Color.Yellow)
            .constrainAs(boxYellow) {
            start.linkTo(boxRed.end)
                end.linkTo(parent.end)

            })
createHorizontalChain(boxRed, boxGreen, boxYellow, chainStyle = ChainStyle.SpreadInside)
                 }

}

//createHorizontalChain(boxRed, boxGreen, boxYellow, chainStyle = ChainStyle.SpreadInside)
//estan enganchados los componentes horizontalmente
//tambien existe el createVertical
//los atributos son Spread y SpreadInside