package gohryt.sapphire.animations

import android.animation.ValueAnimator
import android.os.Build
import android.view.View
import androidx.annotation.RequiresApi

@RequiresApi(Build.VERSION_CODES.R)
object Size {
    fun setHeight(view: View, newHeight: Int, newDuration: Long) {
        ValueAnimator.ofInt(view.measuredHeight, newHeight).run {
            duration = newDuration
            addUpdateListener { a ->
                val layoutParams = view.layoutParams
                layoutParams.height = a.animatedValue as Int
                view.layoutParams = layoutParams
            }
            start()
        }
    }
}
