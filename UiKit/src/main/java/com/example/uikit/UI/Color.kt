package com.example.uikit.UI

import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.OutlinedTextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color


val Accent = Color(0xff00C07F)
val AccentInactive = Color(0xff63D4B0)
val Black = Color(0xff000000)
val White = Color(0xffffffff)
val Error = Color(0xffFD3535)
val Success = Color(0xff00B712)
val InputBg = Color(0xffF5F5F9)
val InputStr = Color(0xffEBEBEB)
val InputIcon = Color(0xffB8C1CC)
val Placeholder = Color(0xff939396)
val Description = Color(0xff7E7E9A)
val CardStr = Color(0xffF4F4F4)

val greenGradient = Brush.linearGradient(
    colors = listOf(Color(0xff75D8BC), Color(0xff5BADCB))
)

val blueGradient = Brush.linearGradient(
    colors = listOf(Color(0xffB4D5FF), Color(0xff60A6FD))
)

@Composable
fun colorButton() = ButtonDefaults.buttonColors(
    containerColor = Accent,
    disabledContainerColor = AccentInactive,
    contentColor = White,
    disabledContentColor = White
)

@Composable
fun colorButtonType2() = ButtonDefaults.buttonColors(
    containerColor = White,
    disabledContainerColor = White,
    contentColor = Accent,
    disabledContentColor = AccentInactive
)

@Composable
fun colorButtonType3() = ButtonDefaults.buttonColors(
    containerColor = InputBg,
    disabledContainerColor = InputBg,
    contentColor = Description,
    disabledContentColor = Description
)

@Composable
fun colorInput() = OutlinedTextFieldDefaults.colors(
    cursorColor = Accent,
    focusedBorderColor = Accent,
    errorContainerColor = Color(0x19FD3535),
    unfocusedTextColor = Black,
    unfocusedPlaceholderColor = Placeholder,
    unfocusedContainerColor = InputBg,
    focusedTextColor = Black,
    unfocusedBorderColor = InputStr,
    focusedPlaceholderColor = Placeholder,
    focusedContainerColor = InputBg,
    errorCursorColor = Accent,
    errorBorderColor = Accent
)