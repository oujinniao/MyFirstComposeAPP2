package com.example.myfirstcomposeapp.components.layout

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material3.Button
import androidx.compose.material3.DropdownMenu
import androidx.compose.material3.DropdownMenuItem
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.ExposedDropdownMenuBox
import androidx.compose.material3.ExposedDropdownMenuDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.MenuDefaults
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.DpOffset
import androidx.compose.ui.unit.dp
import androidx.compose.ui.window.PopupProperties
import com.example.myfirstcomposeapp.R


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun MyExposedDropDownMenu(modifier: Modifier = Modifier) {
    var expanded: Boolean  by remember { mutableStateOf(false) }
    var selection: String  by remember { mutableStateOf("") }
    ExposedDropdownMenuBox(modifier=modifier, expanded = expanded, onExpandedChange = {expanded = !expanded}) {
    TextField(
        value = selection,
        onValueChange = { },
        readOnly = true,
        label = { Text("Label")},
        modifier = Modifier
            .menuAnchor()
            .fillMaxWidth(),
        trailingIcon = {
            ExposedDropdownMenuDefaults.TrailingIcon(expanded = expanded)
        }
        )
        DropdownMenu(
            expanded=expanded,onDismissRequest = { expanded = false }){
            DropdownMenuItem(text = { Text("Opción 1") },onClick = {
                selection = "Opción 1"
                expanded = false
            })
            DropdownMenuItem(text = { Text("Opción 2") },onClick = {
                selection = "Opción 2"
                expanded = false
            })
            DropdownMenuItem(text = { Text("Opción 3") },onClick = {
                selection = "Opción 3"
                expanded = false
            })
            DropdownMenuItem(text = { Text("Opción 4") },onClick = {
                selection = "Opción 4"
                expanded = false
            })
        }

            }




    }




@Composable
fun MyDropDownMenu(modifier: Modifier = Modifier) {
    var expanded: Boolean  by remember { mutableStateOf(false) }
    Box(modifier=modifier) {
        Button(onClick = { expanded = true }) {
            Text("Mostrar menú desplegable")

        }
        DropdownMenu(
            expanded=expanded,
            onDismissRequest = { expanded = false },
            offset = DpOffset(56.dp, 16.dp),
            properties = PopupProperties(
                dismissOnBackPress = true,
                dismissOnClickOutside = true,
                focusable = true
            )
            )
        {
            DropdownMenuItem(text = { Text("Opción 1") },onClick = { })
            DropdownMenuItem(text = { Text("Opción 2") },onClick = { })
            DropdownMenuItem(text = { Text("Opción 3") },onClick = { })
            DropdownMenuItem(text = { Text("Opción 4") },onClick = { })

        }
    }

}



@Composable
fun MyDropDownItem(modifier: Modifier = Modifier) {
    Column(modifier = modifier) {
    DropdownMenuItem(
        modifier = Modifier.fillMaxWidth(),
        text = { Text("Opción 1") },
        leadingIcon = {
            Icon(
                painter=painterResource(R.drawable.ic_launcher_jpc_foreground),
                contentDescription = "Opción 1"


            )
        },
        trailingIcon = {
            Icon(
                painter=painterResource(R.drawable.ic_launcher_background),
                contentDescription = "")
        },
        contentPadding = PaddingValues(start= 16.dp),
        colors = MenuDefaults.itemColors(
            textColor = Color.Red,
            leadingIconColor = Color.Yellow,
                trailingIconColor = Color.Blue,
        ),

        onClick = { }

    )

    }
}