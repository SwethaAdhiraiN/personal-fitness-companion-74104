package com.example.mainandroidfrontend.ui.theme

import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.material3.*
import androidx.compose.runtime.Composable

private val LightColorScheme = lightColorScheme(
    primary = BluePrimary,
    onPrimary = OnPrimary,
    secondary = GreenSecondary,
    onSecondary = OnSecondary,
    tertiary = AmberAccent,
    background = BackgroundLight,
    surface = SurfaceWhite,
    onBackground = OnBackground,
    onSurface = OnSurface,
    error = Error,
    onError = OnError,
)

@Composable
fun PersonalFitnessTheme(content: @Composable () -> Unit) {
    MaterialTheme(
        colorScheme = LightColorScheme,
        typography = Typography,
        content = content
    )
}
