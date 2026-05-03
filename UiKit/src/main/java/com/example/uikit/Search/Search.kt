package com.example.uikit.Search

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Icon
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.focus.FocusState
import androidx.compose.ui.focus.onFocusChanged
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.uikit.R
import com.example.uikit.UI.Black
import com.example.uikit.UI.Description
import com.example.uikit.UI.Typography
import com.example.uikit.UI.colorInput

@Composable
fun Search(
    value: String,
    onChangeValue:(String) ->Unit,
    placeholder: String

){
    var focus by remember { mutableStateOf(false) }

    OutlinedTextField(
        value = value,
        onValueChange = {onChangeValue(it)},
        modifier = Modifier.fillMaxWidth().height(48.dp)
            .onFocusChanged{focusState -> focus = focusState.isFocused},
        shape = RoundedCornerShape(10.dp),

        trailingIcon = {
            if (focus){Icon(
                painter = painterResource(R.drawable.icon_close),
                contentDescription = null, tint = Description,
                modifier = Modifier.clickable{onChangeValue("")}
            )}
        },
        leadingIcon = {
            Icon(
                painter = painterResource(R.drawable.icon_search),
                contentDescription = null, tint = Description,
                modifier = Modifier.clickable{onChangeValue("")}
            )
        },
        colors = colorInput(),
        placeholder = { Text(placeholder, style = Typography().TextRegular, color = Color(0xff939396)) },
        textStyle = Typography().TextRegular)
}

@Preview
@Composable
fun PreviewSearch(){

    Column() {
        Search("sdsd",{}, "true")

    }

}