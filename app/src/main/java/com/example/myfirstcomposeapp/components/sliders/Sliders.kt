package com.example.myfirstcomposeapp.components.sliders

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.RangeSlider
import androidx.compose.material3.RangeSliderState
import androidx.compose.material3.Slider
import androidx.compose.material3.SliderDefaults
import androidx.compose.material3.SliderState
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableFloatStateOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp

@Composable

fun MySliders(modifier: Modifier=Modifier) {
    var myValue: Float by remember { mutableFloatStateOf(0f) }
    Column(
        modifier = modifier.padding(horizontal=30.dp)
        ){
        Slider(
            value = myValue,
            onValueChange = { myValue = it },
            colors = SliderDefaults.colors(
                thumbColor = Color.Red,
                disabledThumbColor = Color.DarkGray,
                activeTrackColor = Color.Red,
                activeTickColor = Color.Blue,
                inactiveTickColor = Color.Green,
                inactiveTrackColor = Color.Yellow
            ))

        Text(myValue.toString())

    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun MySlidersAdvance(modifier: Modifier=Modifier) {
    val state: SliderState = remember { SliderState(
        value = 5f,
        valueRange = 0f..10f,
        steps = 9,

    ) }

    Column (
        modifier = modifier.padding(horizontal=30.dp)){
        Slider(state = state,
            thumb = {state:SliderState ->Text(text = state.value.toString())},
            )

        Text(text = state.value.toString())
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable

fun MyRangeSlider(modifier: Modifier=Modifier){
    var state:RangeSliderState = remember { RangeSliderState(
        activeRangeStart = 3f,
        activeRangeEnd = 7f,
        valueRange = 0f..10f,
        steps = 9
    )}


    Column(modifier=modifier.padding(horizontal=30.dp)){
        RangeSlider(state = state,
            colors = SliderDefaults.colors(
            thumbColor = Color.Red,
            disabledThumbColor = Color.DarkGray,
            activeTrackColor = Color.Red,
            activeTickColor=Color.Blue,
            inactiveTickColor=Color.Green,
            inactiveTrackColor=Color.Yellow,
                ),

            startThumb ={
                Box(Modifier.size(30.dp).clip(CircleShape).background(Color.Red))
                Text(text = state.activeRangeStart.toString())
            }
            ,endThumb={
                Text(text = state.activeRangeEnd.toString())
            }
            )

    }
}

