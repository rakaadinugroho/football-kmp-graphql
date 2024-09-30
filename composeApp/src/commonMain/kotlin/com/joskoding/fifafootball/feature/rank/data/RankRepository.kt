package com.joskoding.fifafootball.feature.rank.data

import com.joskoding.fifafootball.network.FootballApi

class RankRepository(private val footballApi: FootballApi) {
    suspend fun getFifaRanking() = footballApi.getNationalRank()
}