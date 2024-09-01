package com.rakarguntara.mangasource.widgets.bottomnavigation

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AccountCircle
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Search
import androidx.compose.material3.Icon
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.NavigationBarItemDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.stringResource
import androidx.navigation.NavController
import androidx.navigation.compose.currentBackStackEntryAsState
import com.rakarguntara.mangasource.R
import com.rakarguntara.mangasource.navigations.BottomNavigationsScreens

@Composable
fun MangaBottomNavigationBar(navController: NavController) {
    NavigationBar(
        containerColor = colorResource(R.color.teal),
        contentColor = Color.White) {
        val currentRoute = navController.currentBackStackEntryAsState().value?.destination?.route

        NavigationBarItem(
            label = { Text(stringResource(R.string.home)) },
            icon = { Icon(imageVector = Icons.Default.Home, contentDescription = stringResource(R.string.home)) },
            onClick = {
                if(currentRoute != BottomNavigationsScreens.HomeScreen.name){
                    navController.navigate(BottomNavigationsScreens.HomeScreen.name){
                        popUpTo(navController.graph.startDestinationId){
                            saveState = true
                        }
                        restoreState = true
                        launchSingleTop = true
                    }
                }
            },
            selected = currentRoute == BottomNavigationsScreens.HomeScreen.name,
            colors = NavigationBarItemDefaults.colors(
                selectedIconColor = Color.White,
                selectedTextColor = Color.White,
                unselectedIconColor = Color.Black,
                unselectedTextColor = Color.Black,
                indicatorColor = colorResource(R.color.teal_700),
            )
        )

        NavigationBarItem(
            label = { Text(stringResource(R.string.search)) },
            icon = { Icon(Icons.Default.Search, contentDescription = stringResource(R.string.search)) },
            onClick = {
                if(currentRoute != BottomNavigationsScreens.SearchScreen.name){
                    navController.navigate(BottomNavigationsScreens.SearchScreen.name){
                        popUpTo(navController.graph.startDestinationId){
                            saveState = true
                        }
                        restoreState = true
                        launchSingleTop = true
                    }
                }
            },
            selected = currentRoute == BottomNavigationsScreens.SearchScreen.name,
            colors = NavigationBarItemDefaults.colors(
                selectedIconColor = Color.White,
                selectedTextColor = Color.White,
                unselectedIconColor = Color.Black,
                unselectedTextColor = Color.Black,
                indicatorColor = colorResource(R.color.teal_700)
            )
        )

        NavigationBarItem(
            label = { Text(stringResource(R.string.profile)) },
            icon = { Icon(Icons.Default.AccountCircle, contentDescription = stringResource(R.string.profile)) },
            onClick = {
                if(currentRoute != BottomNavigationsScreens.ProfileScreen.name){
                    navController.navigate(BottomNavigationsScreens.ProfileScreen.name){
                        popUpTo(navController.graph.startDestinationId){
                            saveState = true
                        }
                        restoreState = true
                        launchSingleTop = true
                    }
                }
            },
            selected = currentRoute == BottomNavigationsScreens.ProfileScreen.name,
            colors = NavigationBarItemDefaults.colors(
                selectedIconColor = Color.White,
                selectedTextColor = Color.White,
                unselectedIconColor = Color.Black,
                unselectedTextColor = Color.Black,
                indicatorColor = colorResource(R.color.teal_700)
            )
        )
    }
}