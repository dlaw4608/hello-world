package com.setu.foodtrack.ui

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.livedata.observeAsState
import com.setu.foodtrack.ui.AppViewModel


@Composable
fun FoodSearchScreen(viewModel: AppViewModel) {
    val foods by viewModel.foods.observeAsState(emptyList())

    Column {
        TextField(
            value = "apple",
            onValueChange = { viewModel.fetchFoods(it) },
            label = { Text("Search Food") }
        )

        if (foods.isEmpty()) {
            Text(text = "Loading...")
        } else {
            LazyColumn {
                items(foods) { food ->
                    Text(text = "${food.name}: ${food.calories} calories")
                }
            }
        }
    }
}
