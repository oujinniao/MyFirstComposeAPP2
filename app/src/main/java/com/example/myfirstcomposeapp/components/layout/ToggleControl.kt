package com.example.myfirstcomposeapp.components.layout

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Icon
import androidx.compose.material3.Switch
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.material3.Checkbox
import androidx.compose.material3.CheckboxDefaults
import androidx.compose.material3.RadioButton
import androidx.compose.material3.RadioButtonDefaults
import androidx.compose.material3.SwitchDefaults
import androidx.compose.material3.Text
import androidx.compose.material3.TriStateCheckbox
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.state.ToggleableState
import androidx.compose.ui.unit.dp
import com.example.myfirstcomposeapp.R.drawable.persona
import com.example.myfirstcomposeapp.components.CheckBoxState
import kotlinx.coroutines.selects.select

@Composable
fun MySwitch(modifier: Modifier = Modifier) {
    var switchState by remember { mutableStateOf(true) }
    Box(modifier = modifier.fillMaxSize(), contentAlignment = Alignment.Center) {
        Switch(
            checked = switchState,
            onCheckedChange = { switchState = it },
            thumbContent = {
                Icon(
                    painter = painterResource(id = persona),
                    contentDescription = "Imagen de persona",
                )
            }, enabled = true,
            colors = SwitchDefaults.colors(
                checkedThumbColor = Color.Red,
                checkedBorderColor = Color.Green,
                //track
                checkedTrackColor = Color.White,
                uncheckedThumbColor = Color.Yellow,
                uncheckedBorderColor = Color.Magenta,
                uncheckedTrackColor = Color.Black,

                )
        )

    }
}

@Composable
fun MyCheckBox(modifier:Modifier = Modifier) {
    var state by remember { mutableStateOf(true) }
    Box(modifier = modifier.fillMaxSize(), contentAlignment = Alignment.Center) {
        Row(verticalAlignment = Alignment.CenterVertically, modifier = Modifier.clickable { state = !state }) {
            Checkbox(
                checked = state,
                onCheckedChange = { state = it },
                enabled = true,
                // habilita el checkbox cuando es true
                //enabled = false,
                colors = CheckboxDefaults.colors(
                    checkedColor = Color.Red,
                    uncheckedColor = Color.Blue,
                    checkmarkColor = Color.Blue,
                    disabledCheckedColor = Color.Green,
                    disabledUncheckedColor = Color.Yellow,
                    disabledIndeterminateColor = Color.Magenta
                )
            )

        Spacer(modifier = Modifier.width(8.dp))
            Text("Acepto los términos y condiciones")

        }
    }
}

@Composable
fun ParentCheckBox(modifier: Modifier = Modifier) {

    var checkboxStates by remember {
        mutableStateOf(
            listOf(
                CheckBoxState(id = "1", label = "Opción 1", checked = false),
                CheckBoxState(id = "2", label = "Opción 2", checked = false),
                CheckBoxState(id = "3", label = "Opción 3", checked = false)
            )
        )
    }
    Column(modifier = modifier) {
        checkboxStates.forEach { currentCheckBoxState ->
            CheckBoxWithText(
                checked = currentCheckBoxState.checked,
                label = currentCheckBoxState.label,
                onCheckedChange = { newheckedValue ->
                    checkboxStates = checkboxStates.map { item ->
                        if (item.id == currentCheckBoxState.id) {
                            //item.copy(checked = !item.checked)
                            item.copy(checked = newheckedValue)
                        } else {
                            item
                        }
                    }
                }
            )
        }
    }
}





                    @Composable
                    fun CheckBoxWithText(
                        modifier: Modifier = Modifier,
                        checked: Boolean,
                        label: String,
                        //checkBoxState: CheckBoxState,
                        onCheckedChange: (Boolean) -> Unit
                    ) {

                        Row(
                            verticalAlignment = Alignment.CenterVertically,
                            modifier = Modifier.clickable { onCheckedChange(!checked) }) {
                            Checkbox(
                                checked = checked,
                                onCheckedChange = { newValue -> onCheckedChange(newValue) },
                                enabled = true
                            )
                            Spacer(Modifier.width(12.dp))
                            Text(label)
                        }
                    }


@Composable
fun TriStateChecBox(modifier: Modifier = Modifier) {
    var parentState by remember { mutableStateOf(ToggleableState.Off) }
    var child1 by remember { mutableStateOf(true) }
    var child2 by remember { mutableStateOf(true) }

    LaunchedEffect(child1, child2) {
        parentState = when {child1 && child2-> ToggleableState.On
            !child1 && !child2 -> ToggleableState.Off
         else -> ToggleableState.Indeterminate
        }
    }


    Column(modifier = modifier) {
        Row(verticalAlignment = Alignment.CenterVertically) {
            TriStateCheckbox(parentState, onClick = {
               val newState: Boolean = parentState !=ToggleableState.On
                child1=newState
                child2=newState

            })
            Text("Seleccionar todas las casillas")
        }
        Row(verticalAlignment = Alignment.CenterVertically,
            modifier=Modifier.padding(horizontal = 16.dp)) {
            Checkbox(child2, onCheckedChange = { child1 = it })
            Text("Child 1")
        }
        Row(verticalAlignment = Alignment.CenterVertically,
            modifier=Modifier.padding(horizontal = 16.dp)) {
            Checkbox(child2, onCheckedChange = { child2 = it })
            Text("Child2 ")
        }
    }
}


@Composable
fun MyRadioButton(modifier: Modifier = Modifier) {
    var state by remember { mutableStateOf(false) }
    Row(modifier = modifier, verticalAlignment = Alignment.CenterVertically) {
      RadioButton(
          selected = state,
          onClick = { state = true  },
          enabled = true,
          colors = RadioButtonDefaults.colors(
              selectedColor = Color.Red,
              unselectedColor = Color.Blue,
              disabledSelectedColor = Color.Green)
      )
        Text("Ejemplo de radio buttton")
    }

}

@Composable
fun MyRadioButtonList(modifier: Modifier = Modifier) {
    var selectedName by remember { mutableStateOf("") }
    Column (modifier = modifier){
        RadioButtonComponent(name = "Ejemplo 1", selectedName = selectedName) { selectedName = it }
        RadioButtonComponent(name = "Ejemplo 2", selectedName = selectedName) { selectedName = it }
        RadioButtonComponent(name = "Ejemplo 3", selectedName = selectedName) { selectedName = it }
        RadioButtonComponent(name = "Ejemplo 4", selectedName = selectedName) { selectedName = it }
    }
}

    @Composable
    fun RadioButtonComponent(name: String,
                             selectedName: String, onItemSelect: (String) -> Unit, ) {
        Row(verticalAlignment = Alignment.CenterVertically) {
            RadioButton(selected = name == selectedName, onClick = { onItemSelect(name) })
            Text(text = name, modifier = Modifier.clickable { onItemSelect(name) })
        }

    }







