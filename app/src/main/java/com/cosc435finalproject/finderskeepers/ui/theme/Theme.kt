package com.cosc435finalproject.finderskeepers.ui.theme

import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.material.darkColors
import androidx.compose.material.lightColors
import androidx.compose.material.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.material.Typography
import androidx.compose.ui.graphics.Color

private val DarkColorPalette = darkColors(
    primary = Red,
    primaryVariant = Purple700,
    secondary = Teal200,
    surface = graySurface
)

private val LightColorPalette = lightColors(
    primary = Red,
    primaryVariant = Purple700,
    secondary = Teal200
)

@Composable
fun FindersKeepersTheme(darkTheme: Boolean = true, content: @Composable() ()-> Unit){
    val colors = if (darkTheme){
        DarkColorPalette
    } else {
        LightColorPalette
    }

    MaterialTheme(
        colors = colors,
        typography = typography,
        shapes = shapes,
        content = content
    )
}
