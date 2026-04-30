package com.example.uikit.Button

import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.example.uikit.UI.Description
import com.example.uikit.UI.Typography
import com.example.uikit.UI.White
import com.example.uikit.UI.colorButton
import com.example.uikit.UI.colorButtonType2
import com.example.uikit.UI.colorButtonType3

@Composable
fun Chips(
    text: String,
    onClick: () -> Unit,
    state: Boolean
){

    Button(
        onClick = onClick,
        modifier = Modifier
            .height(48.dp),
        contentPadding = PaddingValues(horizontal = 20.dp, vertical = 14.dp),
        colors = if (state) colorButton() else colorButtonType3(),
        shape = RoundedCornerShape(10.dp)
    ) {
        Text(
            text = text,
            style =  Typography().TextMedium,
            color = if (state) White else Description
        )
    }
}
