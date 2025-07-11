package com.example.myfirstcomposeapp.components.state

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Menu
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.res.colorResource
import com.example.myfirstcomposeapp.R


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun MyTopAppBar() {
    TopAppBar(title ={Text("My Top App Bar")},
        navigationIcon = {Icon(Icons.Default.Menu,
            contentDescription = "Menu")},
        actions = {
            Icon(Icons.Default.Menu,
                contentDescription = "Menu")
        },
        colors = TopAppBarDefaults.topAppBarColors(
            containerColor = colorResource(id = R.color.teal_700),
            titleContentColor = colorResource(id = R.color.white),
            navigationIconContentColor = colorResource(id = R.color.black),
            actionIconContentColor = colorResource(id = R.color.purple_200)
        ),
        scrollBehavior = TopAppBarDefaults.enterAlwaysScrollBehavior()


        )




}