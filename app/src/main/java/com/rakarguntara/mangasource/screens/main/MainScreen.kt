package com.rakarguntara.mangasource.screens.main

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.rakarguntara.mangasource.navigations.MangaBottomNavigation
import com.rakarguntara.mangasource.widgets.bottomnavigation.MangaBottomNavigationBar

@Composable
fun MainScreen(navController: NavController) {
    val bottomNavController = rememberNavController()
    Scaffold(
        modifier = Modifier.fillMaxSize(),
        bottomBar = {
            MangaBottomNavigationBar(bottomNavController)
        }
    ) {
        MangaBottomNavigation(bottomNavController)
    }
}