package gohryt.sapphire

import android.app.ActivityManager
import android.os.Build
import android.os.Bundle
import android.provider.Settings.Secure
import android.util.DisplayMetrics
import android.view.Display
import androidx.annotation.RequiresApi
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.WindowCompat
import engine.*
import gohryt.sapphire.fragments.Login
import gohryt.sapphire.fragments.Root
import gohryt.sapphire.navigation.Navigator
import gohryt.sapphire.navigation.Route
import gohryt.sapphire.navigation.Types
import gohryt.sapphire.resources.*
import java.util.*

@RequiresApi(Build.VERSION_CODES.R)
class Activity : AppCompatActivity() {
    companion object {
        val core: CoreStruct = Engine.getCore()
        val storage: StorageStruct = Engine.getStorage()
        val session: SessionStruct = Engine.getSession()
        val properties: PropertiesStruct = Engine.getProperties()

        var memoryInfo: ActivityManager.MemoryInfo? = null
        var metrics: DisplayMetrics? = null

        var navigator: Navigator? = null
        var strings: Strings? = null
        var colors: Colors? = null
        var typefaces: Typefaces? = null
        var routes: Routes? = null
        var errors: Errors? = null
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val activityManager = getSystemService(ACTIVITY_SERVICE) as ActivityManager
        memoryInfo = ActivityManager.MemoryInfo()
        activityManager.getMemoryInfo(memoryInfo)

        val display = display as Display
        metrics = DisplayMetrics()
        display.getRealMetrics(metrics)

        navigator = Navigator(this)
        strings = Strings(this)
        colors = Colors(this)
        typefaces = Typefaces(this)
        routes = Routes(this)
        errors = Errors(this)

        core.readApplication(
            packageName,
            dataDir.absolutePath
        )
        core.readDevice(
            Build.MODEL,
            Secure.getString(contentResolver, Secure.ANDROID_ID),
            Build.SUPPORTED_ABIS[0]
        )
        core.readSystem(
            Runtime.getRuntime().availableProcessors(),
            memoryInfo!!.totalMem,
            Build.VERSION.SDK_INT,
            Build.VERSION.RELEASE,
            Locale.getDefault().language
        )
        core.readScreen(
            metrics!!.heightPixels,
            metrics!!.widthPixels
        )
        core.readRoutes(
            routes!!.login,
            routes!!.news
        )
        session.read()
        properties.read()

        window.statusBarColor = colors!!.transparent
        window.navigationBarColor = colors!!.transparent
        WindowCompat.setDecorFitsSystemWindows(window, false)

        navigator!!.add(
            Route(routes!!.login, Types.SPECIFIC) {
                Login(this)
            },
            Route(routes!!.news, Types.REGULAR) {
                Root(this)
            }
        )

        navigator!!.start(properties.defaultPage)
    }

    override fun onPause() {
        super.onPause()
        Engine.gc()
        System.gc()
    }
}