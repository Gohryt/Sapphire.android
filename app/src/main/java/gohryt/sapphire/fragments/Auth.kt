package gohryt.sapphire.fragments

import android.os.Build
import androidx.annotation.RequiresApi
import androidx.compose.foundation.layout.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.Immutable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.node.ExperimentalLayoutNodeApi
import androidx.compose.ui.text.InternalTextApi
import androidx.compose.ui.unit.dp
import gohryt.sapphire.layouts.Column
import gohryt.sapphire.layouts.Row
import gohryt.sapphire.layouts.Spacer
import gohryt.sapphire.models.Login
import gohryt.sapphire.resources.*
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
object Auth {
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
            if (screen.left >0) {
                Spacer.default(
                    modifier = Modifier
                        .fillMaxHeight()
                        .width(width = screen.left.dp)
                )
            }
            Column.default(
                modifier = Modifier
                    .fillMaxHeight()
                    .weight(1f)
            ) {
                Column.scrollable(
                    modifier = Modifier
                        .weight(1f)
                        .fillMaxWidth(),
                    verticalArrangement = Arrangement.Top,
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
                    Column.default(
                        modifier = Modifier
                            .weight(1f)
                            .fillMaxWidth(),
                        verticalArrangement = Arrangement.Center,
                        horizontalAlignment = Alignment.CenterHorizontally
                    ) {
                        Login.default(
                            navigation = navigation,
                            screen = screen,
                            colors = colors,
                            typography = typography,
                            strings = strings,
                            icons = icons,
                            shapes = shapes
                        )
                    }
                }
                if (screen.bottom > 0) {
                    Spacer.default(
                        modifier = Modifier
                            .height(height = screen.bottom.dp)
                            .fillMaxWidth()
                    )
                }
            }
            if (screen.right >0) {
                Spacer.default(
                    modifier = Modifier
                        .fillMaxHeight()
                        .width(width = screen.right.dp)
                )
            }
        }
    }
}