package gohryt.sapphire.resources

import android.os.Build
import androidx.annotation.RequiresApi
import androidx.compose.foundation.layout.ExperimentalLayout
import androidx.compose.foundation.layout.InternalLayoutApi
import androidx.compose.runtime.Composable
import androidx.compose.runtime.Immutable
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.node.ExperimentalLayoutNodeApi
import androidx.compose.ui.res.vectorResource
import gohryt.sapphire.R

@Immutable
@OptIn(
    ExperimentalLayoutNodeApi::class,
    ExperimentalLayout::class,
    InternalLayoutApi::class,
    ExperimentalUnsignedTypes::class
)
@RequiresApi(Build.VERSION_CODES.R)
object Icons {
    data class Data(
        var group: ImageVector,
        var eye: ImageVector,
        var share: ImageVector,
        var comment: ImageVector,
        var like: ImageVector
    )

    @Composable
    fun get(): Data {
        return Data(
            group = vectorResource(id = R.drawable.icon_group),
            eye = vectorResource(id = R.drawable.icon_eye),
            share = vectorResource(id = R.drawable.icon_share),
            comment = vectorResource(id = R.drawable.icon_comment),
            like = vectorResource(id = R.drawable.icon_like)
        )
    }
}