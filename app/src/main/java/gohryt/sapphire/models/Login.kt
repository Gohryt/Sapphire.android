package gohryt.sapphire.models

import android.os.Build
import androidx.annotation.RequiresApi
import androidx.navigation.compose.navigate
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.Immutable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.node.ExperimentalLayoutNodeApi
import androidx.compose.ui.text.InternalTextApi
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.unit.dp
import gohryt.sapphire.elements.Input
import gohryt.sapphire.elements.Text
import gohryt.sapphire.elements.Button
import gohryt.sapphire.layouts.Row
import gohryt.sapphire.layouts.Column
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
object Login {
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
        val username = remember {
            mutableStateOf(value = TextFieldValue(strings.loginUsername))
        }
        val password = remember {
            mutableStateOf(value = TextFieldValue(strings.loginPassword))
        }
        Column.default(
            modifier = Modifier
                .fillMaxWidth(fraction = 0.5f)
                .background(
                    color = colors.backgroundMain,
                    shape = shapes.full
                )
                .padding(4.dp)
        ) {
            Row.default(
                modifier = Modifier
                    .fillMaxWidth(),
                horizontalArrangement = Arrangement.Start,
                verticalAlignment = Alignment.CenterVertically
            ) {
                Text.default(
                    modifier = Modifier
                        .padding(top = 4.dp, end = 4.dp, bottom = 4.dp, start = 8.dp),
                    text = strings.loginEnter,
                    color = colors.foregroundMain,
                    style = typography.h1
                )
            }
            Row.default(
                modifier = Modifier
                    .fillMaxWidth(),
                horizontalArrangement = Arrangement.Start,
                verticalAlignment = Alignment.CenterVertically
            ) {
                Input.default(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(all = 4.dp),
                    target = username,
                    backgroundColor = colors.backgroundPoor,
                    shape = shapes.full,
                    color = colors.foregroundPoor,
                    style = typography.p2
                )
            }
            Row.default(
                modifier = Modifier
                    .fillMaxWidth(),
                horizontalArrangement = Arrangement.Start,
                verticalAlignment = Alignment.CenterVertically
            ) {
                Input.default(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(all = 4.dp),
                    target = password,
                    backgroundColor = colors.backgroundPoor,
                    shape = shapes.full,
                    color = colors.foregroundPoor,
                    style = typography.p2
                )
            }
            Row.default(
                modifier = Modifier
                    .fillMaxWidth(),
                horizontalArrangement = Arrangement.End,
                verticalAlignment = Alignment.CenterVertically
            ) {
                Button.default(
                    modifier = Modifier
                        .padding(all = 4.dp),
                    backgroundColor = colors.backgroundAccent,
                    shape = shapes.full,
                    text = strings.loginConfirm,
                    onclick = {navigation.controller.navigate(route = navigation.news)},
                    color = colors.foregroundAccent,
                    style = typography.h3
                )
            }
        }
    }
}