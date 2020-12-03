package gohryt.sapphire.fragments

import android.os.Build
import androidx.annotation.RequiresApi
import androidx.compose.foundation.layout.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.Immutable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.node.ExperimentalLayoutNodeApi
import androidx.compose.ui.unit.dp
import gohryt.sapphire.layouts.Column
import gohryt.sapphire.layouts.Spacer
import gohryt.sapphire.models.Login
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
object Auth {
    @Composable
    fun default(
        navigation: Navigation.Data,
        colors: Colors.Data,
        typography: Typography.Data,
        strings: Strings.Data,
        icons: Icons.Data,
        shapes: Shapes.Data
    ) {
        Column.scrollable(
            modifier = Modifier
                .fillMaxSize(),
            verticalArrangement = Arrangement.SpaceBetween,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Spacer.default(
                modifier = Modifier
                    .height(height = 5.dp)
            )
            Login.default(
                navigation = navigation,
                colors = colors,
                typography = typography,
                strings = strings,
                icons = icons,
                shapes = shapes
            )
            Spacer.default(
                modifier = Modifier
                    .height(height = 5.dp)
            )
        }
    }
}