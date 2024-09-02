package com.rakarguntara.mangasource.screens.detail

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.navigation.NavController
import com.rakarguntara.mangasource.widgets.topbar.MangaTopBar

@Composable
fun DetailScreen(navController: NavController, type: String, id: String) {
    Scaffold(modifier = Modifier.fillMaxSize(),
        topBar = {
            MangaTopBar(onBackIconClick = {
                navController.popBackStack()
            })}
    ) {
        Column(modifier = Modifier.padding(it).fillMaxSize()) {
            Text(type, color = Color.Black)
            Text(id, color = Color.Black)
        }
    }

}