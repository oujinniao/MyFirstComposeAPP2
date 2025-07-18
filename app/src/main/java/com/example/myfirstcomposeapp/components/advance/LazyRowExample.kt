package com.example.myfirstcomposeapp.components.advance
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width // Importar Modifier.width
import androidx.compose.foundation.lazy.LazyRow // ¡Importar LazyRow!
import androidx.compose.foundation.lazy.items // Importar items para LazyRow
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.myfirstcomposeapp.ui.theme.MyFirstComposeAPPTheme

data class ListItemsData(val id: Int, val title: String, val description: String)

@Composable
fun LazyRowExample(modifier: Modifier = Modifier){
    val items = (1..1000).map { i ->
        ListItemsData(i, "Título $i", "Descripción $i")
    }
    LazyRow (
        modifier=modifier.fillMaxSize(),
        contentPadding = PaddingValues(horizontal = 16.dp, vertical = 8.dp),

    ){
        items(items){ item ->
            Card(
                modifier = Modifier
                    .width(200.dp)
                    .padding(horizontal =  4.dp),
                colors=CardDefaults.cardColors(
                    containerColor = MaterialTheme.colorScheme.surfaceVariant
                ),
                elevation = CardDefaults.cardElevation(defaultElevation = 2.dp)
                ){
                Column (
                    modifier = Modifier.padding(8.dp)

                ){
                    Text(
                        text = item.title,
                        fontSize = 20.sp,
                        color = Color.Black
                    )
                    Spacer(modifier = Modifier.height(8.dp))
                    Text(
                        text = item.description,
                        fontSize = 16.sp,
                        color = Color.Gray)
                }
            }

            }
    }
}
