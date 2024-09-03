package com.rakarguntara.mangasource.models

import com.google.gson.annotations.SerializedName

data class MangaDetailResponse(

	@field:SerializedName("alternative_titles")
	val alternativeTitles: AlternativeTitles,

	@field:SerializedName("characters")
	val characters: List<CharactersItem>,

	@field:SerializedName("title_ov")
	val titleOv: String,

	@field:SerializedName("picture_url")
	val pictureUrl: String,

	@field:SerializedName("title_en")
	val titleEn: String,

	@field:SerializedName("information")
	val information: Information,

	@field:SerializedName("synopsis")
	val synopsis: String,

	@field:SerializedName("statistics")
	val statistics: Statistics
)

data class Information(

	@field:SerializedName("serialization")
	val serialization: List<SerializationItem>,

	@field:SerializedName("chapters")
	val chapters: String,

	@field:SerializedName("genres")
	val genres: List<GenresItem>,

	@field:SerializedName("volumes")
	val volumes: String,

	@field:SerializedName("theme")
	val theme: List<ThemeItem>,

	@field:SerializedName("published")
	val published: String,

	@field:SerializedName("type")
	val type: List<TypeItem>,

	@field:SerializedName("status")
	val status: String,

	@field:SerializedName("demographic")
	val demographic: List<DemographicItem>,

	@field:SerializedName("authors")
	val authors: List<AuthorsItem>
)

data class Statistics(

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

data class DemographicItem(

	@field:SerializedName("name")
	val name: String,

	@field:SerializedName("url")
	val url: String
)

data class CharactersItem(

	@field:SerializedName("myanimelist_url")
	val myanimelistUrl: String,

	@field:SerializedName("picture_url")
	val pictureUrl: String,

	@field:SerializedName("name")
	val name: String
)

data class AlternativeTitles(

	@field:SerializedName("japanese")
	val japanese: String,

	@field:SerializedName("english")
	val english: String
)

data class ThemeItem(

	@field:SerializedName("name")
	val name: String,

	@field:SerializedName("url")
	val url: String
)

data class SerializationItem(

	@field:SerializedName("name")
	val name: String,

	@field:SerializedName("url")
	val url: String
)

data class GenresItem(

	@field:SerializedName("name")
	val name: String,

	@field:SerializedName("url")
	val url: String
)

data class TypeItem(

	@field:SerializedName("name")
	val name: String,

	@field:SerializedName("url")
	val url: String
)

data class AuthorsItem(

	@field:SerializedName("name")
	val name: String,

	@field:SerializedName("url")
	val url: String
)
