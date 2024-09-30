import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.Card
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import org.jetbrains.compose.ui.tooling.preview.Preview

@Preview
@Composable
fun FeaturedNewsCard() {
    Card(
        shape = RoundedCornerShape(16.dp),
        backgroundColor = Color(0xFF1E1E1E),
        modifier = Modifier
            .fillMaxWidth()
            .padding(16.dp)
    ) {
        Column(
            modifier = Modifier.padding(16.dp)
        ) {
            Text(
                text = "Football",
                color = Color.White.copy(alpha = 0.7f),
                style = MaterialTheme.typography.caption
            )
            Spacer(modifier = Modifier.height(8.dp))
            Text(
                text = "Zidane and Real Madrid: Where it went wrong and what's next",
                color = Color.White,
                style = MaterialTheme.typography.body1,
                fontWeight = FontWeight.Bold
            )
            Spacer(modifier = Modifier.height(8.dp))
            Text(
                text = "Tomorrow, 06:30 PM",
                color = Color.White.copy(alpha = 0.7f),
                style = MaterialTheme.typography.caption
            )
            Spacer(modifier = Modifier.height(8.dp))
        }
    }
}
