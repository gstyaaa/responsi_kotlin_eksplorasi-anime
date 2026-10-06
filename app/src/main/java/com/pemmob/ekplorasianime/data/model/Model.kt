package com.pemmob.ekplorasianime.data.model

import com.google.gson.annotations.SerializedName

data class AnimeResponse(
    @SerializedName("data")
    val data: List<Anime>
)

data class Anime(
    @SerializedName("mal_id")
    val id: Int,
    @SerializedName("title")
    val title: String,
    @SerializedName("images")
    val images: Images,
    @SerializedName("synopsis")
    val synopsis: String?,
    @SerializedName("score")
    val score: Double?,
    @SerializedName("episodes")
    val episodes: Int?
)

data class Images(
    @SerializedName("webp")
    val webp: ImageUrl
)

data class ImageUrl(
    @SerializedName("image_url")
    val imageUrl: String,
    @SerializedName("large_image_url")
    val largeImageUrl: String
)
