package com.joskoding.fifafootball.feature.rank

import com.joskoding.fifafootball.feature.rank.data.RankRepository
import com.joskoding.fifafootball.feature.rank.data.RankUIState
import kotlinx.coroutines.flow.*
import kotlinx.coroutines.launch
import moe.tlaster.precompose.viewmodel.ViewModel
import moe.tlaster.precompose.viewmodel.viewModelScope

class RankViewModel(private val rankRepository: RankRepository)
        : ViewModel() {
    private val _uiState = MutableStateFlow(RankUIState())

    val uiState get() = _uiState.asStateFlow()

    fun loadNationalTeamRank() = viewModelScope.launch {
        _uiState.update { it.copy(isLoading = true) }

        rankRepository.getFifaRanking()
            .toFlow()
            .catch { except ->
                _uiState.update { it.copy(isLoading = false) }
            }
            .collectLatest { response ->
                if (!response.hasErrors()) {
                    val nationalTeam = response.data?.ranking?.mapNotNull { item -> item.team?.nationalTeam } ?: emptyList()
                    _uiState.update {
                        it.copy(
                            isLoading = false,
                            nationalTeam = nationalTeam
                        )
                    }
                } else {
                    _uiState.update { it.copy(isLoading = false) }
                }
            }
    }
}