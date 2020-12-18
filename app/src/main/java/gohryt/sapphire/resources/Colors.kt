package gohryt.sapphire.resources

import android.content.Context
import android.os.Build
import androidx.annotation.RequiresApi
import androidx.core.content.ContextCompat
import gohryt.sapphire.R

@RequiresApi(Build.VERSION_CODES.R)
open class Colors(context: Context) {
    var transparent: Int = ContextCompat.getColor(context, R.color.transparent)
    var foregroundMain: Int = ContextCompat.getColor(context, R.color.foregroundMain)
    var foregroundPoor: Int = ContextCompat.getColor(context, R.color.foregroundPoor)
    var foregroundAccent: Int = ContextCompat.getColor(context, R.color.foregroundAccent)
    var backgroundMain: Int = ContextCompat.getColor(context, R.color.backgroundMain)
    var backgroundActive: Int = ContextCompat.getColor(context, R.color.backgroundActive)
    var backgroundPoor: Int = ContextCompat.getColor(context, R.color.backgroundPoor)
    var backgroundAccent: Int = ContextCompat.getColor(context, R.color.backgroundAccent)
}