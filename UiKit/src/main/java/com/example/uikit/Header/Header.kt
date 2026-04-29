package com.example.uikit.Header

import android.widget.Button
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.uikit.Button.Bubble.ButtonBack
import com.example.uikit.R
import com.example.uikit.UI.Black
import com.example.uikit.UI.InputIcon
import com.example.uikit.UI.Typography

@Composable
fun Header(
    onExit: () -> Unit,
    onDelete: () -> Unit,
){
    Column(modifier = Modifier.height(84.dp),
        verticalArrangement = Arrangement.SpaceBetween) {
        ButtonBack { onExit() }

        Row(modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceBetween) {

            Text("Корзина", style = Typography().Title1Heavy, color = Black)

            Icon(painter = painterResource(R.drawable.icon_plus),
                modifier = Modifier
                    .padding(4.dp)
                    .clickable{onDelete()},
                tint = InputIcon,
                contentDescription = null)
        }

    }

}

@Preview
@Composable
fun PreviewHeader(){
    Header({},{})
}