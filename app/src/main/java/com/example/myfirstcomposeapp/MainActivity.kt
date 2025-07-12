package com.example.myfirstcomposeapp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.material3.DrawerState
import androidx.compose.material3.DrawerValue
import androidx.compose.material3.FabPosition
import androidx.compose.ui.Modifier
import com.example.myfirstcomposeapp.ui.theme.MyFirstComposeAPPTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.SnackbarHost
import androidx.compose.material3.SnackbarHostState
import androidx.compose.material3.SnackbarResult
import androidx.compose.material3.Text
import androidx.compose.material3.rememberDrawerState
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Alignment
import androidx.compose.ui.graphics.Color
import com.example.myfirstcomposeapp.components.MyNavigationBar
import com.example.myfirstcomposeapp.components.layout.MyButtonExample
import com.example.myfirstcomposeapp.components.state.MyModalDrawer
import com.example.myfirstcomposeapp.components.state.MyTopAppBar
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.launch

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContent {
            MyFirstComposeAPPTheme {
                val drawerState: DrawerState = rememberDrawerState(initialValue = DrawerValue.Closed)
                val snackbarHostState = remember { SnackbarHostState() }
                val scope: CoroutineScope = rememberCoroutineScope()

                MyModalDrawer(drawerState= drawerState) {
                    Scaffold(
                        modifier = Modifier.fillMaxSize(),
                        topBar = {
                            MyTopAppBar(
                                onMenuClick = { scope.launch { drawerState.open()}})
                        },
                        snackbarHost = { SnackbarHost(hostState = snackbarHostState) },
                        floatingActionButton = { MyButtonExample() },
                        floatingActionButtonPosition = FabPosition.Center,
                        bottomBar = { MyNavigationBar() },
                        containerColor = Color.Red,
                        contentColor = Color.White,


                        ) { innerPadding ->

                        Box(
                            modifier = Modifier.fillMaxSize()
                                .background(Color.Blue)
                                .padding(innerPadding),

                            contentAlignment = Alignment.Center
                        ) {
                            Text("My screen", modifier = Modifier.clickable {
                                scope.launch {
                                    val result: SnackbarResult = snackbarHostState.showSnackbar(
                                        message = "Has pulsado en el texto",
                                        actionLabel = "Deshacer"
                                    )
                                    when(result) {
                                        SnackbarResult.Dismissed -> println(("Has pulsado en dismiss"))
                                        SnackbarResult.ActionPerformed -> println("Has pulsado en action")

                                    }

                                }
                            })
                        }

                        // Surface(modifier = Modifier.fillMaxSize(),
                        //   color = MaterialTheme.colorScheme.background
                        //) {
                        //var status by rememberSaveable { mutableStateOf(false) }
                        //val checkInfo = CheckInfo(title = "Hola, box correcto",selected = status,
                        //  onCheckedChange = { myNewStatus -> status = myNewStatus }
                        //)
                        //Column(modifier = Modifier.fillMaxSize()) {
                        // ¡Aquí está el cambio! De 'MyCustomCheckb()' a 'MyCustomCheckbox()'
                        //MyCheckBox()
                        // Si quieres mostrar el MySwitch también:
                        //MySwitch()

                        //MyRadioButton()
                        //MyRadioButtonList()
                        //MySliders()
                        //MySlidersAdvance()
                        //MyRangeSlider()
                        //CountrySelectorDropdown()
                        //MyDropDownItem()
                        //MyDropDownMenu()
                        //MyExposedDropDownMenu()
                        //MyScaffoldScreen()
                        //MyTasksScreen()
                        //MyTasksScreenWithDrawer()
                        MyTopAppBar(onMenuClick = { scope.launch { drawerState.open() } })

                    }
                }
            }
        }
    }
}

  //  @Composable
    //fun MyStateExample() {
//
  //      var counter = rememberSaveable { mutableStateOf(0) } // Correction: Utiliza remember0
    //    // Tu código de Composable aquí
      //  Column(
        //    Modifier.fillMaxSize()
          //      .padding(16.dp), verticalArrangement = Arrangement.Center,
            //horizontalAlignment = Alignment.CenterHorizontally
        //) {
          //  Button(onClick = { counter.value += 1 }) { // Corrección: Agrega un cuerpo a la función onClick
            //    Text(text = "Haz clic")
            //}
            //Text(text = "Hola, has pulsado el boton ${counter.value} veces")
        //}
    //}
//
    //mutableStateof con remember para que el estado se recuerde
    //counter.value para acceder al valor del estado
    //rememberSaveable para que el estado se recuerde al cambiar de posicion la vista y no pierda su ciclo de vida
    //se puede cambiar de var a val importando import.androidx.compose.runtime.getValue y import androidx.compose.runtime.setValue
    // @Preview(showBackground = true)
    //@Composable
    //fun GreetingPreview() {
    //  MyFirstComposeAPPTheme { // Usa el tema de tu aplicación
    //    Greeting(name = "Android") // Llama al Composable Greeting, no a la clase
    //}
    //}
//}
    //@Preview(showBackground = true)
    //@Composable
    //fun DefaultPreview() {
      //  MyFirstComposeAPPTheme { // Usa el tema de tu aplicación
        //    ListaDeTareas(
          //      tareas = TODO()
            //)
        //}
   // }


// Suponiendo que Greeting es un Composable que has definido en otro lugar
//@Composable
//fun Greeting(name: String, modifier: Modifier = Modifier) {
    //  Text(
    //    text = "Hello $name!",
    //  modifier = modifier
    //)
//}
//
  //  @Composable
    //fun MyImageAdvance() {
      //  Image(
        //    painter = painterResource(id = R.drawable.ic_launcher_background),
          //  contentDescription = "Mi imagen",
            //modifier = Modifier.clip(RoundedCornerShape(25f))
       //     modifier = Modifier.clip(CircleShape)
         //       .border(5.dp, Color.Blue, CircleShape)
        //)
        //CircleShape es una forma de redondear la imagen
        //RoundedCornerShape(25f) es una forma de redondear la imagen con un radio de 25dp
        //border(5.dp, Color.Blue, CircleShape) es una forma de poner un borde a la imagen


    //}


    //@Composable
    //fun MyButtonExample() {
      //  var enabled by remember { mutableStateOf(true) }
        //Column(
          //  Modifier.fillMaxSize().padding(16.dp)
        //) {
          //  Button(
            //    onClick = { enabled = false },
              //  colors = ButtonDefaults.buttonColors(
                //    containerColor = Color.Blue,
                  //  contentColor = Color.White
                //),
                //border = BorderStroke(5.dp, Color.DarkGray)
            //) {
              //  Text(text = "Hola")
            //}
            //OutlinedButton(
              //  onClick = { enabled = false },
                //enabled = enabled,
                //colors = ButtonDefaults.outlinedButtonColors(
                  //  containerColor = Color.Blue,
                    //contentColor = Color.White
                //),
                //border = BorderStroke(5.dp, Color.DarkGray),
                //modifier = Modifier.padding(top = 8.dp)
            //) {
              //  Text(text = "Holanda")
            //}
            //TextButton(onClick = { }) {
              //  Text(text = "Hola")
            //}
        //}

    //}


    //@Composable
    //fun MyIcon() {
      //  Icon(
        //    imageVector = Icons.Rounded.StarBorderPurple500,
          //  contentDescription = "Mi icono",
            //tint = Color.Blue
        //)
    //}

    //@Composable
    //fun MyProgress() {
      //  var showLoading by rememberSaveable { mutableStateOf(false) }

        //Column(
          //  Modifier
            //    .padding(16.dp)
              //  .fillMaxSize(),
            //verticalArrangement = Arrangement.Center,
            //horizontalAlignment = Alignment.CenterHorizontally
        //) {

          //  if (showLoading) {
            //    CircularProgressIndicator(
              //      modifier = Modifier.padding(8.dp),
                //    color = Color.Blue,
                  //  strokeWidth = 12.dp
                //)
                //LinearProgressIndicator(
                  //  modifier = Modifier.padding(36.dp),
                    //color = Color.Red,

                    //trackColor = Color.Green,
                //)
            //}
            //Button(onClick = { showLoading = !showLoading }) {
              //  Text(text = "Cargar")
            //}

        //}
    //}

//con showLoading cargamos el circularprogressindicator y el linearprogressindicator
//o simplemente desaparecen al pinchar el boton cargar

//@Composable
//fun MyProgressAdvance() {
  //  var progressStatus by remember { mutableStateOf(0f) }
    //Column(
      //  Modifier.fillMaxSize(),
        //verticalArrangement = Arrangement.Center,
        //horizontalAlignment = Alignment.CenterHorizontally
    //) {
        //CircularProgressIndicator(progress = progressStatus)
      //  LinearProgressIndicator(progress = progressStatus)
        //Row (
          //  Modifier.fillMaxWidth()){
            //Button(onClick ={ progressStatus+= 0.1f}){
              //  Text(text = "Aumentar")
            //}
            //Button(onClick ={ progressStatus-=0.1f}){
              //  Text(text = "Reducir")
            //}

        //}

    //}


//}
//@Composable
//fun MySwitch() {
  //  var mySwitchState by rememberSaveable { mutableStateOf(true) }
    //Switch(
      //  checked = mySwitchState,
        //onCheckedChange = { mySwitchState = !mySwitchState },
        //enabled = true,
        //colors = SwitchDefaults.colors(
          //  uncheckedThumbColor = Color.Red,
            //uncheckedTrackColor = Color.Green,
            //checkedThumbColor = Color.Blue,
            //checkedTrackColor = Color.Yellow,
            //uncheckedBorderColor = Color.Magenta,
            //checkedBorderColor = Color.Cyan,
            //disabledCheckedTrackColor = Color.Gray,
            //disabledCheckedThumbColor = Color.Gray,
            //disabledUncheckedThumbColor = Color.Gray,
            //disabledUncheckedTrackColor = Color.Gray
            //))

//}

//shiwLoading se utiliza para mostrar o ocultar el circularprogressindicator
//enabled se utiliza para habilitar o deshabilitar el boton
//colors se utiliza para cambiar el color del boton
//border se utiliza para cambiar el borde del boton
//@Preview(showBackground = true)

//@Composable
//fun MyCheckBox(){
  //  var state by rememberSaveable { mutableStateOf(true) }
    //Checkbox(
      //  checked= state,
        //onCheckedChange = {state= it},
        //enabled = true,
        //colors = CheckboxDefaults.colors(
          //  checkedColor = Color.Red,
            //uncheckedColor = Color.Green,
            //checkmarkColor = Color.Blue
        //)
        //)
//}

//@Composable
//fun MyCheckBoxWithText(){
  //  var state by rememberSaveable { mutableStateOf(true) }
    //Row(Modifier.fillMaxWidth(),
      //  verticalAlignment = Alignment.CenterVertically) {
        //Checkbox(checked = state, onCheckedChange = {state= it})
        //Spacer(modifier=Modifier.width(8.dp))
        //Text(text = "Hola mundo")


    //}

//}
//@Composable
//fun ListaDeTareas(tareas: List<String>) {
    // Usamos rememberSaveable para sobrevivir cambios de configuración
  //  val estadosDeTareas = rememberSaveable {
        // Inicializamos un estado para cada tarea, con valor inicial false (no completada)
    //    tareas.map { mutableStateOf(false) }
    //}
//
  //  Column {
    //    tareas.forEachIndexed { index, tarea ->
      //      Row(
        //        verticalAlignment = Alignment.CenterVertically,
          //      modifier = Modifier.padding(8.dp)
            //) {
              //  Checkbox(
                //    checked = estadosDeTareas[index].value,
                  //  onCheckedChange = { isChecked ->
                        // Actualizamos el estado de la tarea específica
                    //    estadosDeTareas[index].value = isChecked
                    //},
                    //modifier = Modifier.padding(end = 8.dp)
                //)
                //Text(text = tarea)
            //}
        //}
    //}
//}

//@Preview(showBackground = true)
//@Composable
//fun PrevisualizacionListaDeTareas() {
  //  val tareas = listOf("Hacer la compra", "Lavar la ropa", "Estudiar", "Hacer ejercicio")
    //ListaDeTareas(tareas = tareas)
//}
//@Composable
//fun MyCheckBoxWithTextCompleted(checkInfo: CheckInfo){
  //  Row(Modifier.padding(8.dp)){
    //    Checkbox(checked = checkInfo.selected,
      //      onCheckedChange = {checkInfo.onCheckedChange(!checkInfo.selected)})
        //Spacer(modifier=Modifier.width(8.dp))
        //Text(text = checkInfo.title)
    //}


//}