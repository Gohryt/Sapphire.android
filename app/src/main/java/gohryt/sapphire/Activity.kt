package gohryt.sapphire

import android.graphics.Color
import android.os.Build
import android.os.Bundle
import android.util.DisplayMetrics
import androidx.annotation.RequiresApi
import androidx.appcompat.app.AppCompatActivity
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.text.BasicText
import androidx.compose.material.Icon
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.ComposeView
import androidx.compose.ui.text.TextStyle
import androidx.core.view.WindowCompat
import gohryt.sapphire.resources.*

@RequiresApi(Build.VERSION_CODES.R)
class Activity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        val metrics = DisplayMetrics()
        display?.getRealMetrics(metrics)

        RES.run {
            strings = Strings(this@Activity)
            routes = Routes(this@Activity)
            errors = Errors(this@Activity)
            colors = Colors(this@Activity)
            icons = Icons(this@Activity)
            typefaces = Typefaces(this@Activity)
        }

        val view = ComposeView(this)
        ROOT.set(view = view) {
            Column(
                verticalArrangement = Arrangement.Center,
                horizontalAlignment = Alignment.CenterHorizontally,
                modifier = Modifier
                    .fillMaxSize()
            ) {
                Icon(
                    imageVector = RES.icons.like,
                    contentDescription = "Like",
                    tint = RES.colors.foregroundAccent
                )
                BasicText(
                    text = "Hello",
                    style = RES.typefaces.h1.merge(TextStyle(color = RES.colors.foregroundMain))
                )
            }
        }

        super.setTheme(R.style.Theme_Sapphire)
        super.onCreate(savedInstanceState)
        super.setContentView(view)
    }

    override fun onAttachedToWindow() {
        window.run {
            statusBarColor = Color.TRANSPARENT
            navigationBarColor = Color.TRANSPARENT
            WindowCompat.setDecorFitsSystemWindows(this, false)
        }

        super.onAttachedToWindow()
    }

    override fun onPause() {
        System.gc()

        super.onPause()
    }
}