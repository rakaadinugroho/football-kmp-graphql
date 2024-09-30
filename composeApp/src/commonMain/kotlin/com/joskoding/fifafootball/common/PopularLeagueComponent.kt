package com.joskoding.fifafootball.common

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Icon
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.material.TextButton
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Place
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import org.jetbrains.compose.ui.tooling.preview.Preview

@Preview
@Composable
fun PopularTeamsRow() {
    Column(modifier = Modifier.fillMaxWidth()) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 16.dp, vertical = 8.dp),
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically
        ) {
            Text(
                text = "Popular Teams",
                style = MaterialTheme.typography.subtitle1,
                color = Color.White
            )
            TextButton(onClick = { /* View All */ }) {
                Text(text = "View All", color = Color.White)
            }
        }
        LazyRow(
            contentPadding = PaddingValues(horizontal = 16.dp),
            horizontalArrangement = Arrangement.spacedBy(16.dp)
        ) {
            items(listOf("Real Madrid", "Barcelona", "Juventus", "Man City")) { team ->
                TeamIcon(team)
            }
        }
    }
}

@Composable
fun TeamIcon(team: String) {
    Column(horizontalAlignment = Alignment.CenterHorizontally) {
        Box(
            modifier = Modifier
                .size(60.dp)
                .background(Color(0xFF26294B), shape = RoundedCornerShape(8.dp)),
            contentAlignment = Alignment.Center
        ) {
            Icon(imageVector = Icons.Default.Place, contentDescription = team, tint = Color.White)
        }
    }
}
