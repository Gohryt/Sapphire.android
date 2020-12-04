package gohryt.sapphire.fragments

import android.os.Build
import androidx.annotation.RequiresApi
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.runtime.Composable
import androidx.compose.runtime.Immutable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.node.ExperimentalLayoutNodeApi
import androidx.compose.ui.unit.dp
import gohryt.sapphire.resources.*
import gohryt.sapphire.layouts.Spacer
import gohryt.sapphire.layouts.Column
import gohryt.sapphire.models.Post
import gohryt.sapphire.support.Navigation

@Immutable
@OptIn(
    ExperimentalLayoutNodeApi::class,
    ExperimentalLayout::class,
    InternalLayoutApi::class,
    ExperimentalUnsignedTypes::class
)
@RequiresApi(Build.VERSION_CODES.R)
object News {
    @Composable
    fun default(
        navigation: Navigation.Data,
        screen: Screen.Data,
        strings: Strings.Data,
        colors: Colors.Data,
        typography: Typography.Data,
        icons: Icons.Data,
        shapes: Shapes.Data
    ) {
        Column.scrollable(
            modifier = Modifier
                .height(592.dp)
                .fillMaxWidth(),
            verticalArrangement = Arrangement.SpaceBetween,
            horizontalAlignment = Alignment.CenterHorizontally
        )
        {
            if (screen.top > 0) {
                Spacer.default(
                    modifier = Modifier
                        .height(height = screen.top.dp)
                        .fillMaxWidth()
                )
            }
            for (i in 1..20) {
                Post.default(
                    colors = colors,
                    typography = typography,
                    icons = icons,
                    shapes = shapes
                )
            }
        }
    }
}