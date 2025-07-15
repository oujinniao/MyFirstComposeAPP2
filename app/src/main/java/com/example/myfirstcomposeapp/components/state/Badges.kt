package com.example.myfirstcomposeapp.components.state

import androidx.compose.material3.Badge
import androidx.compose.material3.BadgedBox
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.foundation.layout.size
import com.example.myfirstcomposeapp.R


@Composable
fun MyBadge(modifier: Modifier = Modifier){
    Badge(
        modifier = modifier,
        containerColor = Color.Red,
        contentColor = Color.Blue
    ){
        Text(text = "5")


    }

}


@Composable
fun MyBadgeBox(modifier: Modifier = Modifier){
    BadgedBox (modifier = modifier,badge = { MyBadge() }){
        Icon(painter = painterResource(id = R.drawable.shopping_cart_24),
            contentDescription = "carrito de compras",
            tint = Color.Blue,
            modifier = Modifier.size(34.dp)
            )
    }
}




