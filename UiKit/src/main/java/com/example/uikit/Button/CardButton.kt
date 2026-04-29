package com.example.uikit.Button

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import com.example.uikit.R
import com.example.uikit.UI.Typography
import com.example.uikit.UI.White
import com.example.uikit.UI.colorButton

@Composable
fun CardButton(
    cost: String,
    onClick: () -> Unit,
    text: String = "В корзине",
){
    Button(
        onClick,
        modifier = Modifier.fillMaxWidth()
            .height(56.dp),
        contentPadding = PaddingValues(16.dp),
        colors = colorButton(),
        shape = RoundedCornerShape(10.dp)
    ) {
        Row(modifier = Modifier.fillMaxSize(),
            horizontalArrangement = Arrangement.Absolute.SpaceBetween
        ) {
            Row(horizontalArrangement = Arrangement.spacedBy(16.dp)) {
                Icon(painter = painterResource(R.drawable.icon_shopping_cart),
                    tint = White, contentDescription = null)
                Text(
                    text = text,
                    style = Typography().Title3Semibold
                )
            }
            Text(
                text = "$cost ₽",
                style = Typography().Title3Semibold
            )
        }
    }
}