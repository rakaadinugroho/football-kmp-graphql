import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import com.joskoding.fifafootball.theme.MulishTypography

@Composable
fun FIFATheme(content: @Composable () -> Unit) {
    MaterialTheme(
        colors = if (isSystemInDarkTheme()) {
            darkColors(
                primary = Color(0xFFF63D68),
                onPrimary = Color(0xFFF63D68),
                secondary = Color(0xFF5D5C64),
                onSecondary = Color(0xFF5D5C64),
                surface = Color(0xFF161616),
                onSurface = Color(0xFF161616),
                error = Color.LightGray,
                onError = Color.LightGray,
                background = Color(0xFF161616),
                onBackground = Color(0xFF161616),
            )
        } else {
            lightColors(
                primary = Color(0xFFF63D68),
                onPrimary = Color(0xFFF63D68),
                secondary = Color(0xFF5D5C64),
                onSecondary = Color(0xFF5D5C64),
                surface = Color(0xFF161616),
                onSurface = Color(0xFF161616),
                error = Color.LightGray,
                onError = Color.LightGray,
                background = Color(0xFF161616),
                onBackground = Color(0xFF161616),
            )
        },
        typography = MulishTypography(),
        shapes = Shapes(
            small = RoundedCornerShape(8.dp),
            medium = RoundedCornerShape(12.dp),
            large = RoundedCornerShape(16.dp)
        )
    ) {
        content()
    }
}