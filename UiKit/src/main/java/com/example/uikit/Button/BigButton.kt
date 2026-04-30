package com.example.uikit.Button

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.uikit.Button.Bubble.ButtonBack
import com.example.uikit.Controls.Counter
import com.example.uikit.Controls.Toggle
import com.example.uikit.UI.Typography
import com.example.uikit.UI.colorButton
import org.w3c.dom.Text

@Composable
fun BigButton(
    text: String,
    onClick: () -> Unit,
    state: Boolean = true
){

   Button(
       onClick,
       modifier = Modifier.fillMaxWidth()
           .height(56.dp),
       enabled = state,
       colors = colorButton(),
       shape = RoundedCornerShape(10.dp)
   ) {
       Text(
           text = text,
           style =  Typography().Title3Semibold
           )
   }
}

@Preview
@Composable
fun TestButton(){
    Column(verticalArrangement = Arrangement.spacedBy(5.dp)) {
        BigButton("Подтвердить", {}, false)
        SmallButton("Убрать", {}, false)
        SmallButton("Добавить", {}, true)
        //Chips("Популярные", {}, true)
        //Chips("Популярные", {}, false)

        CardButton("100", {})
        ButtonBack({})

        var state by remember{ mutableStateOf(false) }

        Toggle({state = it}, state)
        Counter(1, {})
        Counter(2, {})
    }
}