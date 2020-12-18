package gohryt.sapphire.fragments

import android.content.Context
import android.os.Build
import android.widget.LinearLayout
import androidx.annotation.RequiresApi

@RequiresApi(Build.VERSION_CODES.R)
class Root(context: Context): LinearLayout(context) {
    init {
        this.layoutParams = LayoutParams(
            LayoutParams.MATCH_PARENT,
            LayoutParams.MATCH_PARENT
        )
    }
}