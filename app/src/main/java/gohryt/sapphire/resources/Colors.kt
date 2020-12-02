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
import gohryt.sapphire.R

@Immutable
@OptIn(
    ExperimentalLayoutNodeApi::class,
    ExperimentalLayout::class,
    InternalLayoutApi::class,
    ExperimentalUnsignedTypes::class
)
@RequiresApi(Build.VERSION_CODES.R)
object Colors {
    data class Data(
        var iconAccent: Color,
        var iconBackground: Color,
        var navigationBarLegacy: Color,
        var transparent: Color,
        var text: Color,
        var accent: Color,
        var backgroundMain: Color,
        var backgroundPoor: Color
    )

    @Composable
    fun get(): Data {
        return Data(
            iconAccent = colorResource(id = R.color.iconAccent),
            iconBackground = colorResource(id = R.color.iconBackground),
            navigationBarLegacy = colorResource(id = R.color.navigationBarLegacy),
            transparent = colorResource(id = R.color.transparent),
            text = colorResource(id = R.color.text),
            accent = colorResource(id = R.color.accent),
            backgroundMain = colorResource(id = R.color.backgroundMain),
            backgroundPoor = colorResource(id = R.color.backgroundPoor)
        )
    }
}