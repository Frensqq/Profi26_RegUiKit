package com.example.uikit.Components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.example.uikit.UI.Black

@Composable
fun Overlay(content: @Composable () -> Unit) {
    Box(Modifier.fillMaxSize().background(Black.copy(alpha = 0.6f)) ){
        content()
    }
}