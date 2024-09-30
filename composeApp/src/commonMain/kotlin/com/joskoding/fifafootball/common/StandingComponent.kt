import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.github.panpf.sketch.AsyncImagePainter
import com.github.panpf.sketch.rememberAsyncImagePainter
import com.github.panpf.sketch.request.ComposableImageRequest
import com.joskoding.fifafootball.fragment.NationalTeam
import org.jetbrains.compose.ui.tooling.preview.Preview

@Composable
fun TableStandingsCard(
    rankNationalTeam: List<NationalTeam>,
    onTeamClick: (NationalTeam) -> Unit // Callback for row clicks
) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(Color(0xFF121212))
            .padding(16.dp)
    ) {
        Text(
            text = "Men's World Ranking",
            color = Color.White,
            fontWeight = FontWeight.Bold,
            fontSize = 20.sp,
            modifier = Modifier.padding(bottom = 16.dp)
        )

        LazyColumn {
            itemsIndexed(rankNationalTeam) { index, team ->
                TeamRow(index + 1, team, onTeamClick) // Pass index and team to TeamRow
            }
        }
    }
}

@Composable
fun TeamRow(
    ranking: Int,
    team: NationalTeam,
    onTeamClick: (NationalTeam) -> Unit // Handle clicks
) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .clickable { onTeamClick(team) } // Add clickable modifier for row
            .padding(vertical = 8.dp),
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.SpaceBetween
    ) {
        Row(
            horizontalArrangement = Arrangement.Start,
            modifier = Modifier.weight(2f)
        ) {
            Text(
                text = ranking.toString(),
                color = Color.White,
                modifier = Modifier.width(24.dp)
            )

            Spacer(modifier = Modifier.width(16.dp))

            Image(
                painter =  rememberAsyncImagePainter(
                    request = ComposableImageRequest(team.flag_url) {}
                ),
                contentDescription = "${team.country} flag",
                modifier = Modifier.size(24.dp)
            )

            Spacer(modifier = Modifier.width(16.dp))

            Text(
                text = team.country ?: "",
                color = Color.White
            )
        }

        Row(
            horizontalArrangement = Arrangement.End,
            modifier = Modifier.weight(1f)
        ) {
            Text(
                text = "${team.rankings.first().wins}",
                color = Color.White,
                modifier = Modifier.width(24.dp)
            )
            Spacer(modifier = Modifier.width(16.dp))

            Text(
                text = "${team.rankings.first().draws}",
                color = Color.White,
                modifier = Modifier.width(24.dp)
            )
            Spacer(modifier = Modifier.width(16.dp))

            Text(
                text = "${team.rankings.first().losses}",
                color = Color.White,
                modifier = Modifier.width(24.dp)
            )
        }
    }
}

