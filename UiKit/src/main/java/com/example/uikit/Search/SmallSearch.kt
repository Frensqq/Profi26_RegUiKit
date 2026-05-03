package com.example.uikit.Search

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Icon
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.focus.onFocusChanged
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.uikit.R
import com.example.uikit.UI.Accent
import com.example.uikit.UI.Description
import com.example.uikit.UI.Typography
import com.example.uikit.UI.colorInput

@Composable
fun SmallSearch(
    value: String,
    onChangeValue:(String) ->Unit,
    placeholder: String,
    onClick:() -> Unit

){

    var focus by remember { mutableStateOf(false) }

    Row(modifier = Modifier.fillMaxWidth(),
        horizontalArrangement = Arrangement.SpaceBetween,
        verticalAlignment = Alignment.CenterVertically
    ) {

        OutlinedTextField(
            value = value,
            onValueChange = { onChangeValue(it) },
            modifier = Modifier.fillMaxWidth(0.75f).height(48.dp)
                .onFocusChanged { focusState -> focus = focusState.isFocused },
            shape = RoundedCornerShape(10.dp),

            trailingIcon = {
                if (focus) {
                    Icon(
                        painter = painterResource(R.drawable.icon_close),
                        contentDescription = null, tint = Description,
                        modifier = Modifier.clickable { onChangeValue("") }
                    )
                }
            },
            leadingIcon = {
                Icon(
                    painter = painterResource(R.drawable.icon_search),
                    contentDescription = null, tint = Description,
                    modifier = Modifier.clickable { onChangeValue("") }
                )
            },
            colors = colorInput(),
            placeholder = {
                Text(
                    placeholder,
                    style = Typography().TextRegular,
                    color = Color(0xff939396)
                )
            },
            textStyle = Typography().TextRegular
        )

        Text("Отменить",
            style = Typography().CaptionRegular,
            color = Accent,
            modifier = Modifier.clickable{onChangeValue("")})

    }
}

@Preview
@Composable
fun PreviewSmallSearch(){

    var value by remember { mutableStateOf("") }

    Column() {
        SmallSearch(value,{value = it}, "true", {})

    }

}