package gohryt.sapphire

import android.graphics.Color
import android.os.Build
import android.os.Bundle
import android.util.DisplayMetrics
import android.util.Log
import androidx.annotation.RequiresApi
import androidx.appcompat.app.AppCompatActivity
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.material.Icon
import androidx.compose.material.Text
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.ComposeView
import androidx.core.view.ViewCompat
import androidx.core.view.WindowCompat
import androidx.core.view.WindowInsetsCompat
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
            val y = remember {
                mutableStateOf(0)
            }
            ViewCompat.setOnApplyWindowInsetsListener(view) { _, i ->
                val insets = i.getInsets(WindowInsetsCompat.Type.systemBars())
                y.value = insets.bottom
                return@setOnApplyWindowInsetsListener i
            }
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
                Text(
                    text = "Hello",
                    color = RES.colors.foregroundMain,
                    style = RES.typefaces.h1,
                    modifier = Modifier.clickable { Log.d("Log", "y = ${y.value}") }
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