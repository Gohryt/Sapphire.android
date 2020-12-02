package gohryt.sapphire.resources

import android.os.Build
import androidx.annotation.RequiresApi
import androidx.compose.foundation.layout.ExperimentalLayout
import androidx.compose.foundation.layout.InternalLayoutApi
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.runtime.Composable
import androidx.compose.runtime.Immutable
import androidx.compose.ui.graphics.Shape
import androidx.compose.ui.node.ExperimentalLayoutNodeApi
import androidx.compose.ui.unit.dp

@Immutable
@OptIn(
    ExperimentalLayoutNodeApi::class,
    ExperimentalLayout::class,
    InternalLayoutApi::class,
    ExperimentalUnsignedTypes::class
)
@RequiresApi(Build.VERSION_CODES.R)
object Shapes {
    data class Data(
        var full: Shape,
        var topLeftBottomRight: Shape
    )

    @Composable
    fun get(): Data {
        return Data(
            full = RoundedCornerShape(size = 10.dp),
            topLeftBottomRight = RoundedCornerShape(
                topLeft = 10.dp,
                bottomRight = 10.dp
            )
        )
    }
}