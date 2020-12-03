package gohryt.sapphire.models

import android.os.Build
import androidx.annotation.RequiresApi
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.navigation.compose.navigate
import androidx.compose.runtime.Composable
import androidx.compose.runtime.Immutable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.node.ExperimentalLayoutNodeApi
import androidx.compose.ui.unit.dp
import gohryt.sapphire.elements.Input
import gohryt.sapphire.elements.Text
import gohryt.sapphire.layouts.Column
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
object Login {
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
        Column.default(
            modifier = Modifier
                .wrapContentSize()
                .padding(
                    start = 10.dp,
                    top = 5.dp,
                    end = 10.dp,
                    bottom = 5.dp
                )
                .background(
                    color = colors.backgroundMain,
                    shape = shapes.full
                ),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.Start
        ) {
            Text.default(
                modifier = Modifier
                    .padding(all = 5.dp)
                    .clickable(
                        onClick = {
                            navigation.controller.navigate(navigation.news)
                        }
                    ),
                text = strings.loginEnter,
                color = colors.text,
                style = typography.h1
            )
            Input.default(text = strings.loginUsername)
        }
    }
}