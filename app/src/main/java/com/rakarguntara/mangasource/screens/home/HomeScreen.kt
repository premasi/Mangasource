package com.rakarguntara.mangasource.screens.home

import android.util.Log
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import com.rakarguntara.mangasource.R
import com.rakarguntara.mangasource.components.LoadingIndicator
import com.rakarguntara.mangasource.viewmodels.home.HomeViewModel
import com.rakarguntara.mangasource.widgets.banner.Banner

@Composable
fun HomeScreen(navController: NavController, homeViewModel: HomeViewModel = hiltViewModel()) {
    Scaffold { innerPadding ->
        Surface(
            modifier = Modifier.padding(innerPadding)
                .fillMaxSize(),
            color = Color.White
        ) {
            Column(
                modifier = Modifier.fillMaxWidth()
                    .padding(16.dp),
                verticalArrangement = Arrangement.Top,
                horizontalAlignment = Alignment.Start
            ){
                Text(
                    buildAnnotatedString {
                        withStyle(
                            style = SpanStyle(
                                color = Color.Black,
                                fontSize = 16.sp,
                                fontWeight = FontWeight.Bold,
                            )
                        ){
                            append(stringResource(R.string.welcome_back))
                        }
                        append(stringResource(R.string.blank_space))
                        withStyle(
                            style = SpanStyle(
                                color = colorResource(R.color.teal),
                                fontSize = 16.sp,
                                fontWeight = FontWeight.Bold
                            )
                        ){
                            append(stringResource(R.string.mangasource))
                        }
                    },
                )
                Box(modifier = Modifier.height(16.dp))
                MangaRecommendations(navController, homeViewModel)
                Box(modifier = Modifier.height(16.dp))
                Text(
                    stringResource(R.string.top_manga), style = TextStyle(
                    color = Color.Black.copy(0.9f),
                    fontSize = 14.sp,
                    fontWeight = FontWeight.Medium
                ))

            }
        }
    }
}

@Composable
fun MangaRecommendations(navController: NavController, homeViewModel: HomeViewModel){
    Text(stringResource(R.string.manga_recommendations), style = TextStyle(
        color = Color.Black.copy(0.9f),
        fontSize = 14.sp,
        fontWeight = FontWeight.Medium
    ))
    Box(modifier = Modifier.height(8.dp))
    val mangaRecommendationData = homeViewModel.mangaRecommendation.value
    if(mangaRecommendationData.loading == true){
        LoadingIndicator(true)
    } else {
        LoadingIndicator(false)
        val data = mangaRecommendationData.data
        if(data != null){
            LazyRow(modifier = Modifier.fillMaxWidth()) {
                items(items = data){manga ->
                    Banner(manga)
                }
            }
            Log.d("MANGA RECOMMENDATIONS DATA", "getMangaRecommendations: $mangaRecommendationData")
        } else {
            mangaRecommendationData.e?.let {
                Log.d("MANGA RECOMMENDATIONS ERROR", "Error occurred: ${it.message}")
            }
        }

    }
}