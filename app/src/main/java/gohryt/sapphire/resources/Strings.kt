package gohryt.sapphire.resources

import android.os.Build
import androidx.annotation.RequiresApi
import androidx.compose.foundation.layout.ExperimentalLayout
import androidx.compose.foundation.layout.InternalLayoutApi
import androidx.compose.runtime.Composable
import androidx.compose.runtime.Immutable
import androidx.compose.ui.node.ExperimentalLayoutNodeApi
import androidx.compose.ui.res.stringResource
import gohryt.sapphire.R

@Immutable
@OptIn(
    ExperimentalLayoutNodeApi::class,
    ExperimentalLayout::class,
    InternalLayoutApi::class,
    ExperimentalUnsignedTypes::class
)
@RequiresApi(Build.VERSION_CODES.R)
object Strings {
    data class Data(
        var appName: String,
        var loginEnter: String,
        var loginUsername: String
    )

    @Composable
    fun get(): Data {
        return Data(
            appName = stringResource(R.string.app_name),
            loginEnter = stringResource(R.string.login_enter),
            loginUsername = stringResource(id = R.string.login_username)
        )
    }
}