package com.example.uikit.Modal

import androidx.compose.foundation.background
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
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.geometry.Size
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.uikit.Button.BigButton
import com.example.uikit.Components.Overlay
import com.example.uikit.Components.SpacerH
import com.example.uikit.R
import com.example.uikit.UI.Black
import com.example.uikit.UI.Description
import com.example.uikit.UI.InputIcon
import com.example.uikit.UI.Placeholder
import com.example.uikit.UI.Typography
import com.example.uikit.UI.White

@Composable
fun Modal(
    Title: String,
    ApproximateСost: String,
    Text: String,
    textButton: String,
    state: Boolean,
    onClick: () -> Unit,
    onExit: () -> Unit
){
    Overlay(
    ) {
        Box(Modifier.fillMaxSize(), contentAlignment = Alignment.BottomCenter) {
            Column(
                modifier = Modifier.fillMaxWidth().height(636.dp)
                    .clip(RoundedCornerShape(topStart = 24.dp, topEnd = 24.dp)).background(White)
                    .padding(20.dp), verticalArrangement = Arrangement.Bottom
            ) {

                SpacerH(4)
                Row(
                    Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.SpaceBetween,
                    verticalAlignment = Alignment.Top
                ) {
                    Text(
                        Title,
                        style = Typography().Title2Semibold,
                        color = Black,
                        maxLines = 2,
                        modifier = Modifier.fillMaxWidth(0.7f)
                    )

                    Box(
                        Modifier.size(24.dp).clip(CircleShape).background(InputIcon)
                            .clickable{onExit()},
                        contentAlignment = Alignment.Center
                    ) {

                        Icon(
                            painter = painterResource(R.drawable.icon_close), tint = Description,
                            contentDescription = null
                        )
                    }
                }

                SpacerH(20)

                Text("Описание", style = Typography().HeadlineMedium, color = Placeholder)
                SpacerH(8)
                Text(Text, style = Typography().TextRegular, color = Black)

                Column(Modifier.fillMaxSize(), verticalArrangement = Arrangement.Bottom) {
                    Text(
                        "Примерный расход:",
                        style = Typography().CaptionSemibold,
                        color = Placeholder
                    )
                    SpacerH(4)
                    Text(ApproximateСost, style = Typography().HeadlineMedium, color = Black)
                    SpacerH(19)
                    BigButton("Добавить за $textButton ₽", { onClick() }, state)
                    SpacerH(20)

                }
            }
        }
    }
}