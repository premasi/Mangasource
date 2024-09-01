package com.rakarguntara.mangasource.network

import com.rakarguntara.mangasource.BuildConfig
import com.rakarguntara.mangasource.models.MangaRecommendationsResponse
import com.rakarguntara.mangasource.models.MangaTopResponseItem
import retrofit2.http.GET
import retrofit2.http.Header
import retrofit2.http.Path
import retrofit2.http.Query
import javax.inject.Singleton

@Singleton
interface ApiService {
 @GET("v2/manga/recommendations")
 suspend fun getMangaRecomenndations(
  @Header("x-rapidapi-key") key : String = BuildConfig.RAPID_KEY,
  @Header("x-rapidapi-host") host: String = BuildConfig.RAPID_HOST,
  @Query("p") number: Int,
 ) : MangaRecommendationsResponse

 @GET("manga/top/{category}")
 suspend fun getMangaTops(
  @Header("x-rapidapi-key") key : String = BuildConfig.RAPID_KEY,
  @Header("x-rapidapi-host") host: String = BuildConfig.RAPID_HOST,
  @Path("category") category: String,
  @Query("p") number: Int,
 ) : List<MangaTopResponseItem>
}

