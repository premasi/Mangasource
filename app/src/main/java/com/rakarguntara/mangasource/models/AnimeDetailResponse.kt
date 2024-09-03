package com.rakarguntara.mangasource.models

import com.google.gson.annotations.SerializedName

data class AnimeDetailResponse(

	@field:SerializedName("alternative_titles")
	val alternativeTitles: AnimeAlternativeTitles,

	@field:SerializedName("characters")
	val characters: List<AnimeCharactersItem>,

	@field:SerializedName("title_ov")
	val titleOv: String,

	@field:SerializedName("picture_url")
	val pictureUrl: String,

	@field:SerializedName("title_en")
	val titleEn: String,

	@field:SerializedName("information")
	val information: AnimeInformation,

	@field:SerializedName("synopsis")
	val synopsis: String,

	@field:SerializedName("statistics")
	val statistics: AnimeStatistics
)

data class AnimeCharactersItem(

	@field:SerializedName("myanimelist_url")
	val myanimelistUrl: String,

	@field:SerializedName("picture_url")
	val pictureUrl: String,

	@field:SerializedName("voice_actor_picture_url")
	val voiceActorPictureUrl: String,

	@field:SerializedName("voice_actor_name")
	val voiceActorName: String,

	@field:SerializedName("name")
	val name: String,

	@field:SerializedName("voice_actor_myanimelist_url")
	val voiceActorMyanimelistUrl: String
)

data class AnimeAlternativeTitles(

	@field:SerializedName("japanese")
	val japanese: String,

	@field:SerializedName("synonyms")
	val synonyms: String,

	@field:SerializedName("english")
	val english: String
)

data class StudiosItem(

	@field:SerializedName("name")
	val name: String,

	@field:SerializedName("url")
	val url: String
)

data class AnimeInformation(

	@field:SerializedName("broadcast")
	val broadcast: String,

	@field:SerializedName("aired")
	val aired: String,

	@field:SerializedName("studios")
	val studios: List<StudiosItem>,

	@field:SerializedName("premiered")
	val premiered: List<PremieredItem>,

	@field:SerializedName("rating")
	val rating: String,

	@field:SerializedName("source")
	val source: String,

	@field:SerializedName("type")
	val type: List<AnimeTypeItem>,

	@field:SerializedName("licensors")
	val licensors: String,

	@field:SerializedName("producers")
	val producers: List<ProducersItem>,

	@field:SerializedName("demographic")
	val demographic: List<AnimeDemographicItem>,

	@field:SerializedName("duration")
	val duration: String,

	@field:SerializedName("genres")
	val genres: List<AnimeGenresItem>,

	@field:SerializedName("genre")
	val genre: String,

	@field:SerializedName("theme")
	val theme: String,

	@field:SerializedName("episodes")
	val episodes: String,

	@field:SerializedName("status")
	val status: String
)

data class AnimeStatistics(

	@field:SerializedName("favorites")
	val favorites: Int,

	@field:SerializedName("score")
	val score: Double,

	@field:SerializedName("popularity")
	val popularity: Int,

	@field:SerializedName("members")
	val members: Int,

	@field:SerializedName("ranked")
	val ranked: Int
)

data class ProducersItem(

	@field:SerializedName("name")
	val name: String,

	@field:SerializedName("url")
	val url: String
)

data class PremieredItem(

	@field:SerializedName("name")
	val name: String,

	@field:SerializedName("url")
	val url: String
)

data class AnimeDemographicItem(

	@field:SerializedName("name")
	val name: String,

	@field:SerializedName("url")
	val url: String
)

data class AnimeGenresItem(

	@field:SerializedName("name")
	val name: String,

	@field:SerializedName("url")
	val url: String
)

data class AnimeTypeItem(

	@field:SerializedName("name")
	val name: String,

	@field:SerializedName("url")
	val url: String
)
