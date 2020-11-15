package gohryt.sapphire.models

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.BasicText
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.unit.dp
import gohryt.sapphire.resources.Icons
import gohryt.sapphire.resources.Theme
import gohryt.sapphire.resources.Typography

@Composable
fun Post(theme: Theme, typography: Typography, icons: Icons) {
    val counterState = remember {
        mutableStateOf(
            value = 0
        )
    }
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .padding(
                all = 5.dp
            )
            .background(
                color = theme.backgroundMain,
                shape = RoundedCornerShape(
                    size = 10.dp
                )
            )
    ) {
        Row(
            modifier = Modifier
                .padding(
                    all = 5.dp
                )
                .fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically
        ) {
            Row(
                horizontalArrangement = Arrangement.Start,
                verticalAlignment = Alignment.CenterVertically
            ) {
                Box(
                    modifier = Modifier
                        .padding(
                            all = 5.dp
                        )
                        .background(
                            color = theme.backgroundPoor,
                            shape = RoundedCornerShape(
                                topLeft = 10.dp,
                                bottomRight = 10.dp
                            )
                        )
                ) {
                    Image(
                        asset = icons.group,
                        modifier = Modifier
                            .padding(
                                all = 5.dp
                            )
                            .size(
                                size = 30.dp
                            )
                    )
                }
                Column(
                    modifier = Modifier
                        .padding(
                            all = 5.dp
                        ),
                    verticalArrangement = Arrangement.SpaceAround,
                    horizontalAlignment = Alignment.Start
                ) {
                    BasicText(
                        text = "Alex",
                        style = typography.h3.merge(
                            TextStyle(
                                color = theme.text
                            )
                        )
                    )
                    BasicText(
                        text = "21:39",
                        style = typography.p3.merge(
                            TextStyle(
                                color = theme.text
                            )
                        )
                    )
                }
            }
            Column(
                modifier = Modifier
                    .padding(
                        all = 5.dp
                    )
                    .clickable(onClick = { counterState.value++ }),
                verticalArrangement = Arrangement.SpaceAround,
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Image(
                    asset = icons.eye,
                    modifier = Modifier
                        .padding(
                            all = 2.5.dp
                        )
                        .size(
                            size = 17.5.dp
                        )
                )
                BasicText(
                    text = "21",
                    style = typography.p3.merge(
                        TextStyle(
                            color = theme.text
                        )
                    )
                )
            }
        }
        Box(
            modifier = Modifier
                .padding(
                    all = 5.dp
                )
                .fillMaxWidth(),
            alignment = Alignment.TopStart
        ) {
            Box(
                modifier = Modifier
                    .padding(
                        all = 5.dp
                    )
                    .fillMaxWidth(),
                alignment = Alignment.TopStart
            ) {
                BasicText(
                    text = "${counterState.value} Material is an adaptable system of guidelines, components, and tools that support the best practices of user interface design. Backed by open-source code, Material streamlines collaboration between designers and developers, and helps teams quickly build beautiful products.",
                    style = typography.p2.merge(
                        TextStyle(
                            color = theme.text
                        )
                    )
                )
            }
        }
    }
}