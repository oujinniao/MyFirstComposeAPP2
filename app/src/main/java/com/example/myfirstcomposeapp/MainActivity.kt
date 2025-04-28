package com.example.myfirstcomposeapp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.layout.*
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.myfirstcomposeapp.ui.theme.MyFirstComposeAPPTheme
import androidx.compose.material3.Button // Importa el componente Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.ui.Alignment
import androidx.compose.ui.graphics.Color
import com.example.myfirstcomposeapp.components.Progress
import com.example.myfirstcomposeapp.components.ProgressAnimation

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            MyFirstComposeAPPTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    // Usando innerPadding para el contenido principal del Scaffold
                    Column(modifier = Modifier.padding(innerPadding)) {
                        (Modifier.fillMaxSize())
                        MyButtonExample()

                        // MyNetworkImage() // Comentado para evitar errores de compilación si no está completamente definido
                        // Greeting(name = "Android") // Corrección: Llama al Composable Greeting correctamente
                    }
                }
            }
        }
    }

    @Composable
    fun MyStateExample() {

        var counter= rememberSaveable {mutableStateOf(0)} // Correction: Utiliza remember0
        // Tu código de Composable aquí
        Column(Modifier.fillMaxSize()
            .padding(16.dp)
            , verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally) {
            Button(onClick = { counter.value +=1 }) { // Corrección: Agrega un cuerpo a la función onClick
                Text(text = "Haz clic")
            }
            Text(text = "Hola, has pulsado el boton ${counter.value} veces")
        }
    }
    //mutableStateof con remember para que el estado se recuerde
    //counter.value para acceder al valor del estado
    //rememberSaveable para que el estado se recuerde al cambiar de posicion la vista y no pierda su ciclo de vida
    //se puede cambiar de var a val importando import.androidx.compose.runtime.getValue y import androidx.compose.runtime.setValue
    @Preview(showBackground = true)
    @Composable
    fun GreetingPreview() {
        MyFirstComposeAPPTheme { // Usa el tema de tu aplicación
            Greeting(name = "Android") // Llama al Composable Greeting, no a la clase
        }
    }

    @Preview(showBackground = true)
    @Composable
    fun DefaultPreview() {
        MyFirstComposeAPPTheme { // Usa el tema de tu aplicación
            MyButtonExample()
        }
    }
}

// Suponiendo que Greeting es un Composable que has definido en otro lugar
@Composable
fun Greeting(name: String, modifier: Modifier = Modifier) {
    Text(
        text = "Hello $name!",
        modifier = modifier
    )
}

@Composable
fun MyButtonExample() {
    Column (
        Modifier.fillMaxSize().padding(16.dp)) {
            Button(
                onClick = { },
                colors = ButtonDefaults.buttonColors(containerColor = Color.Blue,
                    contentColor = Color.White),
                border = BorderStroke(5.dp,Color.DarkGray)
            ){
                Text(text = "Hola")
            }


            }

        }




