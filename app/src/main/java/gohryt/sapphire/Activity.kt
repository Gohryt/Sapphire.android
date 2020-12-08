package gohryt.sapphire

import android.app.ActivityManager
import android.os.Build
import android.os.Bundle
import android.provider.Settings.Secure
import android.util.DisplayMetrics
import android.view.Display
import androidx.annotation.RequiresApi
import androidx.appcompat.app.AppCompatActivity
import androidx.compose.foundation.layout.ExperimentalLayout
import androidx.compose.foundation.layout.InternalLayoutApi
import androidx.compose.runtime.Immutable
import androidx.compose.ui.node.ExperimentalLayoutNodeApi
import androidx.compose.ui.platform.setContent
import androidx.compose.ui.text.InternalTextApi
import androidx.core.view.WindowCompat
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import gohryt.sapphire.fragments.Auth
import gohryt.sapphire.fragments.News
import gohryt.sapphire.resources.*
import gohryt.sapphire.support.*
import engine.Engine

@Immutable
@OptIn(
    ExperimentalLayoutNodeApi::class,
    ExperimentalLayout::class,
    InternalTextApi::class,
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
        val display = display as Display
        val metrics = DisplayMetrics()
        display.getRealMetrics(metrics)

        Engine.initialize(
            packageName,
            dataDir.absolutePath,
            Build.MODEL,
            Secure.getString(contentResolver, Secure.ANDROID_ID),
            Build.SUPPORTED_ABIS[0],
            Runtime.getRuntime().availableProcessors(),
            memoryInfo.totalMem,
            Build.VERSION.SDK_INT,
            metrics.heightPixels,
            metrics.widthPixels
        )

        Engine.getSession()

        window.statusBarColor = getColor(R.color.transparent)
        window.navigationBarColor = getColor(R.color.transparent)
        WindowCompat.setDecorFitsSystemWindows(window, false)

        setContent {
            val navigation = Navigation.get()
            val screen = Screen.get()

            val strings = Strings.get()
            val colors = Colors.get()
            val typography = Typography.get()
            val icons = Icons.get()
            val shapes = Shapes.get()

            NavHost(
                navController = navigation.controller,
                startDestination = navigation.auth
            ) {
                composable(
                    route = navigation.auth
                ) {
                    Auth.default(
                        navigation = navigation,
                        screen = screen,
                        colors = colors,
                        typography = typography,
                        strings = strings,
                        icons = icons,
                        shapes = shapes
                    )
                }
                composable(
                    route = navigation.news
                ) {
                    News.default(
                        navigation = navigation,
                        screen = screen,
                        colors = colors,
                        typography = typography,
                        strings = strings,
                        icons = icons,
                        shapes = shapes
                    )
                }
            }
        }
    }

    override fun onPause() {
        super.onPause()
        System.gc()
        Engine.gc()
    }
}