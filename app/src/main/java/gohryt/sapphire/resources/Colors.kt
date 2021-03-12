package gohryt.sapphire.resources

import android.content.Context
import android.os.Build
import androidx.annotation.RequiresApi
import androidx.compose.ui.graphics.Color
import androidx.core.content.ContextCompat
import gohryt.sapphire.R

@RequiresApi(Build.VERSION_CODES.R)
open class Colors(context: Context) {
    var transparent: Color = Color(ContextCompat.getColor(context, R.color.transparent))
    var foregroundMain: Color = Color(ContextCompat.getColor(context, R.color.foregroundMain))
    var foregroundPoor: Color = Color(ContextCompat.getColor(context, R.color.foregroundPoor))
    var foregroundAccent: Color = Color(ContextCompat.getColor(context, R.color.foregroundAccent))
    var backgroundMain: Color = Color(ContextCompat.getColor(context, R.color.backgroundMain))
    var backgroundActive: Color = Color(ContextCompat.getColor(context, R.color.backgroundActive))
    var backgroundPoor: Color = Color(ContextCompat.getColor(context, R.color.backgroundPoor))
    var backgroundAccent: Color = Color(ContextCompat.getColor(context, R.color.backgroundAccent))
}