package com.rakarguntara.mangasource.screens.home

import android.util.Log
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
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
import com.rakarguntara.mangasource.components.DummyBannerIndicator
import com.rakarguntara.mangasource.viewmodels.home.HomeViewModel
import com.rakarguntara.mangasource.widgets.banner.BannerAnimeRecommendations
import com.rakarguntara.mangasource.widgets.banner.BannerRecommendations
import com.rakarguntara.mangasource.widgets.banner.BannerTops

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
                    .padding(16.dp)
                    .verticalScroll(rememberScrollState()),
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
                MangaTops(navController, homeViewModel)
                Box(modifier = Modifier.height(16.dp))
                AnimeRecommendations(navController, homeViewModel)
            }
        }
    }
}

@Composable
fun AnimeRecommendations(navController: NavController, homeViewModel: HomeViewModel) {
    Text("Anime Recommendations", style = TextStyle(
        color = Color.Black.copy(0.9f),
        fontWeight = FontWeight.Medium,
        fontSize = 14.sp
    ))
    Box(modifier = Modifier.height(8.dp))
    val animeRecommendationData = homeViewModel.animeRecommendation.value
    if(animeRecommendationData.loading == true){
        DummyBannerIndicator(true)
    } else {
        DummyBannerIndicator(false)
        val data = animeRecommendationData.data
        if(data != null){
            LazyRow(
                modifier = Modifier.fillMaxWidth()
            ) {
                items(items = data){anime ->
                    BannerAnimeRecommendations(anime)
                }
            }
        }

    }
}

@Composable
fun MangaTops(navController: NavController, homeViewModel: HomeViewModel){
    Text(
        stringResource(R.string.top_manga), style = TextStyle(
            color = Color.Black.copy(0.9f),
            fontSize = 14.sp,
            fontWeight = FontWeight.Medium
        ))
    Box(modifier = Modifier.height(8.dp))
    val mangaTops = homeViewModel.mangaTops.value
    if(mangaTops.loading == true){
        DummyBannerIndicator(true)
    } else {
        DummyBannerIndicator(false)
        val data = mangaTops.data
        if(data != null){
            LazyRow(
                modifier = Modifier.fillMaxWidth()
            ) {
                items(items = data){manga ->
                    BannerTops(manga)
                }
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
        DummyBannerIndicator(true)
    } else {
        DummyBannerIndicator(false)
        val data = mangaRecommendationData.data
        if(data != null){
            LazyRow(modifier = Modifier.fillMaxWidth()) {
                items(items = data){manga ->
                    BannerRecommendations(manga)
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