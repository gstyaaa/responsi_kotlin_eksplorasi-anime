package com.pemmob.ekplorasianime.data.repository

import com.pemmob.ekplorasianime.data.api.ApiService
import com.pemmob.ekplorasianime.data.model.Anime

class AnimeRepository(private val apiService: ApiService) {
    suspend fun getAnimeList(): Result<List<Anime>> {
        return try {
            val response = apiService.getAnimeList()
            Result.success(response.data)
        } catch (e: Exception) {
            Result.failure(e)
        }
    }

    suspend fun getAnimeDetail(id: String): Result<Anime> {
        return try {
            val response = apiService.getAnimeDetail(id)
            Result.success(response.data)
        } catch (e: Exception) {
            Result.failure(e)
        }
    }
}
