package gohryt.sapphire

import android.os.Build
import android.os.Bundle
import android.provider.Settings.Secure
import android.util.DisplayMetrics
import androidx.annotation.RequiresApi
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.WindowCompat
import engine.*
import gohryt.sapphire.resources.*
import java.util.*

@RequiresApi(Build.VERSION_CODES.R)
class Activity : AppCompatActivity() {
    object E {
        lateinit var core: CoreStruct
        lateinit var session: SessionStruct
        lateinit var properties: PropertiesStruct
        lateinit var storage: StorageStruct
    }

    object R {
        lateinit var strings: Strings
        lateinit var routes: Routes
        lateinit var errors: Errors
        lateinit var colors: Colors
        lateinit var typefaces: Typefaces
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val metrics = DisplayMetrics()
        display?.getRealMetrics(metrics)
        E.run {
            core = Engine.getCore().apply {
                readApplication(
                    packageName,
                    dataDir.absolutePath
                )
                readDevice(
                    Build.MODEL,
                    Secure.getString(contentResolver, Secure.ANDROID_ID),
                    Build.SUPPORTED_ABIS[0]
                )
                readSystem(
                    Build.VERSION.SDK_INT,
                    Build.VERSION.RELEASE,
                    Locale.getDefault().language
                )
                readScreen(
                    metrics.heightPixels,
                    metrics.widthPixels
                )
            }
            session = Engine.getSession().apply { read() }
            properties = Engine.getProperties().apply { read() }
            storage = Engine.getStorage()
        }
        R.run {
            strings = Strings(this@Activity)
            routes = Routes(this@Activity)
            errors = Errors(this@Activity)
            colors = Colors(this@Activity)
            typefaces = Typefaces(this@Activity)
        }
        window.run {
            statusBarColor = R.colors.transparent
            navigationBarColor = R.colors.transparent
            WindowCompat.setDecorFitsSystemWindows(this, false)
        }
    }

    override fun onPause() {
        super.onPause()
        Engine.gc()
        System.gc()
    }
}