package com.rakarguntara.mangasource.widgets.banner

import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp

@Composable
fun DummyBanner() {
    Surface(
        modifier = Modifier
            .width(100.dp)
            .height(150.dp)
            .padding(end = 8.dp)
            .shadow(10.dp, shape = RoundedCornerShape(20.dp))
            .clip(RoundedCornerShape(20.dp)),
        color = Color.Gray,
    ){
        // You can add other placeholder UI elements here if needed
    }
}