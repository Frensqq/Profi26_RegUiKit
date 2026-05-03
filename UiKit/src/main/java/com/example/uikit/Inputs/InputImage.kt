package com.example.uikit.Inputs

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.heightIn
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.uikit.R
import com.example.uikit.UI.Black
import com.example.uikit.UI.Description
import com.example.uikit.UI.InputBg
import com.example.uikit.UI.InputStr
import com.example.uikit.UI.Typography

@Composable
fun InputsImage(onClick: () -> Unit, painter: Painter?, title: String, state: Boolean) {

    Column(verticalArrangement = Arrangement. spacedBy(8.dp)
    ){
        if (!title.isNullOrEmpty()){
            Text(text= title, style = Typography().CaptionRegular, color = Description)
        }

        Box(
            modifier = Modifier.fillMaxWidth().heightIn(max = 172.dp)
                .clip(RoundedCornerShape(10.dp)).background(InputBg)
                .border(BorderStroke(1.dp, InputStr))
        ) {

            if (!state) {
                Row(
                    modifier = Modifier.fillMaxWidth().height(48.dp).padding(14.dp),
                    horizontalArrangement = Arrangement.SpaceBetween
                ) {


                    Text("Загрузить", style = Typography().HeadlineRegular, color = Black)

                    Icon(
                        painter = painterResource(R.drawable.icon_plus),
                        contentDescription = null, tint = Description,
                        modifier = Modifier.clickable { onClick() }
                    )

                }
            } else {
                Box(
                    Modifier.fillMaxSize()
                        .padding(start = 5.dp, end = 6.dp, bottom = 18.dp, top = 22.dp)
                ) {

                    Image(
                        painter = painter ?: painterResource(R.drawable.stock),
                        contentDescription = "Selected image",
                        modifier = Modifier.fillMaxSize(),
                        contentScale = ContentScale.FillBounds
                    )

                }

            }

        }
    }
}

@Preview
@Composable
fun PreviewInputsImage(){

    Column() {
        InputsImage({}, null,"test" , true)

    }

}