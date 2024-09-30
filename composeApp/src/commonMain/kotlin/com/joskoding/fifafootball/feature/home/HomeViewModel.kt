package com.joskoding.fifafootball.feature.home

import com.joskoding.fifafootball.feature.home.data.HomeRepository
import com.joskoding.fifafootball.feature.home.data.HomeUIState
import kotlinx.coroutines.flow.*
import kotlinx.coroutines.launch
import moe.tlaster.precompose.viewmodel.ViewModel
import moe.tlaster.precompose.viewmodel.viewModelScope

class HomeViewModel(private val homeRepository: HomeRepository): ViewModel() {

    private val _uiState = MutableStateFlow(HomeUIState())
    val uiState get() = _uiState.asStateFlow()

    fun getLiveMatch() = viewModelScope.launch {
        homeRepository.getLiveMatch().toFlow().collect { response ->
            if (!response.hasErrors()) {
                _uiState.update {
                    it.copy(liveMatch = response.data?.match?: emptyList())
                }
            }
        }
    }

    fun getTopCaps() = viewModelScope.launch {
        homeRepository.getTopPlayer().toFlow()
            .catch { except -> }
            .collectLatest { response ->
                if (!response.hasErrors()) {
                    _uiState.update {
                        it.copy(topPlayer = response.data?.player?: emptyList())
                    }
                }
            }
    }
}