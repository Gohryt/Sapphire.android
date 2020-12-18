package gohryt.sapphire.resources

import android.content.Context
import android.graphics.Typeface
import android.os.Build
import androidx.annotation.RequiresApi

@RequiresApi(Build.VERSION_CODES.R)
open class Typefaces(context: Context) {
    val light: Typeface = Typeface.createFromAsset(context.assets, "fonts/light.ttf")
    val lightItalic: Typeface = Typeface.createFromAsset(context.assets, "fonts/light_italic.ttf")
    val regular: Typeface = Typeface.createFromAsset(context.assets, "fonts/regular.ttf")
    val regularItalic: Typeface = Typeface.createFromAsset(context.assets, "fonts/regular_italic.ttf")
    val medium: Typeface = Typeface.createFromAsset(context.assets, "fonts/medium.ttf")
    val mediumItalic: Typeface = Typeface.createFromAsset(context.assets, "fonts/medium_italic.ttf")
    val bold: Typeface = Typeface.createFromAsset(context.assets, "fonts/bold.ttf")
    val boldItalic: Typeface = Typeface.createFromAsset(context.assets, "fonts/bold_italic.ttf")
}