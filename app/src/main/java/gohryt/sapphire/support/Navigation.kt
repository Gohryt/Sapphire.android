package gohryt.sapphire.support

import android.os.Build
import androidx.annotation.RequiresApi
import androidx.compose.foundation.layout.ExperimentalLayout
import androidx.compose.foundation.layout.InternalLayoutApi
import androidx.compose.runtime.Composable
import androidx.compose.runtime.Immutable
import androidx.compose.ui.node.ExperimentalLayoutNodeApi
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController

@Immutable
@OptIn(
    ExperimentalLayoutNodeApi::class,
    ExperimentalLayout::class,
    InternalLayoutApi::class,
    ExperimentalUnsignedTypes::class
)
@RequiresApi(Build.VERSION_CODES.R)
object Navigation {
    data class Data(
        val controller: NavHostController,
        val auth: String,
        val news: String
    )
    @Composable
    fun get(): Data {
        return Data(
            controller = rememberNavController(),
            auth = "Auth",
            news ="News"
        )
    }
}