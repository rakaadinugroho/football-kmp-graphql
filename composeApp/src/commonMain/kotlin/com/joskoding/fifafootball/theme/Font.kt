package com.joskoding.fifafootball.theme

import androidx.compose.material.Typography
import androidx.compose.runtime.Composable
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp
import fifafootball.composeapp.generated.resources.*
import fifafootball.composeapp.generated.resources.Res
import fifafootball.composeapp.generated.resources.mulish_light
import fifafootball.composeapp.generated.resources.mulish_medium
import fifafootball.composeapp.generated.resources.mulish_regular
import org.jetbrains.compose.resources.Font


@Composable
fun MulishFont() = FontFamily(
    Font(Res.font.mulish_regular, FontWeight.Normal),
    Font(Res.font.mulish_light, FontWeight.Light),
    Font(Res.font.mulish_medium, FontWeight.Medium),
    Font(Res.font.mulish_bold, FontWeight.Bold),
)

@Composable
fun MulishTypography() = Typography().run {
    val fontFamily = MulishFont()

    copy(
        caption = caption.copy(fontFamily = fontFamily),
        overline = overline.copy(fontFamily = fontFamily),
        button = button.copy(fontFamily = fontFamily),
        body2 = body2.copy(fontFamily = fontFamily),
        body1 = body1.copy(fontFamily = fontFamily),
        subtitle1 = subtitle1.copy(fontFamily = fontFamily),
        subtitle2 = subtitle2.copy(fontFamily = fontFamily),
        h1 = h1.copy(fontFamily = fontFamily),
        h2 = h2.copy(fontFamily = fontFamily),
        h3 = h3.copy(fontFamily = fontFamily),
        h4 = h4.copy(fontFamily = fontFamily),
        h5 = h5.copy(fontFamily = fontFamily),
        h6 = h6.copy(fontFamily = fontFamily),
    )
}