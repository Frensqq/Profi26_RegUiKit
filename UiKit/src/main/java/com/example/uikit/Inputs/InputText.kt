package com.example.uikit.Inputs

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
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
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.uikit.R
import com.example.uikit.UI.Black
import com.example.uikit.UI.Description
import com.example.uikit.UI.Error
import com.example.uikit.UI.Typography
import com.example.uikit.UI.colorInput

@Composable
fun TextInput(text: String, placeholder: String, isPass: Boolean,onChange:(String)->Unit, title: String?, error: String? ){
    Column(
        verticalArrangement = Arrangement. spacedBy(8.dp)
    ){
        var passView by remember { mutableStateOf(false) }

        if (!title.isNullOrEmpty()){
            Text(text= title, style = Typography().CaptionRegular, color = Description)
        }

        OutlinedTextField(
            value = text,
            onValueChange = {onChange(it)},
            placeholder = {
                Text(
                    text = placeholder,
                    style = Typography().TextRegular,
                    color = Color(0xff939396))
            },
            colors = colorInput(),
            modifier = Modifier
                .fillMaxWidth()
                .height(48.dp)
                .clip(RoundedCornerShape(10.dp)),
            singleLine = true,
            textStyle = Typography().TextRegular,
            isError = !error.isNullOrEmpty(),
            trailingIcon = {
                if (isPass){Icon(
                    painter = painterResource(if (!passView) R.drawable.icon_eyeopen else R.drawable.icon_eyeclose),
                    contentDescription = null, tint = Black,
                    modifier = Modifier.clickable{passView = !passView}
                )}
            },
            visualTransformation = if (passView && isPass){
                PasswordVisualTransformation()
            }else VisualTransformation.None,
            shape = RoundedCornerShape(10.dp),

        )

        if (!error.isNullOrEmpty()){
            Text(text= error, style = Typography().CaptionRegular, color = Error)
        }
    }
}

@Preview
@Composable
fun PreviewInputText(){

    Column() {
        TextInput("","test", true, {}, null, null )

        TextInput("","test", false, {}, "test", "error" )
    }

}