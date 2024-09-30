package com.joskoding.fifafootball.di

import com.apollographql.apollo.ApolloClient
import com.apollographql.apollo.cache.normalized.api.MemoryCacheFactory
import com.apollographql.apollo.cache.normalized.normalizedCache
import com.apollographql.apollo.network.http.LoggingInterceptor
import com.apollographql.apollo.network.ws.WebSocketNetworkTransport
import com.joskoding.fifafootball.feature.home.HomeViewModel
import com.joskoding.fifafootball.feature.home.data.HomeRepository
import com.joskoding.fifafootball.feature.rank.RankViewModel
import com.joskoding.fifafootball.feature.rank.data.RankRepository
import com.joskoding.fifafootball.network.FootballApi
import com.joskoding.fifafootball.network.FootballApiImpl
import org.koin.core.context.startKoin
import org.koin.dsl.module

fun initDependencyInjection () {
    startKoin {
        modules(
            module {
                single {
                    ApolloClient.Builder()
                        .serverUrl("https://feasible-panda-38.hasura.app/v1/graphql")
                        .subscriptionNetworkTransport(
                            WebSocketNetworkTransport.Builder()
                                .serverUrl("wss://feasible-panda-38.hasura.app/v1/graphql")
                                .addHeader("x-hasura-admin-secret", "7l48yi4kRHP9ucZAWn5wuZHz2q3LvcKZXGuhwEH9yvmP0AktP3hGKrBM4AYdDcEK")
                                .build()
                        )
                        .addHttpHeader("x-hasura-admin-secret", "7l48yi4kRHP9ucZAWn5wuZHz2q3LvcKZXGuhwEH9yvmP0AktP3hGKrBM4AYdDcEK")
                        .normalizedCache(MemoryCacheFactory(maxSizeBytes = 10 * 1024 * 1024))
                        .build()
                }

                single<FootballApi> { FootballApiImpl(get()) }

                single { HomeRepository(get()) }
                single { HomeViewModel(get()) }

                single { RankRepository(get()) }
                single { RankViewModel(get()) }
            }
        )
    }
}