package com.rakarguntara.mangasource.navigations

import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.rakarguntara.mangasource.screens.main.MainScreen
import com.rakarguntara.mangasource.screens.splash.SplashScreen

@Composable
fun MangaNavigation() {
    val navController = rememberNavController()
    NavHost(navController = navController, startDestination = NavigationScreens.SplashScreen.name){
        composable(NavigationScreens.SplashScreen.name){
            SplashScreen(navController = navController)
        }

        composable(NavigationScreens.MainScreen.name){
            MainScreen(navController = navController)
        }
    }
}