package com.rakarguntara.mangasource.viewmodels.home

import android.util.Log
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
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

    init {
        getMangaRecommendations(1)
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

}