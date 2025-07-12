package com.example.myfirstcomposeapp.components.state


import androidx.compose.material3.Icon
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Home
import androidx.compose.material3.Badge
import androidx.compose.material3.DrawerDefaults.scrimColor
import androidx.compose.material3.DrawerState
import androidx.compose.material3.ModalDrawerSheet
import androidx.compose.material3.ModalNavigationDrawer
import androidx.compose.material3.NavigationDrawerItem
import androidx.compose.material3.NavigationDrawerItemDefaults
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
            ModalDrawerSheet(
                drawerContainerColor = Color.Blue,
                drawerContentColor = Color.Red,
                //drawerShape= RoundedCornerShape(16.dp))
                //drawerShape= RoundedCornerShape(topEnd = 16.dp, bottomEnd = 16.dp))
                drawerShape = RoundedCornerShape(
                    topEndPercent = 16,
                    bottomEndPercent = 15,
                    bottomStartPercent = 13
                )
            )


            {
                Spacer(Modifier.height(32.dp))
                NavigationDrawerItem(
                    label = { Text(text = "Opción 1") },
                    selected = false,
                    onClick = { },
                    icon = { Icon(imageVector = Icons.Default.Home, contentDescription = null) },
                    badge = { Badge { Text(text = "1") } },
                    shape = RoundedCornerShape(16.dp),
                    modifier = Modifier.clickable { scope.launch { drawerState.close() } },
                    colors = NavigationDrawerItemDefaults.colors(
                        selectedContainerColor = Color.Red,
                        selectedTextColor = Color.White,
                        selectedIconColor = Color.White,
                        unselectedBadgeColor = Color.Magenta

                    )
                )
                Spacer(Modifier.height(32.dp))
                NavigationDrawerItem(
                    label = { Text(text = "Opción 1") },
                    selected = false,
                    onClick = { },
                    icon = { Icon(imageVector = Icons.Default.Home, contentDescription = null) },
                    badge = { Badge { Text(text = "1") } },
                    shape = RoundedCornerShape(16.dp),
                    modifier = Modifier.clickable { scope.launch { drawerState.close() } },
                    colors = NavigationDrawerItemDefaults.colors(
                        selectedContainerColor = Color.Red,
                        selectedTextColor = Color.White,
                        selectedIconColor = Color.White,
                        unselectedBadgeColor = Color.Magenta

                    )
                )
            }

            // Text(
            //   text = "Opción 1",
            // modifier = Modifier.clickable { scope.launch { drawerState.close() } })
            //Text(text = "Opción 2",
            //modifier = Modifier.clickable { scope.launch { drawerState.close() } })
            //Text(text = "Opción 3"
            //  ,modifier = Modifier.clickable { scope.launch { drawerState.close() } })


        }, scrimColor = Color.Red
    ) {
        content()
    }
}


