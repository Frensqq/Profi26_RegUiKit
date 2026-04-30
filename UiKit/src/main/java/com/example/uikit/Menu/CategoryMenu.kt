package com.example.uikit.Menu

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.grid.LazyHorizontalGrid
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.uikit.Button.Chips
import java.util.Locale

@Composable
fun CategoryMenu(
    currentCategory: String,
    onClick: (String) -> Unit,
    listCategory: List<String> = listOf("Популярные","Женщинам","Мужчинам","Детям","Аксессуары")
){
    LazyRow(
        horizontalArrangement = Arrangement.spacedBy(16.dp)
    ) {
        items(listCategory){category->
            Chips(category, {
                onClick(category)
            }, category == currentCategory)
        }
    }
}

@Preview
@Composable
fun PreviewCategoryMenu(){

    val ListCateg: List<String> = listOf("Популярные","Женщинам","Мужчинам","Детям","Аксессуары")
    var currentCategory by remember { mutableStateOf(ListCateg[0]) }

    CategoryMenu(currentCategory,onClick = { currCateg ->
        currentCategory = currCateg
    }, ListCateg,

    )
}