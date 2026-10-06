package com.pemmob.ekplorasianime.data.api

import com.pemmob.ekplorasianime.data.model.AnimeDetailResponse
import com.pemmob.ekplorasianime.data.model.AnimeResponse
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET
import retrofit2.http.Path

interface ApiService {
    @GET("anime")
    suspend fun getAnimeList(): AnimeResponse

    @GET("anime/{id}")
    suspend fun getAnimeDetail(@Path("id") id: String): AnimeDetailResponse

    companion object {
        private const val BASE_URL = "https://api.tenrai.org/v1/"

        fun create(): ApiService {
            return Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build()
                .create(ApiService::class.java)
        }
    }
}
