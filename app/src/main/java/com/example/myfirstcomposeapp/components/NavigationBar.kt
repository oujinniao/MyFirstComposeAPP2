package com.example.myfirstcomposeapp.components

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Home
import androidx.compose.material3.Icon
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.NavigationBarItemDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import com.example.myfirstcomposeapp.R

@Composable

fun MyNavigationBar(modifier: Modifier = Modifier) {
    NavigationBar {
        NavigationBarItem(selected = false, onClick = { },
            icon = { Icon(imageVector = Icons.Default.Home, contentDescription = "Home") },
            label = { Text(text = "Home") })


        NavigationBarItem(
            selected = true,
            onClick = { },
            icon = {Icon(painter = painterResource(R.drawable.home_work_24),
                    contentDescription = "Home"
                )
            },
            label = { Text(text = "A casa") },
                colors = NavigationBarItemDefaults.colors(
                selectedIconColor = Color.Red,
                selectedTextColor = Color.Blue,
                    indicatorColor = Color.Green,
                    unselectedIconColor = Color.Blue,
                    unselectedTextColor = Color.Blue
                )
            )


    }
}



