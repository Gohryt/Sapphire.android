package gohryt.sapphire.resources

import android.content.Context
import android.os.Build
import androidx.annotation.RequiresApi
import gohryt.sapphire.R

@RequiresApi(Build.VERSION_CODES.R)
open class Strings(context: Context) {
    val applicationName: String = context.getString(R.string.application_name)
    val loginEnter: String = context.getString(R.string.login_enter)
    val loginUsername: String = context.getString(R.string.login_username)
    val loginPassword: String = context.getString(R.string.login_password)
    val loginConfirm: String = context.getString(R.string.login_confirm)
}