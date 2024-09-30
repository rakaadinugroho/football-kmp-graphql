package com.joskoding.fifafootball.feature.rank

import TableStandingsCard
import androidx.compose.animation.AnimatedVisibility
import androidx.compose.animation.fadeIn
import androidx.compose.animation.fadeOut
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.CircularProgressIndicator
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import com.joskoding.fifafootball.fragment.NationalTeam

@Composable
fun RankScreen(viewModel: RankViewModel, onClickNationalTeam: (NationalTeam) -> Unit) {
    val uiState by viewModel.uiState.collectAsState()

    LaunchedEffect(Unit) {
        viewModel.loadNationalTeamRank()
    }


    Column(modifier = Modifier.fillMaxSize()) {
        AnimatedVisibility(
            visible = uiState.isLoading,
            enter = fadeIn(),
            exit = fadeOut()
        ) {
            CircularProgressIndicator()
        }

        AnimatedVisibility(
            visible = uiState.nationalTeam.isNotEmpty(),
            enter = fadeIn(),
            exit = fadeOut()
        ) {
            TableStandingsCard(uiState.nationalTeam, onClickNationalTeam)
        }
    }
}