package gohryt.sapphire.resources

import android.os.Build
import androidx.annotation.RequiresApi
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.vector.VectorAsset
import androidx.compose.ui.res.vectorResource
import gohryt.sapphire.R

@RequiresApi(Build.VERSION_CODES.R)
object Icons {
    data class Data(
        var eye: VectorAsset,
        var group: VectorAsset
    )

    @Composable
    fun get(): Data {
        return Data(
            eye = vectorResource(
                id = R.drawable.icon_eye
            ),
            group = vectorResource(
                id = R.drawable.icon_group
            )
        )
    }
}