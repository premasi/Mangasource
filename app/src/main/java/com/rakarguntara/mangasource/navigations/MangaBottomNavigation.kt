package com.rakarguntara.mangasource.navigations

import androidx.compose.runtime.Composable
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.rakarguntara.mangasource.screens.home.HomeScreen
import com.rakarguntara.mangasource.screens.profile.ProfileScreen
import com.rakarguntara.mangasource.screens.search.SearchScreen
import com.rakarguntara.mangasource.viewmodels.home.HomeViewModel

@Composable
fun MangaBottomNavigation(bottomNavController: NavHostController) {
    NavHost(bottomNavController, startDestination = BottomNavigationsScreens.HomeScreen.name){
        composable(BottomNavigationsScreens.HomeScreen.name){
            val homeViewModel = hiltViewModel<HomeViewModel>()
            HomeScreen(bottomNavController, homeViewModel)
        }

        composable(BottomNavigationsScreens.SearchScreen.name){
            SearchScreen(bottomNavController)
        }

        composable(BottomNavigationsScreens.ProfileScreen.name){
            ProfileScreen(bottomNavController)
        }
    }
}