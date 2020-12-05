package gohryt.sapphire.resources

import android.os.Build
import androidx.annotation.RequiresApi
import androidx.compose.foundation.layout.ExperimentalLayout
import androidx.compose.foundation.layout.InternalLayoutApi
import androidx.compose.runtime.Composable
import androidx.compose.runtime.Immutable
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.node.ExperimentalLayoutNodeApi
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.text.InternalTextApi
import gohryt.sapphire.R

@Immutable
@OptIn(
    ExperimentalLayoutNodeApi::class,
    ExperimentalLayout::class,
    InternalTextApi::class,
    InternalLayoutApi::class,
    ExperimentalUnsignedTypes::class
)
@RequiresApi(Build.VERSION_CODES.R)
object Colors {
    data class Data(
        var iconAccent: Color,
        var iconBackground: Color,
        var transparent: Color,
        var foregroundMain: Color,
        var foregroundPoor: Color,
        var foregroundAccent: Color,
        var backgroundMain: Color,
        var backgroundPoor: Color,
        var backgroundAccent: Color
    )

    @Composable
    fun get(): Data {
        return Data(
            iconAccent = colorResource(id = R.color.iconAccent),
            iconBackground = colorResource(id = R.color.iconBackground),
            transparent = colorResource(id = R.color.transparent),
            foregroundMain = colorResource(id = R.color.foregroundMain),
            foregroundPoor = colorResource(id = R.color.foregroundPoor),
            foregroundAccent = colorResource(id = R.color.foregroundAccent),
            backgroundMain = colorResource(id = R.color.backgroundMain),
            backgroundPoor = colorResource(id = R.color.backgroundPoor),
            backgroundAccent = colorResource(id = R.color.backgroundAccent)
        )
    }
}