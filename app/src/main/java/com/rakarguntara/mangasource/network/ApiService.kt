package com.rakarguntara.mangasource.network

import com.rakarguntara.mangasource.BuildConfig
import com.rakarguntara.mangasource.models.MangaRecommendationsResponse
import retrofit2.http.GET
import retrofit2.http.Header
import retrofit2.http.Query
import javax.inject.Singleton

@Singleton
interface ApiService {
 @GET("manga/recommendations")
 suspend fun getMangaRecomenndations(
  @Header("x-rapidapi-key") key : String = BuildConfig.RAPID_KEY,
  @Header("x-rapidapi-host") host: String = BuildConfig.RAPID_HOST,
  @Query("p") number: Int,
 ) : MangaRecommendationsResponse
}