package gohryt.sapphire.resources

import android.content.Context
import android.os.Build
import androidx.annotation.RequiresApi
import gohryt.sapphire.R

@RequiresApi(Build.VERSION_CODES.R)
open class Routes(context: Context) {
    val login: String = context.getString(R.string.route_login)
    val news: String = context.getString(R.string.route_news)
}