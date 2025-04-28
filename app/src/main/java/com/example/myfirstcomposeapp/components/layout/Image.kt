package com.example.myfirstcomposeapp.components.layout

import android.util.Log
import androidx.compose.foundation.Image
import androidx.compose.foundation.border
import androidx.compose.foundation.content.MediaType.Companion.Image
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import coil.compose.AsyncImage
import com.example.myfirstcomposeapp.R



@Preview(showBackground = true)
@Composable
fun MyImage() {
    Image(painter = painterResource(R.drawable.perfildewsp),
        contentDescription = "image profile",
        modifier = Modifier
        .size(300.dp)
        .clip(RoundedCornerShape(35.dp))
            .border(width = 5.dp, shape = CircleShape,
                brush = Brush.linearGradient(colors = listOf(Color.Yellow, Color.Red, Color.Blue))),
                contentScale = ContentScale.FillBounds)
}

@Composable
fun MyNetworkImage() {
    AsyncImage(
        model = "https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcQsJ-R9nVADSM-SvdADLHhRgpYY6ci7CLbPSD6STG3OwmzTCtsLsS5VfeUSBtd7OyoIk_c&usqp=CAU",
        contentDescription = "image profile",
        modifier = Modifier
            .size(300.dp),
        onError = {
            Log.d("AsyncImage", "Hay un error: ${it.result.throwable.message}")
        }
    )
}











