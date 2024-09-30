import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.github.panpf.sketch.rememberAsyncImagePainter
import com.github.panpf.sketch.request.ComposableImageRequest
import com.joskoding.fifafootball.TopPlayerQuery
import com.joskoding.fifafootball.fragment.PlayerDetail

data class PlayerAssist(
    val rank: Int,
    val name: String,
    val team: String,
    val assists: Int,
    val imageUrl: String
)

@Composable
fun TopCapsHeader() {
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .background(Color(0xFF1F1F1F))
            .padding(16.dp)
    ) {
        Row(
            modifier = Modifier.fillMaxWidth(),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            Text(
                text = "#",
                color = Color.Gray,
                style = MaterialTheme.typography.subtitle2,
                fontWeight = FontWeight.Bold
            )
            Text(
                text = "Player",
                color = Color.Gray,
                style = MaterialTheme.typography.subtitle2,
                fontWeight = FontWeight.Bold,
                textAlign = TextAlign.Left,
                modifier = Modifier.weight(1f).padding(horizontal = 16.dp)
            )
            Text(
                text = "Caps",
                color = Color.Gray,
                style = MaterialTheme.typography.subtitle2,
                textAlign = TextAlign.End
            )
        }

        Spacer(modifier = Modifier.height(8.dp))
    }
}

@Composable
fun PlayerCaps(rank: Int, player: TopPlayerQuery.Player) {
    Row(
        modifier = Modifier.fillMaxWidth().padding(horizontal = 16.dp, vertical = 8.dp),
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.SpaceBetween
    ) {
        Text(
            text = rank.toString(),
            color = Color.White,
            style = MaterialTheme.typography.body2
        )

        Row(
            modifier = Modifier.weight(1f).padding(horizontal = 16.dp),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.Start,
        ) {
            Image(
                painter = rememberAsyncImagePainter(
                    request = ComposableImageRequest(player.playerDetail.photo_url) {}
                ),
                contentDescription = null,
                modifier = Modifier
                    .size(32.dp)
                    .padding(end = 16.dp),
                contentScale = ContentScale.Crop
            )

            Column {
                Text(
                    text = player.playerDetail.name,
                    color = Color.White,
                    style = MaterialTheme.typography.body1
                )
                Text(
                    text = "${player.team?.name} ${player.team?.league?.name?.let { "($it)" }}",
                    style = MaterialTheme.typography.caption, color = Color(0xFFB6B6B6)
                )
            }
        }

        Text(
            text = player.playerDetail.total_caps.toString(),
            color = MaterialTheme.colors.primary,
            style = MaterialTheme.typography.body1,
            textAlign = TextAlign.End
        )
    }
}
