package com.rakarguntara.mangasource.screens.detail

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import com.rakarguntara.mangasource.components.LoadingIndicator
import com.rakarguntara.mangasource.viewmodels.detail.DetailViewModel
import com.rakarguntara.mangasource.widgets.details.anime.AnimeDetailContent
import com.rakarguntara.mangasource.widgets.details.manga.MangaDetailContent
import com.rakarguntara.mangasource.widgets.topbar.MangaTopBar

@Composable
fun DetailScreen(
    navController: NavController,
    type: String,
    id: String,
    detailViewModel: DetailViewModel = hiltViewModel()
) {
    Scaffold(modifier = Modifier.fillMaxSize(),
        topBar = {
            MangaTopBar(onBackIconClick = {
                navController.popBackStack()
            })}
    ) {
        Surface(
            modifier = Modifier
                .padding(it)
                .fillMaxSize(),
            color = Color.White) {
            if(type == "manga"){
                detailViewModel.getMangaDetail(id)
                val mangaDetailData = detailViewModel.mangaDetail.value
                if(mangaDetailData.loading == true){
                    LoadingIndicator(true)
                } else {
                    LoadingIndicator(false)
                    if(mangaDetailData.data != null){
                        MangaDetailContent(mangaDetailData.data!!)
                    }

                }
            } else {
                detailViewModel.getAnimeDetail(id)
                val animeDetailData = detailViewModel.animeDetail.value
                if(animeDetailData.loading == true){
                    LoadingIndicator(true)
                } else {
                    LoadingIndicator(false)
                    if(animeDetailData.data != null){
                        AnimeDetailContent(animeDetailData.data!!)
                    }
                }
            }
        }
    }

}