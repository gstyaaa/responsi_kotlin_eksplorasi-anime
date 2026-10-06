package com.pemmob.ekplorasianime.ui.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.pemmob.ekplorasianime.data.model.Anime
import com.pemmob.ekplorasianime.data.repository.AnimeRepository
import com.pemmob.ekplorasianime.ui.state.UiState
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch

class AnimeViewModel(private val repository: AnimeRepository) : ViewModel() {

    private val _homeState = MutableStateFlow<UiState<List<Anime>>>(UiState.Loading)
    val homeState: StateFlow<UiState<List<Anime>>> = _homeState.asStateFlow()

    private val _detailState = MutableStateFlow<UiState<Anime>>(UiState.Loading)
    val detailState: StateFlow<UiState<Anime>> = _detailState.asStateFlow()

    init {
        fetchAnimeList()
    }

    fun fetchAnimeList() {
        viewModelScope.launch {
            _homeState.value = UiState.Loading
            repository.getAnimeList()
                .onSuccess { list ->
                    _homeState.value = UiState.Success(list)
                }
                .onFailure { error ->
                    _homeState.value = UiState.Error(error.localizedMessage ?: "Gagal memuat data.")
                }
        }
    }

    fun fetchAnimeDetail(id: String) {
        viewModelScope.launch {
            _detailState.value = UiState.Loading
            repository.getAnimeDetail(id)
                .onSuccess { anime ->
                    _detailState.value = UiState.Success(anime)
                }
                .onFailure { error ->
                    _detailState.value = UiState.Error(error.localizedMessage ?: "Gagal memuat detail anime.")
                }
        }
    }
}
