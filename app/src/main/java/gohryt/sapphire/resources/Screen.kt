package gohryt.sapphire.resources

import android.os.Build
import androidx.annotation.RequiresApi
import androidx.compose.foundation.layout.ExperimentalLayout
import androidx.compose.foundation.layout.InternalLayoutApi
import androidx.compose.runtime.Composable
import androidx.compose.runtime.Immutable
import androidx.compose.ui.node.ExperimentalLayoutNodeApi
import androidx.compose.ui.platform.AmbientContext
import androidx.compose.ui.platform.AmbientView
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

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
        var top: Float,
        var right: Float,
        var bottom: Float,
        var left: Float
    )

    @Composable
    fun get(): Data {
        val density = AmbientContext.current.resources.displayMetrics.density
        val insets = ViewCompat.getRootWindowInsets(AmbientView.current)!!
            .getInsets(WindowInsetsCompat.Type.systemBars())
        return Data(
            top = insets.top / density,
            right = insets.right / density,
            bottom = insets.bottom / density,
            left = insets.left / density
        )
    }
}