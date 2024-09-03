package com.rakarguntara.mangasource.repository

import com.rakarguntara.mangasource.models.AnimeDetailResponse
import com.rakarguntara.mangasource.models.AnimeRecommendationsItem
import com.rakarguntara.mangasource.models.AnimeTopResponseItem
import com.rakarguntara.mangasource.models.MangaDetailResponse
import com.rakarguntara.mangasource.models.MangaTopResponseItem
import com.rakarguntara.mangasource.models.RecommendationsItem
import com.rakarguntara.mangasource.network.ApiService
import com.rakarguntara.mangasource.network.ResponseState
import retrofit2.HttpException
import java.io.IOException
import javax.inject.Inject

class NetworkRepository @Inject constructor(private val apiService: ApiService) {
    suspend fun getMangaRecommendations(number: Int = 1) : ResponseState<List<RecommendationsItem>, Boolean, Exception>{
        val response = try {
            apiService.getMangaRecommendations(number = number).recommendations
        } catch (e: HttpException){
            return ResponseState(e = e)
        } catch (e: IOException){
            return ResponseState(e = e)
        } catch (e: Exception){
            return ResponseState(e = e)
        }
        return ResponseState(data = response)
    }

//    suspend fun getMangaTops(category: String = "category", number: Int = 1): ResponseState<List<MangaTopResponseItem>, Boolean, Exception>{
//        val response = try {
//            apiService.getMangaTops(category = category, number = number)
//        }  catch (e: HttpException){
//            return ResponseState(e = e)
//        } catch (e: IOException){
//            return ResponseState(e = e)
//        } catch (e: Exception){
//            return ResponseState(e = e)
//        }
//        return ResponseState(data = response)
//    }
//
//    suspend fun getAnimeRecommendations(number: Int = 1) : ResponseState<List<AnimeRecommendationsItem>, Boolean, Exception>{
//        val response = try {
//            apiService.getAnimeRecommendations(number = number).recommendations
//        } catch (e: HttpException){
//            return ResponseState(e = e)
//        } catch (e: IOException){
//            return ResponseState(e = e)
//        } catch (e: Exception){
//            return ResponseState(e = e)
//        }
//        return ResponseState(data = response)
//    }
//
//    suspend fun getAnimeTops(category: String, number: Int): ResponseState<List<AnimeTopResponseItem>, Boolean, Exception>{
//        val response = try {
//            apiService.getAnimeTops(category = category, number = number)
//        } catch (e: IOException){
//            return ResponseState(e = e)
//        } catch (e: HttpException){
//            return ResponseState(e = e)
//        } catch (e: Exception){
//            return ResponseState(e = e)
//        }
//        return ResponseState(data = response)
//    }

    suspend fun getMangaDetail(id: String): ResponseState<MangaDetailResponse, Boolean, Exception>{
        val response = try {
            apiService.getMangaDetail(id = id)
        } catch (e: IOException){
            return ResponseState(e = e)
        } catch (e: HttpException){
            return ResponseState(e = e)
        } catch (e: Exception){
            return ResponseState(e = e)
        }
        return ResponseState(data = response)
    }

    suspend fun getAnimeDetail(id: String): ResponseState<AnimeDetailResponse, Boolean, Exception>{
        val response = try {
            apiService.getAnimeDetail(id = id)
        } catch (e: IOException){
            return ResponseState(e = e)
        } catch (e: HttpException){
            return ResponseState(e = e)
        } catch (e: Exception){
            return ResponseState(e = e)
        }
        return ResponseState(data = response)
    }
}