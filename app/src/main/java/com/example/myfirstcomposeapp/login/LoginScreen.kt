package com.example.myfirstcomposeapp.login


import androidx.compose.foundation.background
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.sp
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp


@Composable
fun Greeting(name: String, modifier: androidx.compose.ui.Modifier = androidx.compose.ui.Modifier) {
    Text(
        text = "Hello $name! kkoncity valparaiso",
        modifier = modifier
    )
}

@Preview()
@Composable
fun ExamploPreview() {
    Example("dde")
}
@Composable
fun Example(a:String) {
    Text(text = "HelloKKN $a", modifier = Modifier
        .padding(all = 24.dp)
        .background(Color.Red))
}
