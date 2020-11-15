package gohryt.sapphire.resources

import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.vector.VectorAsset
import androidx.compose.ui.res.vectorResource
import gohryt.sapphire.R

interface Icons {
    var eye: VectorAsset
    var group: VectorAsset
}

@Composable
fun getIcons(): Icons {
    return object : Icons {
        override var eye = vectorResource(
            id = R.drawable.icon_eye
        )
        override var group = vectorResource(
            id = R.drawable.icon_group
        )
    }
}