package gohryt.sapphire.resources

import android.content.Context
import android.content.res.Configuration
import android.content.res.Resources
import android.os.Build
import android.widget.Toast
import androidx.annotation.RequiresApi
import androidx.compose.runtime.Composable
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp

@RequiresApi(Build.VERSION_CODES.R)
object Screen {
    data class Data(
        var mode: Int,
        var statusBarHeight: Float,
        var statusBarHeightDp: Dp,
    )

    @Composable
    fun get(
        context: Context,
        resources: Resources
    ): Data {
        val statusBarHeight = resources.getDimension(
            resources.getIdentifier(
                "status_bar_height",
                "dimen",
                "android"
            )
        )
        val density = resources.displayMetrics.density
        return Data(
            mode = context.display!!.rotation,
            statusBarHeight = statusBarHeight,
            statusBarHeightDp = (statusBarHeight/density).dp
        )
    }
}