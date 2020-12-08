package gohryt.sapphire.resources

import android.content.Context
import android.os.Build
import androidx.annotation.RequiresApi
import androidx.compose.foundation.layout.ExperimentalLayout
import androidx.compose.foundation.layout.InternalLayoutApi
import androidx.compose.runtime.Composable
import androidx.compose.runtime.Immutable
import androidx.compose.ui.node.ExperimentalLayoutNodeApi
import androidx.compose.ui.platform.AmbientContext
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.InternalTextApi
import gohryt.sapphire.R

@Immutable
@OptIn(
    ExperimentalLayoutNodeApi::class,
    ExperimentalLayout::class,
    InternalTextApi::class,
    InternalLayoutApi::class,
    ExperimentalUnsignedTypes::class
)
@RequiresApi(Build.VERSION_CODES.R)
object Strings {
    data class Data(
        var appName: String,
        var loginEnter: String,
        var loginUsername: String,
        var loginPassword: String,
        var loginConfirm: String
    )

    @Composable
    fun get(): Data {
        return Data(
            appName = stringResource(R.string.app_name),
            loginEnter = stringResource(R.string.login_enter),
            loginUsername = stringResource(R.string.login_username),
            loginPassword = stringResource(R.string.login_password),
            loginConfirm = stringResource(R.string.login_confirm)
        )
    }
}