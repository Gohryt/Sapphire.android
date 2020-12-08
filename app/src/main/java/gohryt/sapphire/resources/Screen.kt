package gohryt.sapphire.resources

import android.content.Context
import android.os.Build
import android.util.DisplayMetrics
import android.view.Display
import android.view.View
import androidx.annotation.RequiresApi
import androidx.compose.foundation.layout.ExperimentalLayout
import androidx.compose.foundation.layout.InternalLayoutApi
import androidx.compose.runtime.Ambient
import androidx.compose.runtime.Composable
import androidx.compose.runtime.Immutable
import androidx.compose.ui.node.ExperimentalLayoutNodeApi
import androidx.compose.ui.platform.AmbientContext
import androidx.compose.ui.platform.AmbientView
import androidx.compose.ui.text.InternalTextApi
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import androidx.core.content.ContextCompat
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

@Immutable
@OptIn(
    ExperimentalLayoutNodeApi::class,
    ExperimentalLayout::class,
    InternalTextApi::class,
    InternalLayoutApi::class,
    ExperimentalUnsignedTypes::class
)
@RequiresApi(Build.VERSION_CODES.R)
object Screen {
    data class Data(
        var height: Size,
        var width: Size,
        var density: Float,
        var insetTop: Size,
        var insetRight: Size,
        var insetBottom: Size,
        var insetLeft: Size
    )
    data class Size(
        var real: Int,
        var dp: Dp
    )

    @Composable
    fun get(): Data {
        val display = AmbientContext.current.display as Display
        val metrics = DisplayMetrics()
        display.getRealMetrics(metrics)
        val insets = ViewCompat.getRootWindowInsets(AmbientView.current)!!.getInsets(WindowInsetsCompat.Type.systemBars())
        return Data(
            height = Size(real = metrics.heightPixels, dp = (metrics.heightPixels / metrics.density).dp),
            width = Size(real = metrics.widthPixels, dp = (metrics.widthPixels / metrics.density).dp),
            density = metrics.density,
            insetTop = Size(real = insets.top, dp = (insets.top / metrics.density).dp),
            insetRight = Size(real = insets.right, dp = (insets.right / metrics.density).dp),
            insetBottom = Size(real = insets.bottom, dp = (insets.bottom / metrics.density).dp),
            insetLeft = Size(real = insets.left, dp = (insets.left / metrics.density).dp),
        )
    }
}