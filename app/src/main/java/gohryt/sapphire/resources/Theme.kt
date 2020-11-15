package gohryt.sapphire.resources

import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.colorResource
import gohryt.sapphire.R

interface Theme {
    var iconAccent: Color
    var iconBackground: Color
    var text: Color
    var accent: Color
    var backgroundMain: Color
    var backgroundPoor: Color
}

@Composable
fun getTheme(): Theme {
    return object: Theme {
        override var iconAccent = colorResource(
                id = R.color.iconAccent
        )
        override var iconBackground = colorResource(
                id = R.color.iconBackground
        )
        override var text: Color = colorResource(
                id = R.color.text
        )
        override var accent: Color = colorResource(
                id = R.color.accent
        )
        override var backgroundMain: Color = colorResource(
                id = R.color.backgroundMain
        )
        override var backgroundPoor: Color = colorResource(
                id = R.color.backgroundPoor
        )
    }
}