package com.rakarguntara.mangasource.models

import com.google.gson.annotations.SerializedName

data class MangaRecommendationsResponse(

	@field:SerializedName("amount_recommendations")
	val amountRecommendations: Int,

	@field:SerializedName("recommendations")
	val recommendations: List<RecommendationsItem>
)

data class Liked(

	@field:SerializedName("myanimelist_url")
	val myanimelistUrl: String,

	@field:SerializedName("picture_url")
	val pictureUrl: String,

	@field:SerializedName("myanimelist_id")
	val myanimelistId: Int,

	@field:SerializedName("title")
	val title: String
)

data class Author(

	@field:SerializedName("name")
	val name: String,

	@field:SerializedName("url")
	val url: String
)

data class Recommendation(

	@field:SerializedName("myanimelist_url")
	val myanimelistUrl: String,

	@field:SerializedName("picture_url")
	val pictureUrl: String,

	@field:SerializedName("myanimelist_id")
	val myanimelistId: Int,

	@field:SerializedName("title")
	val title: String
)

data class RecommendationsItem(

	@field:SerializedName("author")
	val author: Author,

	@field:SerializedName("recommendation")
	val recommendation: Recommendation,

	@field:SerializedName("description")
	val description: String,

	@field:SerializedName("recommendation_age")
	val recommendationAge: String,

	@field:SerializedName("liked")
	val liked: Liked
)
