package com.joskoding.fifafootball.network

import com.apollographql.apollo.ApolloCall
import com.apollographql.apollo.ApolloClient
import com.apollographql.apollo.api.ApolloResponse
import com.joskoding.fifafootball.*
import kotlinx.coroutines.flow.Flow

class FootballApiImpl(private val apolloClient: ApolloClient): FootballApi {
    override suspend fun getNationalRank(): ApolloCall<RankingQuery.Data> {
        return apolloClient.query(RankingQuery())
    }

    override suspend fun getTopPlayer(): ApolloCall<TopPlayerQuery.Data> {
        return apolloClient.query(TopPlayerQuery())
    }

    override suspend fun getDetailMatch(matchId: Int): ApolloCall<DetailMatchQuery.Data> {
        return apolloClient.query(DetailMatchQuery(matchId))
    }

    override suspend fun getDetailNationalTeam(teamId: Int): ApolloCall<DetailNationalTeamQuery.Data> {
        return apolloClient.query(DetailNationalTeamQuery(teamId))
    }

    override fun liveMatch(): ApolloCall<LiveMatchSubscription.Data> {
        return apolloClient.subscription(LiveMatchSubscription())
    }
}