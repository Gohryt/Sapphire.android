package gohryt.sapphire

import android.os.Build
import androidx.annotation.RequiresApi
import androidx.compose.runtime.Composable
import androidx.compose.ui.platform.ComposeView

@RequiresApi(Build.VERSION_CODES.R)
object ROOT {
    fun set(
        view: ComposeView,
        content: @Composable () -> Unit
    ) {
        view.setContent {
            content()
        }
    }
}