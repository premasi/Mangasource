package com.rakarguntara.mangasource.components

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.rakarguntara.mangasource.widgets.banner.DummyBanner

@Composable
fun DummyBannerIndicator(status: Boolean = false) {
    if(status){
        LazyRow(modifier = Modifier.fillMaxWidth()) {
            items(5) {
                DummyBanner()
            }
        }
    }
}