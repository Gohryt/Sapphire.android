package gohryt.sapphire.resources

import androidx.compose.runtime.Composable
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp

interface Typography {
    var h1: TextStyle
    var h2: TextStyle
    var h3: TextStyle
    var p1: TextStyle
    var p2: TextStyle
    var p3: TextStyle
    var q1: TextStyle
    var q2: TextStyle
    var q3: TextStyle
}

@Composable
fun getTypography(): Typography {
    return object: Typography {
        override var h1 = TextStyle(
                fontSize = 24.sp,
                fontWeight = FontWeight.Bold,
                fontStyle = FontStyle.Normal,
                fontFamily = FontFamily.Default,
                letterSpacing = (-0.3).sp
        )
        override var h2 = TextStyle(
                fontSize = 20.sp,
                fontWeight = FontWeight.Bold,
                fontStyle = FontStyle.Normal,
                fontFamily = FontFamily.Default,
                letterSpacing = (-0.2).sp
        )
        override var h3 = TextStyle(
                fontSize = 16.sp,
                fontWeight = FontWeight.Bold,
                fontStyle = FontStyle.Normal,
                fontFamily = FontFamily.Default,
                letterSpacing = (-0.1).sp
        )
        override var p1 = TextStyle(
                fontSize = 20.sp,
                fontWeight = FontWeight.Normal,
                fontStyle = FontStyle.Normal,
                fontFamily = FontFamily.Default,
                letterSpacing = (-0.2).sp
        )
        override var p2 = TextStyle(
                fontSize = 16.sp,
                fontWeight = FontWeight.Normal,
                fontStyle = FontStyle.Normal,
                fontFamily = FontFamily.Default,
                letterSpacing = (-0.1).sp
        )
        override var p3 = TextStyle(
                fontSize = 12.sp,
                fontWeight = FontWeight.Normal,
                fontStyle = FontStyle.Normal,
                fontFamily = FontFamily.Default,
                letterSpacing = 0.sp
        )
        override var q1 = TextStyle(
                fontSize = 20.sp,
                fontWeight = FontWeight.Normal,
                fontStyle = FontStyle.Italic,
                fontFamily = FontFamily.Default,
                letterSpacing = (-0.2).sp
        )
        override var q2 = TextStyle(
                fontSize = 16.sp,
                fontWeight = FontWeight.Normal,
                fontStyle = FontStyle.Italic,
                fontFamily = FontFamily.Default,
                letterSpacing = (-0.1).sp
        )
        override var q3 = TextStyle(
                fontSize = 12.sp,
                fontWeight = FontWeight.Normal,
                fontStyle = FontStyle.Italic,
                fontFamily = FontFamily.Default,
                letterSpacing = 0.sp
        )
    }
}