package gohryt.sapphire.support

import android.graphics.Color
import android.view.View
import android.view.Window
import android.view.WindowManager
import androidx.compose.runtime.Composable

object TransparentStatus {
    @Composable
    fun Make(
        window: Window
    ) {
        window.clearFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS)
        window.addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS)
        val option = window.decorView.systemUiVisibility or View.SYSTEM_UI_FLAG_LAYOUT_STABLE or View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN
        window.decorView.systemUiVisibility = option
        window.statusBarColor = Color.TRANSPARENT
    }
}