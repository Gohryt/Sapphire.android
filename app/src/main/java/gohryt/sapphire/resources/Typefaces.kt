package gohryt.sapphire.resources

import android.content.Context
import android.os.Build
import androidx.annotation.RequiresApi
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp
import gohryt.sapphire.R

@RequiresApi(Build.VERSION_CODES.R)
open class Typefaces(context: Context) {
    private val ubuntu = FontFamily(
        Font(
            resId = R.font.light,
            weight = FontWeight.W300,
            style = FontStyle.Normal
        ),
        Font(
            resId = R.font.light_italic,
            weight = FontWeight.W300,
            style = FontStyle.Italic
        ),
        Font(
            resId = R.font.regular,
            weight = FontWeight.W400,
            style = FontStyle.Normal
        ),
        Font(
            resId = R.font.regular_italic,
            weight = FontWeight.W400,
            style = FontStyle.Italic
        ),
        Font(
            resId = R.font.medium,
            weight = FontWeight.W500,
            style = FontStyle.Normal
        ),
        Font(
            resId = R.font.medium_italic,
            weight = FontWeight.W500,
            style = FontStyle.Italic
        ),
        Font(
            resId = R.font.bold,
            weight = FontWeight.W700,
            style = FontStyle.Normal
        ),
        Font(
            resId = R.font.bold_italic,
            weight = FontWeight.W700,
            style = FontStyle.Italic
        )
    )

    var h1 = TextStyle(
        fontSize = 24.sp,
        fontWeight = FontWeight.W700,
        fontStyle = FontStyle.Normal,
        fontFamily = ubuntu
    )
    var h2 = TextStyle(
        fontSize = 20.sp,
        fontWeight = FontWeight.W700,
        fontStyle = FontStyle.Normal,
        fontFamily = ubuntu
    )
    var h3 = TextStyle(
        fontSize = 16.sp,
        fontWeight = FontWeight.W700,
        fontStyle = FontStyle.Normal,
        fontFamily = ubuntu
    )
    var p1 = TextStyle(
        fontSize = 20.sp,
        fontWeight = FontWeight.W400,
        fontStyle = FontStyle.Normal,
        fontFamily = ubuntu
    )
    var p2 = TextStyle(
        fontSize = 16.sp,
        fontWeight = FontWeight.W400,
        fontStyle = FontStyle.Normal,
        fontFamily = ubuntu
    )
    var p3 = TextStyle(
        fontSize = 12.sp,
        fontWeight = FontWeight.W400,
        fontStyle = FontStyle.Normal,
        fontFamily = ubuntu
    )
    var q1 = TextStyle(
        fontSize = 20.sp,
        fontWeight = FontWeight.W400,
        fontStyle = FontStyle.Italic,
        fontFamily = ubuntu
    )
    var q2 = TextStyle(
        fontSize = 16.sp,
        fontWeight = FontWeight.W400,
        fontStyle = FontStyle.Italic,
        fontFamily = ubuntu
    )
    var q3 = TextStyle(
        fontSize = 12.sp,
        fontWeight = FontWeight.W400,
        fontStyle = FontStyle.Italic,
        fontFamily = ubuntu
    )
}