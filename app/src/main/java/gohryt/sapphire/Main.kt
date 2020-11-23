package gohryt.sapphire

import android.app.ActivityManager
import android.content.Context
import android.content.res.Resources
import android.os.Build
import android.os.Bundle
import android.provider.Settings
import androidx.annotation.RequiresApi
import androidx.appcompat.app.AppCompatActivity
import androidx.compose.ui.platform.ContextAmbient
import androidx.compose.ui.platform.setContent
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import gohryt.sapphire.fragments.Auth
import gohryt.sapphire.fragments.News
import gohryt.sapphire.resources.Colors
import gohryt.sapphire.resources.Icons
import gohryt.sapphire.resources.Screen
import gohryt.sapphire.resources.Typography
import gohryt.sapphire.support.TransparentStatus
import libgo.Libgo
import java.util.*

@RequiresApi(Build.VERSION_CODES.R)
class Main : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            TransparentStatus.Make(
                window = window
            )

            val activityManager = getSystemService(ACTIVITY_SERVICE) as ActivityManager
            val context: Context = ContextAmbient.current
            val resources: Resources = context.resources

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

            val colors = Colors.get()
            val typography = Typography.get()
            val icons = Icons.get()
            val screen = Screen.get(
                context = context,
                resources = resources
            )

            val navController = rememberNavController()

            NavHost(
                navController = navController,
                startDestination = propertiesUser.defaultPage
            ) {
                composable(
                    route = "Auth"
                ) {
                    Auth.Default(
                        navController = navController,
                        context = context,
                        resources = resources,
                        screen = screen,
                        colors = colors,
                        typography = typography,
                        icons = icons
                    )
                }
                composable(
                    route = "News"
                ) {
                    News.Default(
                        navController = navController,
                        context = context,
                        resources = resources,
                        screen = screen,
                        colors = colors,
                        typography = typography,
                        icons = icons
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