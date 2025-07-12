package com.example.myfirstcomposeapp.components.state

import androidx.compose.foundation.clickable
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.DrawerDefaults.scrimColor
import androidx.compose.material3.DrawerState
import androidx.compose.material3.ModalDrawerSheet
import androidx.compose.material3.ModalNavigationDrawer
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.launch


@Composable

fun MyModalDrawer(drawerState: DrawerState, content: @Composable () -> Unit) {

    val scope: CoroutineScope = rememberCoroutineScope()

    ModalNavigationDrawer(
        drawerState = drawerState,
        drawerContent = {
            ModalDrawerSheet (
                drawerContainerColor = Color.Blue,
                drawerContentColor = Color.Red,
                //drawerShape= RoundedCornerShape(16.dp))
                //drawerShape= RoundedCornerShape(topEnd = 16.dp, bottomEnd = 16.dp))
                drawerShape= RoundedCornerShape(topEndPercent = 50, bottomStartPercent = 0))



                {
                    Text(
                        text = "Opción 1",
                        modifier = Modifier.clickable { scope.launch { drawerState.close() } })
                    Text(text = "Opción 2")
                    Text(text = "Opción 3")

                }

        },
        scrimColor = Color.Red
    ) {
        content()
    }
}


