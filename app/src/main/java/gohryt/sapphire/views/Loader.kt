package gohryt.sapphire.views

import android.content.Context
import android.os.Build
import android.view.Gravity
import android.widget.FrameLayout
import android.widget.ProgressBar
import androidx.annotation.RequiresApi

@RequiresApi(Build.VERSION_CODES.R)
class Loader(context: Context) : FrameLayout(context) {
    val progressBar = ProgressBar(context).apply {
        layoutParams = LayoutParams(
            LayoutParams.WRAP_CONTENT,
            LayoutParams.WRAP_CONTENT,
            Gravity.CENTER
        )
    }
    init {
        addView(progressBar)
    }
}