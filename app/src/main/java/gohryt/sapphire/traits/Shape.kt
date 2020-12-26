package gohryt.sapphire.traits

import android.graphics.drawable.ShapeDrawable
import android.graphics.drawable.shapes.RoundRectShape
import android.os.Build
import androidx.annotation.RequiresApi

@RequiresApi(Build.VERSION_CODES.R)
class Shape(color: Int, tl: Float, tr: Float, br: Float, bl: Float) : ShapeDrawable() {
    init {
        this.shape = RoundRectShape(floatArrayOf(tl, tl, tr, tr, br, br, bl, bl), null, null)
        this.paint.color = color
    }

    constructor(
        color: Int,
        all: Float
    ) : this(color, all, all, all, all)

    constructor(
        color: Int,
    ) : this(color, 0f)
}
