package com.rakarguntara.mangasource.models

import com.google.gson.annotations.SerializedName

data class AnimeRecommendationsResponse(

	@field:SerializedName("amount_recommendations")
	val amountRecommendations: Int,

	@field:SerializedName("recommendations")
	val recommendations: List<AnimeRecommendationsItem>
)

data class AnimeAuthor(

	@field:SerializedName("name")
	val name: String,

	@field:SerializedName("url")
	val url: String
)

data class AnimeRecommendationsItem(

	@field:SerializedName("author")
	val author: AnimeAuthor,

	@field:SerializedName("recommendation")
	val recommendation: AnimeRecommendation,

	@field:SerializedName("description")
	val description: String,

	@field:SerializedName("recommendation_age")
	val recommendationAge: String,

	@field:SerializedName("liked")
	val liked: AnimeLiked
)

data class AnimeLiked(

	@field:SerializedName("myanimelist_url")
	val myanimelistUrl: String,

	@field:SerializedName("picture_url")
	val pictureUrl: String,

	@field:SerializedName("myanimelist_id")
	val myanimelistId: Int,

	@field:SerializedName("title")
	val title: String
)

data class AnimeRecommendation(

	@field:SerializedName("myanimelist_url")
	val myanimelistUrl: String,

	@field:SerializedName("picture_url")
	val pictureUrl: String,

	@field:SerializedName("myanimelist_id")
	val myanimelistId: Int,

	@field:SerializedName("title")
	val title: String
)
