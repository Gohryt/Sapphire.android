package gohryt.sapphire

import android.app.ActivityManager
import android.os.Build
import android.os.Bundle
import android.provider.Settings
import androidx.annotation.RequiresApi
import androidx.appcompat.app.AppCompatActivity
import androidx.compose.foundation.layout.ExperimentalLayout
import androidx.compose.foundation.layout.InternalLayoutApi
import androidx.compose.runtime.Immutable
import androidx.compose.ui.node.ExperimentalLayoutNodeApi
import androidx.compose.ui.platform.setContent
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import gohryt.sapphire.fragments.Auth
import gohryt.sapphire.fragments.News
import gohryt.sapphire.resources.*
import gohryt.sapphire.support.Navigation
import libgo.Libgo
import java.util.*

@Immutable
@OptIn(
    ExperimentalLayoutNodeApi::class,
    ExperimentalLayout::class,
    InternalLayoutApi::class,
    ExperimentalUnsignedTypes::class
)
@RequiresApi(Build.VERSION_CODES.R)
class Activity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val activityManager = getSystemService(ACTIVITY_SERVICE) as ActivityManager
        val memoryInfo = ActivityManager.MemoryInfo()
        activityManager.getMemoryInfo(memoryInfo)

        Libgo.configureGC(
            Runtime.getRuntime().availableProcessors(),
            memoryInfo.totalMem
        )
        val variables = Libgo.getVariables(
            applicationInfo.packageName,
            applicationInfo.dataDir,
            Build.VERSION.RELEASE,
            Build.SUPPORTED_ABIS[0],
            Build.MODEL,
            Locale.getDefault().language,
            Settings.Secure.getString(contentResolver, Settings.Secure.ANDROID_ID),
            Build.VERSION.SDK_INT,
            resources.displayMetrics.heightPixels,
            resources.displayMetrics.widthPixels
        )
        val session = Libgo.getSession()
        val propertiesCore = Libgo.getPropertiesCore()
        val propertiesUser = Libgo.getPropertiesUser()

        setContent {
            val navigation = Navigation.get()

            val colors = Colors.get()
            val typography = Typography.get()
            val strings = Strings.get()
            val icons = Icons.get()
            val shapes = Shapes.get()
            val screen = Screen.get()

            NavHost(
                navController = navigation.controller,
                startDestination = propertiesUser.defaultPage
            ) {
                composable(
                    route = navigation.auth
                ) {
                    Auth.default(
                        navigation = navigation,
                        colors = colors,
                        typography = typography,
                        strings = strings,
                        icons = icons,
                        shapes = shapes,
                        screen = screen
                    )
                }
                composable(
                    route = navigation.news
                ) {
                    News.default(
                        navigation = navigation,
                        colors = colors,
                        typography = typography,
                        strings = strings,
                        icons = icons,
                        shapes = shapes,
                        screen = screen
                    )
                }
            }
        }
    }

    override fun onStop() {
        super.onStop()
        Libgo.gc()
        System.gc()
    }
}