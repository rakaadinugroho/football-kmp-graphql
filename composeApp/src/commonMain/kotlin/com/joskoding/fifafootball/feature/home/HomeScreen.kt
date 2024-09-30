package com.joskoding.fifafootball.feature.home

import TopCapsHeader
import FeaturedNewsCard
import LiveScoresCard
import PlayerCaps
import androidx.compose.animation.AnimatedVisibility
import androidx.compose.animation.fadeIn
import androidx.compose.animation.fadeOut
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.joskoding.fifafootball.fragment.NationalTeam

@Composable
fun HomeScreen(viewModel: HomeViewModel, onClickNationalTeam: (NationalTeam) -> Unit) {
    val uiState by viewModel.uiState.collectAsState()

    LaunchedEffect(Unit) {
        viewModel.getLiveMatch()
        viewModel.getTopCaps()
    }

    LazyColumn(
        modifier = Modifier.fillMaxSize().padding(bottom = 60.dp)
    ) {
        item {
            FeaturedNewsCard()
        }

        item {
            AnimatedVisibility(
                visible = uiState.liveMatch.isNotEmpty(),
                enter = fadeIn(),
                exit = fadeOut()
            ) {
                LiveScoresCard(uiState.liveMatch)
            }
        }

        item {
            AnimatedVisibility(
                visible = uiState.topPlayer.isNotEmpty(),
                enter = fadeIn(),
                exit = fadeOut()
            ) {
                TopCapsHeader()
            }
        }

        itemsIndexed(uiState.topPlayer) { index, player ->
            PlayerCaps(index + 1, player)
        }
    }
}