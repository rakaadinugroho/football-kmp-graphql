package com.joskoding.fifafootball.feature.home.data

import com.joskoding.fifafootball.LiveMatchSubscription
import com.joskoding.fifafootball.TopPlayerQuery

data class HomeUIState (
    val isLoading: Boolean = true,
    val topPlayer: List<TopPlayerQuery.Player> = listOf(),
    val liveMatch: List<LiveMatchSubscription.Match> = listOf()
)