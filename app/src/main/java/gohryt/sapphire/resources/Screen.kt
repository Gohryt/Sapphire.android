package gohryt.sapphire.resources

import android.os.Build
import androidx.annotation.RequiresApi
import androidx.compose.foundation.layout.ExperimentalLayout
import androidx.compose.foundation.layout.InternalLayoutApi
import androidx.compose.runtime.Composable
import androidx.compose.runtime.Immutable
import androidx.compose.ui.node.ExperimentalLayoutNodeApi
import androidx.compose.ui.platform.ContextAmbient

@Immutable
@OptIn(
    ExperimentalLayoutNodeApi::class,
    ExperimentalLayout::class,
    InternalLayoutApi::class,
    ExperimentalUnsignedTypes::class
)
@RequiresApi(Build.VERSION_CODES.R)
object Screen {
    data class Data(
        var statusBarHeight: Float,
        var density: Float
    )

    @Composable
    fun get(): Data {
        val resources = ContextAmbient.current.resources
        val statusBarHeight = resources.getDimension(
            resources.getIdentifier(
                "status_bar_height",
                "dimen",
                "android"
            )
        )
        val density = resources.displayMetrics.density
        return Data(
            statusBarHeight = statusBarHeight / density,
            density = density
        )
    }
}