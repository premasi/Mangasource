package com.rakarguntara.mangasource.models

import com.google.gson.annotations.SerializedName

data class AnimeTopResponse(

	@field:SerializedName("AnimeTopResponse")
	val animeTopResponse: List<AnimeTopResponseItem>
)

data class AnimeTopResponseItem(

	@field:SerializedName("myanimelist_url")
	val myanimelistUrl: String,

	@field:SerializedName("score")
	val score: Double,

	@field:SerializedName("aired_on")
	val airedOn: String,

	@field:SerializedName("picture_url")
	val pictureUrl: String,

	@field:SerializedName("myanimelist_id")
	val myanimelistId: Int,

	@field:SerializedName("members")
	val members: Int,

	@field:SerializedName("rank")
	val rank: Int,

	@field:SerializedName("title")
	val title: String,

	@field:SerializedName("type")
	val type: String
)
