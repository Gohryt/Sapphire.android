package gohryt.sapphire.fragments

import android.os.Build
import androidx.annotation.RequiresApi
import androidx.compose.foundation.ScrollableColumn
import androidx.compose.foundation.layout.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.Immutable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.node.ExperimentalLayoutNodeApi
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import gohryt.sapphire.models.Post
import gohryt.sapphire.resources.*
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
        colors: Colors.Data,
        typography: Typography.Data,
        strings: Strings.Data,
        icons: Icons.Data,
        shapes: Shapes.Data,
        screen: Screen.Data
    ) {
        ScrollableColumn(
            modifier = Modifier
                .fillMaxSize(),
            verticalArrangement = Arrangement.SpaceBetween,
            horizontalAlignment = Alignment.CenterHorizontally
        )
        {
            Spacer(
                modifier = Modifier
                    .height(height = screen.statusBarHeight.dp)
            )
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