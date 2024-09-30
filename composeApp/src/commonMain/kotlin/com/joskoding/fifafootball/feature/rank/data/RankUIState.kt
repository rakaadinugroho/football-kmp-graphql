package com.joskoding.fifafootball.feature.rank.data

import com.joskoding.fifafootball.fragment.NationalTeam

data class RankUIState (
    val isLoading: Boolean = true,
    val nationalTeam: List<NationalTeam> = listOf()
)