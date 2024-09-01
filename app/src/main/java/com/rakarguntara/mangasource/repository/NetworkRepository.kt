package com.rakarguntara.mangasource.repository

import com.rakarguntara.mangasource.models.MangaTopResponseItem
import com.rakarguntara.mangasource.models.RecommendationsItem
import com.rakarguntara.mangasource.network.ApiService
import com.rakarguntara.mangasource.network.ResponseState
import javax.inject.Inject

class NetworkRepository @Inject constructor(private val apiService: ApiService) {
    suspend fun getMangaRecommendations(number: Int = 1) : ResponseState<List<RecommendationsItem>, Boolean, Exception>{
        val response = try {
            apiService.getMangaRecomenndations(number = number).recommendations
        } catch (e: Exception){
            return ResponseState(e = e)
        }
        return ResponseState(data = response)
    }

    suspend fun getMangaTops(category: String = "category", number: Int = 1): ResponseState<List<MangaTopResponseItem>, Boolean, Exception>{
        val response = try {
            apiService.getMangaTops(category = category, number = number)
        } catch (e: Exception){
            return ResponseState(e = e)
        }
        return ResponseState(data = response)
    }
}