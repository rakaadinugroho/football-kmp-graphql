package com.joskoding.fifafootball.network

import com.apollographql.apollo.ApolloCall
import com.apollographql.apollo.api.ApolloResponse
import com.joskoding.fifafootball.*
import kotlinx.coroutines.flow.Flow

interface FootballApi {
    suspend fun getNationalRank(): ApolloCall<RankingQuery.Data>
    suspend fun getTopPlayer(): ApolloCall<TopPlayerQuery.Data>
    suspend fun getDetailMatch(matchId: Int): ApolloCall<DetailMatchQuery.Data>
    suspend fun getDetailNationalTeam(teamId: Int): ApolloCall<DetailNationalTeamQuery.Data>

    fun liveMatch(): ApolloCall<LiveMatchSubscription.Data>
}