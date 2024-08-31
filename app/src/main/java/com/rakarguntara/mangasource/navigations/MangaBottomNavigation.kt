package com.rakarguntara.mangasource.navigations

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.rakarguntara.mangasource.screens.home.HomeScreen
import com.rakarguntara.mangasource.screens.profile.ProfileScreen
import com.rakarguntara.mangasource.screens.search.SearchScreen

@Composable
fun MangaBottomNavigation(bottomNavController: NavHostController) {
    NavHost(bottomNavController, startDestination = BottomNavigationsScreens.HomeScreen.name){
        composable(BottomNavigationsScreens.HomeScreen.name){
            HomeScreen(bottomNavController)
        }

        composable(BottomNavigationsScreens.SearchScreen.name){
            SearchScreen(bottomNavController)
        }

        composable(BottomNavigationsScreens.ProfileScreen.name){
            ProfileScreen(bottomNavController)
        }
    }
}