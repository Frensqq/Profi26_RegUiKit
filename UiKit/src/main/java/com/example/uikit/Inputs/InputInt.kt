package com.example.uikit.Inputs

import com.example.uikit.UI.colorInput


import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.OutlinedTextField
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.focus.FocusRequester
import androidx.compose.ui.focus.focusRequester
import androidx.compose.ui.platform.LocalSoftwareKeyboardController
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.uikit.UI.Typography
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

@Composable
fun InputInt(
    value: String,
    onChangeValue: (String) -> Unit,
    focusRequester: FocusRequester,
    index: Int,
    focuses: List<FocusRequester>
) {
    val scope = rememberCoroutineScope()
    OutlinedTextField(
        value = value,
        onValueChange = { newValue ->
            if (newValue.length <= 1 && newValue.matches(Regex("\\d*"))) {
                val oldValue = value
                onChangeValue(newValue)
                scope.launch {
                    when {
                        newValue.isNotEmpty() && oldValue.isEmpty() && index < focuses.lastIndex -> {
                            focuses[index + 1].requestFocus()
                        }
                        newValue.isEmpty() && oldValue.isNotEmpty() && index > 0 -> {
                            focuses[index - 1].requestFocus()
                        }
                    }
                }
            }
        },
        colors = colorInput(),
        modifier = Modifier
            .size(48.dp)
            .focusRequester(focusRequester),
        shape = RoundedCornerShape(10.dp),
        textStyle = Typography().TextRegular,
        keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number)
    )
}

@Preview
@Composable
fun PreviewInputInt() {
    val count = 4
    var values by remember { mutableStateOf(List(count) { "" }) }
    val focuses = remember { List(count) { FocusRequester() } }

    Row {
        values.forEachIndexed { index, value ->
            InputInt(
                value = value,
                onChangeValue = { newValue ->
                    values = values.toMutableList().apply {
                        this[index] = newValue
                    }
                },
                focusRequester = focuses[index],
                index = index,
                focuses = focuses
            )
        }
    }
}