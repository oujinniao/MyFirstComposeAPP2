package com.example.myfirstcomposeapp.components.advance

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

@Composable
fun MyBasicList(modifier: Modifier = Modifier) {
    val names:List<String> = listOf("Juan", "Pedro", "Maria", "Isabel",
        "Juan", "Pedro", "Maria", "Isabel",
        "Juan", "Pedro", "Maria", "Isabel",
        "Juan", "Pedro", "Maria", "Isabel",
        "Juan", "Pedro", "Maria", "Isabel",
        "Juan", "Pedro", "Maria", "Isabel",
        "Juan", "Pedro", "Maria", "Isabel",
        "Juan", "Pedro", "Maria", "Isabel",
        "Juan", "Pedro", "Maria", "Isabel")
        ////LazyColumn {
                    LazyRow {
            items(names) {
                Text(it, modifier=Modifier.padding(24.dp))
            }

        }
}