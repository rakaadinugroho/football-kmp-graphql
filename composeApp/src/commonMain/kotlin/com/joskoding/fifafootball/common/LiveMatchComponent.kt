import androidx.compose.foundation.*
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Button
import androidx.compose.material.Card
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.github.panpf.sketch.rememberAsyncImagePainter
import com.github.panpf.sketch.request.ComposableImageRequest
import com.joskoding.fifafootball.LiveMatchSubscription
import com.joskoding.fifafootball.fragment.NationalTeam
import org.jetbrains.compose.ui.tooling.preview.Preview

@Preview
@Composable
fun LiveScoresCard(matchs: List<LiveMatchSubscription.Match>) {
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .padding(16.dp)
    ) {
        Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.Bottom
            ) {
                Text(
                    text = "Live Now",
                    style = MaterialTheme.typography.h6,
                    color = Color.White
                )
                Text(
                    text = "See more",
                    style = MaterialTheme.typography.caption.copy(fontSize = 14.sp),
                    color = MaterialTheme.colors.primary
                )
            }

            Spacer(modifier = Modifier.height(16.dp))

            LazyRow(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.spacedBy(16.dp),
            ) {
                items(matchs) { match ->
                    LiveScoreCard(
                        match = match,
                        modifier = Modifier.width(300.dp)
                    )
                }
            }
    }
}

@Composable
fun LiveScoreCard(
    match: LiveMatchSubscription.Match,
    modifier: Modifier
) {
    Card(
        shape = RoundedCornerShape(16.dp),
        modifier = modifier,
        backgroundColor = Color(0xFF1E1E1E)
    ) {
        Column(
            modifier = Modifier
                .padding(12.dp),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.SpaceBetween
        ) {
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.CenterVertically
            ) {
                Row(verticalAlignment = Alignment.CenterVertically) {
                    Text(
                        text = match.title ?: "",
                        style = MaterialTheme.typography.caption, color = Color(0xFFB6B6B6)
                    )
                }


                Box(
                    modifier = Modifier
                        .background(Color(0xFFECFDF3), MaterialTheme.shapes.small)
                        .padding(8.dp)
                ) {
                    Text(
                        text = if (match.completed != true) "${match.current_minute}" else "Ended",
                        color = Color(0xFF027A48),
                        style = MaterialTheme.typography.caption
                    )
                }
            }

            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(vertical = 12.dp),
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.CenterVertically
            ) {
                TeamInfo(team = match.home?.nationalTeam, modifier = Modifier.weight(1f))

                Text(
                    text = "${match.match_score?.home_team_score?: 0} - ${match.match_score?.away_team_score?: 0}",
                    color = Color.White,
                    textAlign = TextAlign.Center,
                    style = MaterialTheme.typography.body1,
                    modifier = Modifier
                        .weight(1f)
                        .padding(horizontal = 8.dp)
                )

                TeamInfo(team = match.away?.nationalTeam, modifier = Modifier.weight(1f))
            }

            Button(
                onClick = {},
                modifier = Modifier
                    .fillMaxWidth()
            ) {
                Text(text = "Details", color = Color.White, style = MaterialTheme.typography.button)
            }
        }
    }
}

@Composable
private fun TeamInfo(team: NationalTeam?, modifier: Modifier) {
    Column(
        modifier = modifier,
        verticalArrangement = Arrangement.SpaceBetween,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Image(
            painter = rememberAsyncImagePainter(
                request = ComposableImageRequest(team?.flag_url) {
                }
            ),
            contentDescription = null,
            modifier = Modifier.size(32.dp),
            contentScale = ContentScale.Fit
        )
        Text(
            text = team?.country ?: "",
            color = Color.White,
            textAlign = TextAlign.Center,
            style = MaterialTheme.typography.body2
        )
    }
}