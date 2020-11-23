package gohryt.sapphire.resources

import android.os.Build
import androidx.annotation.RequiresApi
import androidx.compose.runtime.Composable
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp

@RequiresApi(Build.VERSION_CODES.R)
object Typography {
    data class Data(
        var h1: TextStyle,
        var h2: TextStyle,
        var h3: TextStyle,
        var p1: TextStyle,
        var p2: TextStyle,
        var p3: TextStyle,
        var q1: TextStyle,
        var q2: TextStyle,
        var q3: TextStyle
    )

    @Composable
    fun get(): Data {
        return Data(
            h1 = TextStyle(
                fontSize = 24.sp,
                fontWeight = FontWeight.Bold,
                fontStyle = FontStyle.Normal,
                fontFamily = FontFamily.Default,
                letterSpacing = (-0.3).sp
            ),
            h2 = TextStyle(
                fontSize = 20.sp,
                fontWeight = FontWeight.Bold,
                fontStyle = FontStyle.Normal,
                fontFamily = FontFamily.Default,
                letterSpacing = (-0.2).sp
            ),
            h3 = TextStyle(
                fontSize = 16.sp,
                fontWeight = FontWeight.Bold,
                fontStyle = FontStyle.Normal,
                fontFamily = FontFamily.Default,
                letterSpacing = (-0.1).sp
            ),
            p1 = TextStyle(
                fontSize = 20.sp,
                fontWeight = FontWeight.Normal,
                fontStyle = FontStyle.Normal,
                fontFamily = FontFamily.Default,
                letterSpacing = (-0.2).sp
            ),
            p2 = TextStyle(
                fontSize = 16.sp,
                fontWeight = FontWeight.Normal,
                fontStyle = FontStyle.Normal,
                fontFamily = FontFamily.Default,
                letterSpacing = (-0.1).sp
            ),
            p3 = TextStyle(
                fontSize = 12.sp,
                fontWeight = FontWeight.Normal,
                fontStyle = FontStyle.Normal,
                fontFamily = FontFamily.Default,
                letterSpacing = 0.sp
            ),
            q1 = TextStyle(
                fontSize = 20.sp,
                fontWeight = FontWeight.Normal,
                fontStyle = FontStyle.Italic,
                fontFamily = FontFamily.Default,
                letterSpacing = (-0.2).sp
            ),
            q2 = TextStyle(
                fontSize = 16.sp,
                fontWeight = FontWeight.Normal,
                fontStyle = FontStyle.Italic,
                fontFamily = FontFamily.Default,
                letterSpacing = (-0.1).sp
            ),
            q3 = TextStyle(
                fontSize = 12.sp,
                fontWeight = FontWeight.Normal,
                fontStyle = FontStyle.Italic,
                fontFamily = FontFamily.Default,
                letterSpacing = 0.sp
            )
        )
    }
}