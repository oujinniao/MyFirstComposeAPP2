package com.example.myfirstcomposeapp

import ChecklistExampleWithDerivedState
import MyLaunchedEffect
import MyScreenWithOneTimeEffect
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Email // Importar icono de Email para el Badge
import androidx.compose.material3.Badge // Importar Badge
import androidx.compose.material3.BadgedBox // Importar BadgedBox para posicionar el Badge
import androidx.compose.material3.Icon // Importar Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text // Importar Text
import androidx.compose.runtime.Composable // Importar Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview // Importar Preview
import com.example.myfirstcomposeapp.components.advance.DerivedStateOfExample
import com.example.myfirstcomposeapp.components.advance.InteractionSourceExample
import com.example.myfirstcomposeapp.components.advance.LazyColumnExample
import com.example.myfirstcomposeapp.components.advance.LazyRowExample
import com.example.myfirstcomposeapp.components.advance.MyBasicList
import com.example.myfirstcomposeapp.components.advance.MyDerivedStateOf
import com.example.myfirstcomposeapp.components.advance.MyInteractiveButton

import com.example.myfirstcomposeapp.components.advance.MyScreenWithEffect

import com.example.myfirstcomposeapp.components.dialogs.MyAlertDialogExample
import com.example.myfirstcomposeapp.components.dialogs.MyDateDialog
import com.example.myfirstcomposeapp.components.dialogs.MyDialog
import com.example.myfirstcomposeapp.components.dialogs.MyTimePicker
import com.example.myfirstcomposeapp.components.state.MyBadge
import com.example.myfirstcomposeapp.components.state.MyBadgeBox
import com.example.myfirstcomposeapp.components.state.MyDivider


import com.example.myfirstcomposeapp.ui.theme.MyFirstComposeAPPTheme // Importar tu tema

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContent {
            MyFirstComposeAPPTheme {
                // Una superficie simple para el fondo de la pantalla
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    // Un Column para centrar el Composable que quieres probar
                    Box(
                        modifier = Modifier.fillMaxSize(),
                        contentAlignment = Alignment.Center

                    ) {
                        // ¡Aquí es donde pones el Composable que quieres probar!
                        // Por ejemplo, tu ejemplo de Badge:
                        //MyBadge()
                        //MyBadgeBox(
                         //   modifier = Modifier.align(Alignment.TopEnd)
                        //)

                        // Si quisieras probar MyCard, lo llamarías aquí:
                        // MyCard()

                        // Si quisieras probar MyRadioButton, lo llamarías aquí:
                        // MyRadioButton()



                        //MyDivider()
                        //MyAlertDialogExample()
                        //MyDialog()
                        //MyDateDialog()
                        //MyTimePicker()
                        //MyInteractiveButton()
                        //InteractionSourceExample()
                        //MyScreenWithEffect()
                        //MyLaunchedEffect{}
                        //MyScreenWithOneTimeEffect()
                        //DerivedStateOfExample()
                        //MyDerivedStateOf()
                        //ChecklistExampleWithDerivedState()
                        //LazyColumnExample()
                        //LazyRowExample()
                        MyBasicList()

                    }
                }
            }
        }
    }
}
