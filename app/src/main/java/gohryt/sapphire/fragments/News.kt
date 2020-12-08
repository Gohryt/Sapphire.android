package gohryt.sapphire.fragments

import android.os.Build
import androidx.annotation.RequiresApi
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.node.ExperimentalLayoutNodeApi
import androidx.compose.ui.text.InternalTextApi
import androidx.compose.ui.unit.dp
import gohryt.sapphire.resources.*
import gohryt.sapphire.layouts.Spacer
import gohryt.sapphire.layouts.Row
import gohryt.sapphire.layouts.Column
import gohryt.sapphire.models.Post
import gohryt.sapphire.support.Navigation

@Immutable
@OptIn(
    ExperimentalLayoutNodeApi::class,
    ExperimentalLayout::class,
    InternalTextApi::class,
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
        Row.default {
            if (screen.insetLeft.real > 0) {
                Spacer.default(
                    modifier = Modifier
                        .fillMaxHeight()
                        .width(width = screen.insetLeft.dp)
                )
            }
            Column.default(
                modifier = Modifier
                    .fillMaxHeight()
                    .weight(1f)
            ) {
                Column.lazy(
                    items = listOf(
                        true,
                        false,
                        false,
                        false,
                        false,
                        true,
                        false,
                        false,
                        false,
                        false,
                        true,
                        false,
                        false,
                        false,
                        false,
                        true,
                        false,
                        false,
                        false,
                        false
                    ),
                    modifier = Modifier
                        .weight(1f)
                        .fillMaxWidth(),
                    horizontalAlignment = Alignment.CenterHorizontally
                ) { item ->
                    if (item && screen.insetTop.real > 0) {
                        Spacer.default(
                            modifier = Modifier
                                .height(height = screen.insetTop.dp)
                                .fillMaxWidth()
                        )
                    }
                    Post.default(
                        navigation = navigation,
                        screen = screen,
                        colors = colors,
                        typography = typography,
                        strings = strings,
                        icons = icons,
                        shapes = shapes
                    )
                }
                if (screen.insetBottom.real > 0) {
                    Spacer.default(
                        modifier = Modifier
                            .height(height = screen.insetBottom.dp)
                            .fillMaxWidth()
                            .background(color = colors.backgroundMain)
                    )
                }
            }
            if (screen.insetRight.real > 0) {
                Spacer.default(
                    modifier = Modifier
                        .fillMaxHeight()
                        .width(width = screen.insetRight.dp)
                )
            }
        }
    }
}