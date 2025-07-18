package com.example.mainandroidfrontend.ui

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import com.example.mainandroidfrontend.R

// PUBLIC_INTERFACE
/**
 * ProfileImage composable for showing user's profile picture.
 * Uses default image when user photo is not set yet.
 *
 * @param modifier Modifier for sizing and styling this composable.
 */
@Composable
fun ProfileImage(
    modifier: Modifier = Modifier
) {
    Box(
        modifier = modifier
            .size(100.dp)
            .clip(CircleShape)
            .background(Color.White, CircleShape)
    ) {
        Image(
            painter = painterResource(id = R.drawable.profile_default),
            contentDescription = "Profile Picture",
            modifier = Modifier
                .clip(CircleShape)
                .background(MaterialTheme.colorScheme.surface, CircleShape)
        )
    }
}
