package gohryt.sapphire.animations

import android.animation.ValueAnimator
import android.os.Build
import android.view.View
import androidx.annotation.RequiresApi

@RequiresApi(Build.VERSION_CODES.R)
object Size {
    fun setHeight(view: View, currentHeight: Int, newHeight: Int, duration: Long) {
        val slideAnimator = ValueAnimator.ofInt(currentHeight, newHeight)
        slideAnimator.duration = duration
        slideAnimator.addUpdateListener { a ->
            val layoutParams = view.layoutParams
            layoutParams.height = a.animatedValue as Int
            view.layoutParams = layoutParams
        }
        slideAnimator.start()
    }
}
