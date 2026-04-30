package com.example.uikit.TabBar

import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.uikit.R
import com.example.uikit.UI.Accent
import com.example.uikit.UI.Placeholder
import com.example.uikit.UI.Typography


data class TabBarItems(
    val name: String,
    val path: Int
)


fun ListTabBar() = listOf<TabBarItems>(
    TabBarItems( "Главная",R.drawable.home),
    TabBarItems( "Каталог",R.drawable.catalog),
    TabBarItems( "Заказы", R.drawable.orders),
    TabBarItems( "Профиль",R.drawable.user)
)

@Composable
fun TabBar(
    current: String,
    onClick: (String) -> Unit
){
    Box(modifier = Modifier.fillMaxSize(), contentAlignment = Alignment.BottomCenter) {
        Row(
            Modifier.fillMaxWidth().height(88.dp)
                .border(1.dp, Placeholder)
                .padding(8.dp), horizontalArrangement = Arrangement.SpaceBetween
        ) {
            ListTabBar().forEach { items ->
                Column(
                    modifier = Modifier
                        .width(76.dp)
                        .height(49.dp)
                        .clickable { onClick(items.name) },
                    verticalArrangement = Arrangement.Center,
                    horizontalAlignment = Alignment.CenterHorizontally
                ) {
                    Icon(
                        painter = painterResource(items.path),
                        contentDescription = null,
                        tint = if (current == items.name) Accent else Placeholder,
                        modifier = Modifier.size(24.dp)

                    )
                    Text(
                        items.name, style = Typography().Caption2Regular,
                        color = if (current == items.name) Accent else Placeholder
                    )

                }
            }
        }
    }
}

@Preview
@Composable
fun PreviewBlockTabBar(){

    Column() {
        TabBar("Главная", {})
    }

}