package gohryt.sapphire.fragments

import androidx.compose.foundation.ScrollableColumn
import androidx.compose.foundation.layout.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import gohryt.sapphire.models.Post
import gohryt.sapphire.resources.getIcons
import gohryt.sapphire.resources.getTheme
import gohryt.sapphire.resources.getTypography

@Composable
fun News() {
    val theme = getTheme()
    val typography = getTypography()
    val icons = getIcons()
    ScrollableColumn(
        modifier = Modifier
            .padding(
                all = 5.dp
            )
            .fillMaxSize()
    )
    {
        Spacer(
            modifier = Modifier
                .fillMaxWidth()
                .height(24.dp)
        )
        for (i in 1..20) {
            Post(
                theme = theme,
                typography = typography,
                icons = icons
            )
        }
    }
}