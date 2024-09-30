package com.joskoding.fifafootball.feature.home.data

import com.joskoding.fifafootball.network.FootballApi

class HomeRepository(private val footballApi: FootballApi) {
    suspend fun getNationalTeamRanking() = footballApi.getNationalRank()

    suspend fun getTopPlayer() = footballApi.getTopPlayer()

    fun getLiveMatch() = footballApi.liveMatch()
}