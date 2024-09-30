package com.joskoding.fifafootball

import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.*
import androidx.compose.material.icons.outlined.Notifications
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import com.joskoding.fifafootball.feature.home.HomeScreen
import com.joskoding.fifafootball.feature.home.HomeViewModel
import com.joskoding.fifafootball.feature.rank.RankScreen
import com.joskoding.fifafootball.feature.rank.RankViewModel
import moe.tlaster.precompose.koin.koinViewModel
import moe.tlaster.precompose.navigation.NavHost
import moe.tlaster.precompose.navigation.rememberNavigator
import moe.tlaster.precompose.navigation.transition.NavTransition

@Composable
fun Nav() {
    val navigator = rememberNavigator()
    val tabs = listOf("Home", "Rank", "News", "Account")
    var selectedTab by remember { mutableIntStateOf(0) }

    Scaffold(
        topBar = {
            if (selectedTab == 0 || selectedTab == 1) {
                TopAppBar(
                    backgroundColor = MaterialTheme.colors.background,
                    contentColor = Color.White,
                    elevation = 0.dp,
                    title = {
                        Row(
                            modifier = Modifier.fillMaxWidth(),
                            verticalAlignment = Alignment.CenterVertically
                        ) {
                            Text(
                                text = "FIFA Football",
                                style = MaterialTheme.typography.h6,
                                color = Color.White,
                                modifier = Modifier.weight(1f) // Aligns the text to the left
                            )
                            IconButton(
                                onClick = { /* Handle notification click */ }
                            ) {
                                Icon(
                                    imageVector = Icons.Outlined.Notifications,
                                    contentDescription = "Notifications",
                                    tint = Color.White
                                )
                            }
                        }
                    }
                )
            }
        },
        bottomBar = {
            BottomNavigation(
                backgroundColor = Color(0xFF1E1E1E)
            ) {
                tabs.forEachIndexed { index, tab ->
                    val selected = index == selectedTab
                    BottomNavigationItem(
                        selected = selected,
                        onClick = {
                            selectedTab = index
                            when (index) {
                                0 -> navigator.navigate("/home")
                                1 -> navigator.navigate("/rank")
                                2 -> navigator.navigate("/news")
                                3 -> navigator.navigate("/account")
                            }
                        },
                        label = {
                            Text(
                                text = tab,
                                style = MaterialTheme.typography.body2,
                                color = if (selected) Color.White else Color(0xFF9E9E9E)
                            )
                        },
                        icon = {
                            val icon = when (tab) {
                                "Home" -> Icons.Default.Home
                                "Rank" -> Icons.Default.List
                                "News" -> Icons.Default.AccountBox
                                "Account" -> Icons.Default.AccountCircle
                                else -> Icons.Default.Home
                            }
                            Icon(
                                imageVector = icon,
                                contentDescription = null,
                                tint = if (selected) MaterialTheme.colors.primary else Color(0xFF9E9E9E)
                            )
                        }
                    )
                }
            }
        }
    ) {
        NavHost(
            navigator = navigator,
            navTransition = NavTransition(),
            initialRoute = "/home"
        ) {
            scene("/home", navTransition = NavTransition()) {
                val vm = koinViewModel(HomeViewModel::class)
                HomeScreen(vm) {
                    // do something
                }
            }
            scene("/rank", navTransition = NavTransition()) {
                val vm = koinViewModel(RankViewModel::class)
                RankScreen(vm) {

                }
            }
            scene("/news", navTransition = NavTransition()) {
                // NewsScreen
            }
            scene("/account", navTransition = NavTransition()) {
                // AccountScreen
            }
        }
    }
}