package com.rakarguntara.mangasource.viewmodels.home

import android.util.Log
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.rakarguntara.mangasource.models.AnimeRecommendationsItem
import com.rakarguntara.mangasource.models.MangaTopResponseItem
import com.rakarguntara.mangasource.models.RecommendationsItem
import com.rakarguntara.mangasource.network.ResponseState
import com.rakarguntara.mangasource.repository.NetworkRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class HomeViewModel @Inject constructor(private val networkRepository: NetworkRepository): ViewModel() {
    private val _mangaRecommendations: MutableState<ResponseState<List<RecommendationsItem>, Boolean, Exception>> =
        mutableStateOf(ResponseState<List<RecommendationsItem>, Boolean, Exception>())
    val mangaRecommendation get() = _mangaRecommendations

    private val _mangaTops : MutableState<ResponseState<List<MangaTopResponseItem>, Boolean, Exception>> =
        mutableStateOf(ResponseState<List<MangaTopResponseItem>, Boolean, Exception>())
    val mangaTops get() = _mangaTops

    private val _animeRecommendations : MutableState<ResponseState<List<AnimeRecommendationsItem>, Boolean, Exception>> =
        mutableStateOf(ResponseState<List<AnimeRecommendationsItem>, Boolean, Exception>())
    val animeRecommendation get() = _animeRecommendations

    init {
        getMangaRecommendations(1)
        getMangaTops("category", 1)
        getAnimeRecommendations(1)
    }

    private fun getMangaRecommendations(number: Int) {
        viewModelScope.launch {
            if(number != 1) return@launch
            _mangaRecommendations.value = ResponseState(loading = true)
            val response = networkRepository.getMangaRecommendations(number)
            response.data.let { manga ->
                if(manga != null){
                    _mangaRecommendations.value = ResponseState(data = manga, loading = false)
                    Log.d("MANGA RECOMMENDATIONS", "getMangaRecommendations: $manga")
                } else {
                    response.e.let { e->
                        _mangaRecommendations.value = ResponseState(e = e)
                        Log.d("MANGA RECOMMENDATIONS ERROR", "getMangaRecommendations: $e")
                    }

                }

            }
        }
    }

    private fun getMangaTops(category: String, number: Int){
        viewModelScope.launch {
            if(category.isEmpty() && number != 1) return@launch
            _mangaTops.value = ResponseState(loading = true)
            val response = networkRepository.getMangaTops(category, number)
            response.data.let { manga ->
                if(manga != null){
                    _mangaTops.value = ResponseState(data = manga, loading = false)
                    Log.d("MANGA TOPS", "getMangaTops: $manga")
                } else {
                    response.e.let { e->
                        _mangaTops.value = ResponseState(e = e)
                        Log.d("MANGA TOPS ERROR", "getMangaTops: $e")
                    }
                }

            }
        }
    }

    private fun getAnimeRecommendations(number: Int){
        viewModelScope.launch {
            if(number != 1) return@launch
            _animeRecommendations.value = ResponseState(loading = true)
            val response = networkRepository.getAnimeRecommendations(number)
            response.data.let { manga ->
                if(manga != null){
                    _animeRecommendations.value = ResponseState(data = manga, loading = false)
                    Log.d("ANIME RECOMMENDATIONS", "getAnimeRecommendations: $manga")
                } else {
                    response.e.let { e->
                        _animeRecommendations.value = ResponseState(e = e)
                        Log.d("ANIME RECOMMENDATIONS ERROR", "getAnimeRecommendations: $e")
                    }
                }
            }
        }
    }

}