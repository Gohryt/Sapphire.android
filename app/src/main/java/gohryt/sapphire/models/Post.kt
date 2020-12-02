package gohryt.sapphire.models

import android.os.Build
import androidx.annotation.RequiresApi
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.ExperimentalLayout
import androidx.compose.foundation.layout.InternalLayoutApi
import androidx.compose.foundation.layout.size
import androidx.compose.runtime.Composable
import androidx.compose.runtime.Immutable
import androidx.compose.ui.Modifier
import androidx.compose.ui.node.ExperimentalLayoutNodeApi
import androidx.compose.ui.unit.dp
import gohryt.sapphire.elements.Icon
import gohryt.sapphire.resources.Icons
import gohryt.sapphire.resources.Colors
import gohryt.sapphire.resources.Shapes
import gohryt.sapphire.resources.Typography

@Immutable
@OptIn(
    ExperimentalLayoutNodeApi::class,
    ExperimentalLayout::class,
    InternalLayoutApi::class,
    ExperimentalUnsignedTypes::class
)
@RequiresApi(Build.VERSION_CODES.R)
object Post {
    @Composable
    fun default(
        colors: Colors.Data,
        typography: Typography.Data,
        icons: Icons.Data,
        shapes: Shapes.Data
    ) {
        Icon.default(
            asset = icons.eye,
            modifier = Modifier.background(color = colors.accent).size(size = 40.dp)
        )
    }
}
/*
@Preview
@Composable
@RequiresApi(Build.VERSION_CODES.R)
fun Pw() {
    Post.Default(
        Colors.get(),
        Typography.get(),
        Icons.get(),
        Shapes.get()
    )
}
 */