package com.rakarguntara.mangasource.application

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import com.rakarguntara.mangasource.navigations.MangaNavigation
import com.rakarguntara.mangasource.ui.theme.MangasourceTheme
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            MangasourceTheme {
                MangaNavigation()
            }
        }
    }
}

