package com.joskoding.fifafootball.feature.country

import androidx.compose.material.BottomNavigation
import androidx.compose.material.BottomNavigationItem
import androidx.compose.material.Icon
import androidx.compose.material.Scaffold
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AccountCircle
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material.icons.filled.Home
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color
import org.jetbrains.compose.ui.tooling.preview.Preview


@Preview
@Composable
fun HomeNav() {
    Scaffold (
        bottomBar = {
            BottomNavigation(
                backgroundColor = Color(252836)
            ) {
                BottomNavigationItem(
                    selected = true,
                    onClick = { /*TODO*/ },
                    label = { Text(text = "Home") },
                    icon = { Icon(Icons.Default.Home, contentDescription = "Home") }
                )
                BottomNavigationItem(
                    selected = true,
                    onClick = { /*TODO*/ },
                    label = { Text(text = "Favourites") },
                    icon = { Icon(Icons.Default.Favorite, contentDescription = "Favourites") }
                )
                BottomNavigationItem(
                    selected = true,
                    onClick = { /*TODO*/ },
                    label = { Text(text = "Account") },
                    icon = { Icon(Icons.Default.AccountCircle, contentDescription = "Account") }
                )
            }
        }
    ) {

    }
}