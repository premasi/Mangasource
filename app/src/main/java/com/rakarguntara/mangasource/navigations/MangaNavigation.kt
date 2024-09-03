package com.rakarguntara.mangasource.navigations

import androidx.compose.runtime.Composable
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.rakarguntara.mangasource.screens.detail.DetailScreen
import com.rakarguntara.mangasource.screens.main.MainScreen
import com.rakarguntara.mangasource.screens.splash.SplashScreen
import com.rakarguntara.mangasource.viewmodels.detail.DetailViewModel

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

        composable("${NavigationScreens.DetailScreen.name}/{type}/{id}", arguments =
            listOf(
                navArgument("type"){
                    type = NavType.StringType
                },
                navArgument("id"){
                    type = NavType.StringType
                }
            )
        ){ backStackEntry ->
            val type = backStackEntry.arguments?.getString("type") ?: ""
            val id = backStackEntry.arguments?.getString("id") ?: ""
            val detailViewModel = hiltViewModel<DetailViewModel>()

            DetailScreen(navController = navController, type = type, id = id, detailViewModel)
        }
    }
}