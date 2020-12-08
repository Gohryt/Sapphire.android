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
            transparent = colorResource(R.color.transparent),
            foregroundMain = colorResource(R.color.foregroundMain),
            foregroundPoor = colorResource(R.color.foregroundPoor),
            foregroundAccent = colorResource(R.color.foregroundAccent),
            backgroundMain = colorResource(R.color.backgroundMain),
            backgroundPoor = colorResource(R.color.backgroundPoor),
            backgroundAccent = colorResource(R.color.backgroundAccent)
        )
    }
}