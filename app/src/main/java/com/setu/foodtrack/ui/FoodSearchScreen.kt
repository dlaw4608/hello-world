package com.setu.foodtrack.ui
/*https://hardiksachan.com/how-to-create-a-search-view-in-jetpack-compose-a-step-by-step-guide*/
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.text.BasicTextField
import androidx.compose.material3.Button
import androidx.compose.material3.Text

import androidx.compose.runtime.*
import androidx.compose.runtime.livedata.observeAsState
import androidx.lifecycle.viewmodel.compose.viewModel

@Composable
fun FoodSearchScreen(viewModel: AppViewModel = viewModel()) {
    var searchText by remember { mutableStateOf("") }


    val foods = viewModel.foods.observeAsState(initial = emptyList())

    Column {
        BasicTextField(
            value = searchText,
            onValueChange = { searchText = it },
            decorationBox = { innerTextField ->
                if (searchText.isEmpty()) {
                    Text("Enter food name")
                }
                innerTextField()
            }
        )
        Button(onClick = { viewModel.fetchFoods(searchText) }) {
            Text("Search")
        }

        foods.value.forEach { food ->
            Text(text = "Food: ${food.name}")
        }
    }
}
