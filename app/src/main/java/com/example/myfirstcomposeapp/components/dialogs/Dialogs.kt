package com.example.myfirstcomposeapp.components.dialogs

import android.annotation.SuppressLint
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Delete
import androidx.compose.material3.AlertDialog
import androidx.compose.material3.Button
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.DatePicker
import androidx.compose.material3.DatePickerDefaults
import androidx.compose.material3.DatePickerDialog
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.SelectableDates
import androidx.compose.material3.TimePicker
import androidx.compose.material3.TimePickerDefaults
import androidx.compose.material3.TimePickerLayoutType
import androidx.compose.material3.TimePickerState
import androidx.compose.material3.rememberDatePickerState
import androidx.compose.material3.rememberTimePickerState
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.window.Dialog
import androidx.compose.ui.window.DialogProperties
import androidx.compose.ui.window.SecureFlagPolicy
import com.example.myfirstcomposeapp.ui.theme.MyFirstComposeAPPTheme
import java.util.Calendar // Importación correcta para Calendar

// Eliminadas importaciones redundantes/incorrectas que no se usan en esta versión:
// import androidx.compose.material3.AlertDialogDefaults.containerColor
// import androidx.compose.material3.AlertDialogDefaults.iconContentColor
// import androidx.compose.material3.AlertDialogDefaults.textContentColor
// import androidx.compose.material3.AlertDialogDefaults.titleContentColor
// import androidx.compose.ui.graphics.ImageBitmapConfig
// import androidx.compose.ui.input.key.Key.Companion.Calendar
// import org.intellij.lang.annotations.JdkConstants.CalendarMonth
// import androidx.compose.ui.graphics.Color.Companion.Yellow // No usada

@Composable
fun MyDialog(modifier: Modifier = Modifier) {
    var showDialog by remember { mutableStateOf(true) }
    if(showDialog){
        AlertDialog(
            onDismissRequest = { showDialog = false },
            confirmButton = {
                Button(onClick = { showDialog = false }) {
                    Text("Aceptar")
                }
            },
            dismissButton = {
                Button(onClick = { showDialog = false }) {
                    Text("Cancelar")
                }
            },
            title = { Text("Confirma la accion") },
            icon = { Icon(modifier = Modifier.size(52.dp), imageVector = Icons.Default.Delete, contentDescription = "Eliminar") },
            shape = RoundedCornerShape(12.dp), // Usar .dp
            containerColor = Color.White,
            iconContentColor = Color.Red,
            titleContentColor = Color.Green,
            textContentColor = Color.Blue,
            properties = DialogProperties(
                dismissOnBackPress = true,
                dismissOnClickOutside = true,
                securePolicy = SecureFlagPolicy.Inherit,
                usePlatformDefaultWidth = true,
                decorFitsSystemWindows = true
            ),
            text = { Text("Hola") }
        )
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun MyDateDialog(modifier: Modifier = Modifier){
    var showDialog by remember { mutableStateOf(true) }

    val calendar: Calendar = Calendar.getInstance()
    calendar.add(Calendar.DAY_OF_YEAR, +1)
    calendar.set(Calendar.MONTH, Calendar.JANUARY)

    val datePickerState = rememberDatePickerState(
        initialSelectedDateMillis = calendar.timeInMillis, // 'timeInMillis' es correcto
        initialDisplayedMonthMillis = calendar.timeInMillis,
        yearRange = 1990..2025,
        selectableDates = object :SelectableDates {
            @SuppressLint("SuspiciousIndentation")
            override fun isSelectableDate(utcTimeMillis: Long): Boolean {
                val filterCalendar: Calendar =
                    Calendar.getInstance().apply { timeInMillis = utcTimeMillis }
                val day = filterCalendar.get(Calendar.DAY_OF_MONTH)
                    return day % 2==0
            }


        }

    )
    if(showDialog){
        DatePickerDialog(
            onDismissRequest = { showDialog = false },
            confirmButton = {
                Button(onClick = {
                    showDialog = false
                val result:Long?=datePickerState.selectedDateMillis
                    if(result!=null){
                        val newCalendar: Calendar = Calendar.getInstance().apply { timeInMillis = result }
                    }

                }) {
                    Text("Aceptar")
                }
            },
            dismissButton = {
                Button(onClick = { showDialog = false }) {
                    Text("Cancelar")
                }
            },  colors = DatePickerDefaults.colors()
        ) {
            DatePicker(state = datePickerState)
        }
    }
}

// --- Previews para los Dialogs ---
@Preview(showBackground = true, name = "MyDialog Preview")
@Composable
fun MyDialogPreview() {
    MyFirstComposeAPPTheme {
        MyDialog()
    }
}

@Preview(showBackground = true, name = "MyDateDialog Preview")
@Composable
fun MyDateDialogPreview() {
    MyFirstComposeAPPTheme {
        MyDateDialog()
    }
}
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun MyTimePicker(modifier: Modifier=Modifier) {
    var showTimePicker by remember { mutableStateOf(true) }
    val timePickerState: TimePickerState = rememberTimePickerState(
        initialMinute = 12,
        initialHour = 12,
        is24Hour = true


    )

    if (showTimePicker) {
        Dialog(onDismissRequest = { showTimePicker = false }) {
            Column(modifier = Modifier.background(Color.White).padding(24.dp)) {
                TimePicker(timePickerState,
                    layoutType = TimePickerLayoutType.Vertical,
                    colors = TimePickerDefaults.colors(

                        clockDialColor = Color.Green,
                        clockDialSelectedContentColor = Color.Red,
                        selectorColor = Color.Blue,
                        periodSelectorUnselectedContainerColor = Color.Magenta,
                        periodSelectorUnselectedContentColor = Color.Yellow,
                        periodSelectorSelectedContainerColor = Color.Cyan,
                        periodSelectorSelectedContentColor = Color.Black,


                    )
                )


            }


        }


    }
}
