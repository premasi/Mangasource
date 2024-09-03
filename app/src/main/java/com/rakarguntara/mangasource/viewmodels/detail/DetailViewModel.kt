package com.rakarguntara.mangasource.viewmodels.detail

import android.util.Log
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.rakarguntara.mangasource.models.AnimeDetailResponse
import com.rakarguntara.mangasource.models.MangaDetailResponse
import com.rakarguntara.mangasource.network.ResponseState
import com.rakarguntara.mangasource.repository.NetworkRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class DetailViewModel @Inject constructor(private val networkRepository: NetworkRepository): ViewModel() {
    private val _mangaDetail: MutableState<ResponseState<MangaDetailResponse, Boolean, Exception>> =
        mutableStateOf(ResponseState<MangaDetailResponse, Boolean, Exception>())
    val mangaDetail get() = _mangaDetail

    private val _animeDetail : MutableState<ResponseState<AnimeDetailResponse, Boolean, Exception>> =
        mutableStateOf(ResponseState<AnimeDetailResponse, Boolean, Exception>())
    val animeDetail get() = _animeDetail


    fun getMangaDetail(id: String){
        viewModelScope.launch {
            if(id.isEmpty()) return@launch
            _mangaDetail.value = ResponseState(loading = true)
            val response = networkRepository.getMangaDetail(id)
            response.data.let { manga ->
                if(manga != null){
                    _mangaDetail.value = ResponseState(data = manga, loading = false)
                    Log.d("MANGA DETAIL", "getMangaDetail: $manga")
                } else {
                    response.e.let { e ->
                        _mangaDetail.value = ResponseState(e = e)
                        Log.d("MANGA DETAIL ERROR", "getMangaDetail: $e")
                    }
                }
            }
        }
    }

    fun getAnimeDetail(id: String){
        viewModelScope.launch {
            if(id.isEmpty()) return@launch
            _animeDetail.value = ResponseState(loading = true)
            val response = networkRepository.getAnimeDetail(id)
            response.data.let { anime ->
                if(anime != null){
                    _animeDetail.value = ResponseState(data = anime, loading = false)
                    Log.d("ANIME DETAIL", "getAnimeDetail: $anime")
                } else {
                    response.e.let { e ->
                        _animeDetail.value = ResponseState(e = e)
                        Log.d("ANIME DETAIL ERROR", "getAnimeDetail: $e")
                    }
                }
            }
        }
    }
}