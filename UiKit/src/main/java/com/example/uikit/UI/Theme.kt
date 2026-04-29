package com.example.uikit.UI

import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Typography
import androidx.compose.material3.lightColorScheme
import androidx.compose.runtime.Composable

@Composable
fun MatuleTheme(
    content: @Composable () -> Unit
) {
    val colorScheme = lightColorScheme(
        primary = Accent,
        primaryContainer = AccentInactive,
        secondary = AccentInactive,
        secondaryContainer = InputBg,
        tertiary = Description,
        background = White,
        surface = White,
        surfaceVariant = InputBg,
        error = Error,
        onPrimary = White,
        onSecondary = White,
        onTertiary = Black,
        onBackground = Black,
        onSurface = Black,
        onSurfaceVariant = Description,
        onError = White
    )

    MaterialTheme(
        colorScheme = colorScheme,
        typography = Typography(),
        content = content
    )
}
