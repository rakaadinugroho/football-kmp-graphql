package com.joskoding.fifafootball.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.em
import androidx.compose.ui.unit.sp
import org.jetbrains.compose.ui.tooling.preview.Preview

@Composable
fun GeneratedCode(modifier: Modifier = Modifier) {
    Row(
        horizontalArrangement = Arrangement.spacedBy(10.dp, Alignment.Start),
        modifier = modifier
        ) {
        Box(
            modifier = Modifier
                .requiredWidth(120.dp)
                .requiredHeight(93.dp)
                .clip(RoundedCornerShape(10.dp))
                .background(Color.Black)  // Set the default background color to black
        ) {

        }
        Column(
            verticalArrangement = Arrangement.spacedBy(10.dp, Alignment.Top)
            ) {
            Text(
                text = "Ronaldo pushing for Man City move",
                color = Color.White,
                lineHeight = 1.57.em,
                style = TextStyle(
                                fontSize = 14.sp,
                                fontWeight = FontWeight.Medium,
                                letterSpacing = 0.3.sp),
                modifier = Modifier
                                .requiredWidth(width = 189.dp))
            Row(
                horizontalArrangement = Arrangement.spacedBy(10.dp, Alignment.Start)
                ) {
                Text(
                    text = "125,908 views  •  2 days ago",
                    color = Color(0xff808191),
                    lineHeight = 1.em,
                    style = TextStyle(
                                        fontSize = 11.sp,
                                        letterSpacing = 0.5.sp))
                }
            Text(
                text = "Jordan Wise",
                color = Color.White.copy(alpha = 0.5f),
                lineHeight = 1.em,
                style = TextStyle(
                                fontSize = 12.sp,
                                letterSpacing = 0.5.sp))
            }
        }
 }

@Preview
@Composable
private fun GeneratedCodePreview() {
    GeneratedCode(Modifier)
 }