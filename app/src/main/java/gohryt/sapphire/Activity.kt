package gohryt.sapphire

import android.graphics.BlendMode
import android.graphics.BlendModeColorFilter
import android.graphics.Color
import android.os.Build
import android.os.Bundle
import android.util.DisplayMetrics
import androidx.annotation.RequiresApi
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.WindowCompat
import engine.*
import gohryt.sapphire.resources.*
import gohryt.sapphire.views.Loader
import java.util.*

@RequiresApi(Build.VERSION_CODES.R)
class Activity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        window.run {
            statusBarColor = Color.TRANSPARENT
            navigationBarColor = Color.TRANSPARENT
            WindowCompat.setDecorFitsSystemWindows(this, false)
        }

        val l = Loader(this@Activity)
        super.setContentView(l)

        val metrics = DisplayMetrics()
        display?.getRealMetrics(metrics)

        E.run {
            core = Engine.getCore()
            session = Engine.getSession()
            properties = Engine.getProperties()
            storage = Engine.getStorage()
        }

        I.run {
            strings = Strings(this@Activity)
            routes = Routes(this@Activity)
            errors = Errors(this@Activity)
            colors = Colors(this@Activity)
            typefaces = Typefaces(this@Activity)
        }
    }

    override fun onPause() {
        super.onPause()
        Engine.gc()
        System.gc()
    }
}