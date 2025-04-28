package com.example.myfirstcomposeapp.components

import androidx.activity.result.contract.ActivityResultContracts.PickVisualMedia.DefaultTab.AlbumsTab.value
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.unit.dp


@Composable
fun MyTextFieldParent(modifier: Modifier){
    var user by remember { mutableStateOf("kkn") }
    var value by remember { mutableStateOf("") }

    Column(modifier = modifier) {
        MyTextField(user= user) {user = it}
        Spacer(modifier = Modifier.size(10.dp))
        MySecondTextField(value = value) {value = it}
        Spacer(modifier = Modifier.size(10.dp))
        MyAdvanceTextField(value = value) {value = it}
        Spacer(modifier = Modifier.size(10.dp))
        MyPasswordTextField(value = value) {value = it}
        Spacer(modifier = Modifier.size(10.dp))
        MyOutlinedTextField(value = value) {value = it}
    }

}


@Composable
fun MyTextField(user: String, onValueChange: (String) -> Unit){
    TextField(user, onValueChange = {onValueChange(it)},
        readOnly = user.isEmpty())
    }

@Composable
fun MySecondTextField(value: String, onValueChange: (String) -> Unit) {
    TextField(value, onValueChange = { onValueChange(it) }, placeholder = {
        Box(Modifier.size(40.dp).background(Color.Red))
    }, label = {Text("kknnnnn")})
}

//placeholder permite colocar un texto en el campo de texto
//label permite colocar un texto debajo del campo de texto


@Composable
fun MyAdvanceTextField(value: String, onValueChange: (String) -> Unit){
   TextField(value = value, onValueChange = {
   // if(it.contains("a")){
        onValueChange(it.replace("a", ""))
    //}else{
      // onValueChange(it)}


})
}

@Composable
fun MyPasswordTextField(value: String, onValueChange: (String) -> Unit) {
    var passwordHidden by remember { mutableStateOf(true) }
    TextField(
        value = value,
        onValueChange = { onValueChange(it) },
        singleLine = true, // Corregido a singleLine
        label = { Text("Ingresa tu Password") },
        keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Password),
        visualTransformation = if (passwordHidden) PasswordVisualTransformation() else VisualTransformation.None,
        trailingIcon = {
            Text(text = if (passwordHidden) "Mostrar" else "Ocultar",
                modifier = Modifier.clickable { passwordHidden = !passwordHidden })
        })
}
@Composable
fun MyOutlinedTextField(value: String, onValueChange: (String) -> Unit) {
    OutlinedTextField(value = value, onValueChange = { onValueChange(it) })

    //BasicTextField(value = value, onValueChange = { onValueChange(it) })
    //es una clase que permite personalizar el TextField
}


