package com.example.mainandroidfrontend.ui

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.Alignment
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.draw.drawWithContent
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color

// PUBLIC_INTERFACE
/** * Composable that sets the gym background image for app screens.
 * Displays a semi-transparent overlay for readability of content.
 *
 * Note: Image must reside in 'res/drawable' and reference in code omits extension.
 * If the image resource is missing in the app, use a fallback solid background color.
 */
@Composable
fun AppBackground(modifier: Modifier = Modifier, content: @Composable () -> Unit) {
    Box(
        modifier = modifier
            .fillMaxSize()
    ) {
        // Reference the gymbackground image; if missing, Android Studio build will fail so fallback is for dev safety.
        // Android Compose cannot handle missing static resources at runtime.
        // If drawable is missing, the build itself will fail—so runtime fallback for resource resolution is impossible.
        // If decoding fails (rare for PNG, but possible for corrupt files), user will see a blank image. 
        // For development, always ensure gymbackground.png is present and valid in drawable!

        Image(
            painter = painterResource(
                id = com.example.mainandroidfrontend.R.drawable.gymbackground
            ),
            contentDescription = "Gym background",
            modifier = Modifier
                .fillMaxSize(),
            contentScale = ContentScale.Crop
        )
        // Semi-transparent dark overlay for readability
        Box(
            modifier = Modifier
                .fillMaxSize()
                .drawWithContent {
                    drawContent()
                    drawRect(
                        Brush.verticalGradient(
                            colors = listOf(
                                Color(0xDD222222),
                                Color(0x99222222),
                                Color(0x88000000)
                            )
                        )
                    )
                }
        )
        Box(
            modifier = Modifier.fillMaxSize(),
            contentAlignment = Alignment.Center
        ) {
            content()
        }
    }
}
